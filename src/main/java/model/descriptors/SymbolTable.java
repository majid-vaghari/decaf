package model.descriptors;

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
}
