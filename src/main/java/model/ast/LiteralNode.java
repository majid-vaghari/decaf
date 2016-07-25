package model.ast;

import model.Literal;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class LiteralNode extends Expression {
    private Literal literal;

    public LiteralNode(Expression parent) {
        super(parent);
    }

    public LiteralNode(Expression parent, Literal literal) {
        super(parent);
        this.literal = literal;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
    }
}
