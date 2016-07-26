package model.descriptors;

import model.ast.Function;
import model.ast.Node;
import model.ast.Parameter;
import model.ast.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public final class SymbolTable {
    private static final SymbolTable SYMBOL_TABLE;

    static {
        SYMBOL_TABLE = new SymbolTable();
    }

    private final List<Descriptor> table;
    private       int              level;

    private SymbolTable() {
        this.table = new ArrayList<>();
        this.level = 0;
    }

    public static SymbolTable getInstance() {
        return SYMBOL_TABLE;
    }

    public void openScope() {
        level++;
    }

    public void closeScope() {
        getTable().removeIf(e -> e.getLevel() == level);
        level--;
    }

    public List<Descriptor> getTable() {
        return table;
    }

    public void add(Node node) throws DuplicateDefinitionException {
        if (node == null)
            return;

        if (node instanceof Function) {
            if (getFunction(((Function) node).getName()).isPresent())
                throw new DuplicateDefinitionException(((Function) node).getName());
            getTable().add(new FunctionDescriptor((Function) node, getCurrentLevel()));
        } else if (node instanceof Variable) {
            if (level == 0) {
                if (getGlobal(((Variable) node).getName()).isPresent())
                    throw new DuplicateDefinitionException(((Variable) node).getName());
                getTable().add(new GlobalDescriptor(((Variable) node), getCurrentLevel()));
            } else {
                if (getLocal(((Variable) node).getName()).isPresent())
                    throw new DuplicateDefinitionException(((Variable) node).getName());
                getTable().add(new LocalDescriptor(((Variable) node), getCurrentLevel()));
            }
        } else if (node instanceof Parameter) {
            if (getParameter(((Parameter) node).getName()).isPresent())
                throw new DuplicateDefinitionException(((Parameter) node).getName());
            getTable().add(new ParameterDescriptor(((Parameter) node), getCurrentLevel()));
        }
    }

    public Optional<Descriptor> getFunction(String id) {
        return getTable().stream()
                         .filter(e -> e.getId().equals(id))
                         .filter(e -> e instanceof FunctionDescriptor)
                         .findAny();
    }

    public int getCurrentLevel() {
        return level;
    }

    public Optional<Descriptor> getGlobal(String id) {
        return getTable().stream()
                         .filter(e -> e.getId().equals(id))
                         .filter(e -> e instanceof GlobalDescriptor)
                         .findAny();
    }

    public Optional<Descriptor> getLocal(String id) {
        return getTable().stream()
                         .filter(e -> e.getId().equals(id))
                         .filter(e -> e instanceof LocalDescriptor)
                         .findAny();
    }

    public Optional<Descriptor> getParameter(String id) {
        return getTable().stream()
                         .filter(e -> e.getId().equals(id))
                         .filter(e -> e instanceof ParameterDescriptor)
                         .findAny();
    }
}
