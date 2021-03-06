package model;

import model.type.Types;

/**
 * Created by Majid Vaghari on 4/2/2016.
 */
public class BooleanLiteral extends Literal {
    public BooleanLiteral(String value, int line, int column) {
        super(Boolean.valueOf(value).toString(), line, column);
    }

    @Override
    public Types getType() {
        return Types.BOOLEAN;
    }
}
