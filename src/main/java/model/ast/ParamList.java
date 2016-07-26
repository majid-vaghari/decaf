package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class ParamList extends AbstractNode {
    public ParamList(Function parent) {
        super(parent);
    }

    public ParamList(Function parent, Types type) {
        super(parent);
    }
}
