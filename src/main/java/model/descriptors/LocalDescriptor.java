package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public class LocalDescriptor extends AbstractDescriptor {
    public LocalDescriptor(String name, int level, Node declaration) {
        super(name, level, declaration);
    }
}
