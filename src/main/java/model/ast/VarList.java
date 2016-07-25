package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class VarList extends AbstractNode {
    private Types type;

    public VarList(Node parent, Types type) {
        super(parent);
        this.type = type;
    }
}
