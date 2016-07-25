package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public class GlobalDescriptor extends AbstractDescriptor {
    public GlobalDescriptor(String name, int level, Node declaration) {
        super(name, level, declaration);
    }
}
