package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/26/2016.
 */
public class Parameter extends AbstractNode {
    private Types type;

    public Parameter(Node parent) {
        super(parent);
    }

    public Parameter(Node parent, Types type) {
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
