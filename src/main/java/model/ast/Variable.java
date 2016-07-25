package model.ast;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class Variable extends AbstractNode {
    private int dimensionLength;

    public Variable(VarList parent) {
        this(parent, 1);
    }

    public Variable(VarList parent, int dimensionLength) {
        super(parent);
        this.dimensionLength = dimensionLength > 0 && !(parent instanceof ParamList) ? dimensionLength : 1;
    }

    public boolean isArray() {
        return this.dimensionLength > 1;
    }

    public int getDimensionLength() {
        return dimensionLength;
    }
}
