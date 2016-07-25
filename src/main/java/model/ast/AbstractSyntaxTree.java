package model.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid Vaghari on 7/22/2016.
 */
public final class AbstractSyntaxTree {
    private static final AbstractSyntaxTree ABSTRACT_SYNTAX_TREE;

    static {
        ABSTRACT_SYNTAX_TREE = new AbstractSyntaxTree();
    }

    private List<Node> nodes;
    private Node       root;

    private AbstractSyntaxTree() {
        nodes = new ArrayList<>();
    }

    public static AbstractSyntaxTree getInstance() {
        return ABSTRACT_SYNTAX_TREE;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
