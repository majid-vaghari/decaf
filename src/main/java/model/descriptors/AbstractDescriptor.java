package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class AbstractDescriptor implements Descriptor {
    private int    level;
    private String name;
    private Node   declaration;

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
