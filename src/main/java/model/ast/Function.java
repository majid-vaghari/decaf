package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class Function extends AbstractNode {
    private Types  returnType;
    private String name;

    public Function(Node parent) {
        super(parent);
    }

    public Function(Node parent, Types returnType, String name) {
        super(parent);
        this.returnType = returnType;
        this.name = name;
    }

    public Types getReturnType() {
        return returnType;
    }

    public void setReturnType(Types returnType) {
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}