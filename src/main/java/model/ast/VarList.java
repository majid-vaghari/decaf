package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class VarList extends AbstractNode {
    private Types type;

    public VarList(VariableDeclaration parent) {
        super(parent);
    }

    public VarList(VariableDeclaration parent, Types type) {
        super(parent);
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
