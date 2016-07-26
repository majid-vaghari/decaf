package model.ast;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class Variable extends AbstractNode {
    private String name;
    private int    dimensionLength;

    public Variable(VarList parent) {
        this(parent, null, 1);
    }

    public Variable(VarList parent, String name, int dimensionLength) {
        super(parent);
        this.name = name;
        this.dimensionLength = dimensionLength > 0 ? dimensionLength : 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArray() {
        return this.dimensionLength > 1;
    }

    public int getDimensionLength() {
        return dimensionLength;
    }
}
