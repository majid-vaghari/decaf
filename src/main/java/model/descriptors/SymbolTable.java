package model.descriptors;

import model.ast.Function;
import model.ast.Node;
import model.ast.Parameter;
import model.ast.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Descriptor> get(String id) {
        return getTable().stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
    }

    public void add(Node node) {
        if (node == null)
            return;

        if (node instanceof Function)
            getTable().add(new FunctionDescriptor((Function) node, getCurrentLevel()));
        else if (node instanceof Variable) {
            if (level == 0)
                getTable().add(new GlobalDescriptor(((Variable) node), getCurrentLevel()));
            else
                getTable().add(new LocalDescriptor(((Variable) node), getCurrentLevel()));
        } else if (node instanceof Parameter)
            getTable().add(new ParameterDescriptor(((Parameter) node), getCurrentLevel()));
    }

    public int getCurrentLevel() {
        return level;
    }
}
