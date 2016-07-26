package model.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class Variable extends AbstractNode {
    private String        name;
    private List<Integer> dimensions;

    public Variable(VarList parent) {
        this(parent, null);
    }

    public Variable(VarList parent, String name) {
        super(parent);
        this.name = name;
        this.dimensions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArray() {
        return !this.dimensions.isEmpty();
    }

    public List<Integer> getDimensions() {
        return dimensions;
    }

    public void addDimension(int dim) {
        this.dimensions.add(dim);
    }
}
