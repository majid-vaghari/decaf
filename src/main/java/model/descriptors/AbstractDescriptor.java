package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public abstract class AbstractDescriptor implements Descriptor {
    private String name;
    private int    level;
    private Node   declaration;

    public AbstractDescriptor(String name, int level, Node declaration) {
        this.name = name;
        this.level = level;
        this.declaration = declaration;
    }

    @Override
    public String getId() {
        return name;
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
