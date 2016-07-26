package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public abstract class AbstractDescriptor implements Descriptor {
    private Node declaration;
    private int  level;

    public AbstractDescriptor(Node declaration, int level) {
        this.declaration = declaration;
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public Node getDeclaration() {
        return declaration;
    }
}
