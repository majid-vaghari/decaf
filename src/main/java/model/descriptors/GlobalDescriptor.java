package model.descriptors;

import model.ast.Variable;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public class GlobalDescriptor extends AbstractDescriptor {
    public GlobalDescriptor(Variable declaration, int level) {
        super(declaration, level);
    }

    @Override
    public String getId() {
        return ((Variable) getDeclaration()).getName();
    }
}
