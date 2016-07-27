package model.ast;

import model.Symbols;
import model.type.Types;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class Expression extends AbstractNode {
    private Symbols operation;
    private Types   type;

    public Expression(Node parent) {
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

    public Types getType() {
        return type;
    }

    public void setType(Types type) throws TypeMismatchException {
        if (this.type != null && this.type != type)
            throw new TypeMismatchException(this.type, type);
        this.type = type;
    }
}
