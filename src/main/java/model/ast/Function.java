package model.ast;

import model.type.ArrayType;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class Function extends AbstractNode {
    private ArrayType inputType;
    private ArrayType returnType;
    private String    name;

    public Function(Node parent) {
        super(parent);
    }

    public Function(Node parent, ArrayType inputType, ArrayType returnType, String name) {
        super(parent);
        this.inputType = inputType;
        this.returnType = returnType;
        this.name = name;
    }

    public ArrayType getInputType() {
        return inputType;
    }

    public void setInputType(ArrayType inputType) {
        this.inputType = inputType;
    }

    public ArrayType getReturnType() {
        return returnType;
    }

    public void setReturnType(ArrayType returnType) {
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
