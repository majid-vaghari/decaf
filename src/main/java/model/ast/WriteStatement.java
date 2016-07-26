package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/27/2016.
 */
public class WriteStatement extends Statement {
    private Types type;

    public WriteStatement(Block parent, Types type) {
        super(parent);
        this.type = type;
    }

    public Types getType() {
        return type;
    }
}
