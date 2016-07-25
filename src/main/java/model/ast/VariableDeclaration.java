package model.ast;

import model.type.ArrayType;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class VariableDeclaration extends AbstractNode {
    private Type type;

    public VariableDeclaration(Node parent) {
        super(parent);
    }

    public VariableDeclaration(Node parent, ArrayType type) {
        super(parent);
        this.type = type;
    }

    public ArrayType getType() {
        return type;
    }

    public void setType(ArrayType type) {
        this.type = type;
    }
}
