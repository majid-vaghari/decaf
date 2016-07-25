package model.descriptors;

import model.ast.Node;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public interface Descriptor {
    String getId();

    int getLevel();

    Node getDeclaration();
}
