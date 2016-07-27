package model.descriptors;

import model.ast.Function;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public class FunctionDescriptor extends AbstractDescriptor {
    public FunctionDescriptor(Function declaration, int level) {
        super(declaration, level);
    }

    @Override
    public String getId() {
        return getDeclaration().getName();
    }

    @Override
    public Function getDeclaration() {
        return (Function) super.getDeclaration();
    }
}
