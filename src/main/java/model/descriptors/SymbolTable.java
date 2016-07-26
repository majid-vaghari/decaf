package model.descriptors;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class SymbolTable {
    private static final SymbolTable SYMBOL_TABLE;

    static {
        SYMBOL_TABLE = new SymbolTable();
    }

    private final Map<String, Descriptor> table;
    private       int                     level;

    private SymbolTable() {
        this.table = new HashMap<>();
        this.level = 0;
    }

    public static SymbolTable getInstance() {
        return SYMBOL_TABLE;
    }

    public void openScope() {
        level++;
    }

    public void closeScope() {
        getTable().entrySet().removeIf(e -> e.getValue().getLevel() == level);
        level--;
    }

    public Map<String, Descriptor> getTable() {
        return table;
    }

}
