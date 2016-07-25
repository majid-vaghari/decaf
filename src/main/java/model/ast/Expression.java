package model.ast;

import model.Symbols;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class Expression extends AbstractNode {
    private Symbols operation;

    public Expression(Expression parent) {
        super(parent);
    }

    public Expression(Node parent, Symbols operation) {
        super(parent);
        this.operation = operation;
    }

    public Symbols getOperation() {
        return operation;
    }

    public void setOperation(Symbols operation) {
        this.operation = operation;
    }
}
