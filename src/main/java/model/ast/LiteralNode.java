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

    public LiteralNode(Expression parent, Literal literal) throws TypeMismatchException {
        super(parent);
        setLiteral(literal);
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) throws TypeMismatchException {
        this.literal = literal;
        super.setType(literal.getType());
    }
}
