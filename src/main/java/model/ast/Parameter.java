package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/26/2016.
 */
public class Parameter extends AbstractNode {
    private Types  type;
    private String name;

    public Parameter(ParamList parent) {
        super(parent);
    }

    public Parameter(ParamList parent, Types type, String name) {
        super(parent);
        this.type = type;
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
