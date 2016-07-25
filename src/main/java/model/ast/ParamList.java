package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class ParamList extends VarList {
    public ParamList(Function parent, Types type) {
        super(parent, type);
    }
}
