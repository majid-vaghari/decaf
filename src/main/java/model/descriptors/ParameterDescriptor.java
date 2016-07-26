package model.descriptors;

import model.ast.Parameter;

/**
 * Created by Majid Vaghari on 7/26/2016.
 */
public class ParameterDescriptor extends AbstractDescriptor {
    public ParameterDescriptor(Parameter declaration, int level) {
        super(declaration, level);
    }

    @Override
    public String getId() {
        return ((Parameter) getDeclaration()).getName();
    }
}
