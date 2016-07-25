package model.ast;

import java.util.List;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public interface Node {
    Node getParent();

    void addChild(Node node);

    void addChildren(List<? extends Node> nodes);

    List<Node> getChildren();

    String gen();
}
