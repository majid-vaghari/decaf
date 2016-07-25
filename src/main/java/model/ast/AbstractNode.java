package model.ast;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public abstract class AbstractNode implements Node {
    private final Node                                      parent;
    private       Collection<Node>                          children;
    private       java.util.function.Function<Node, String> generate;

    public AbstractNode(Node parent) {
        this(parent, new ArrayList<>());
    }

    protected AbstractNode(Node parent, Collection<Node> children) {
        this.parent = parent;
        this.children = children;
    }

    protected java.util.function.Function<Node, String> getGenerate() {
        return generate;
    }

    public final void setGenerate(java.util.function.Function<Node, String> generate) {
        this.generate = generate;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void addChild(Node node) {
        children.add(node);
    }

    @Override
    public void addChildren(Collection<? extends Node> nodes) {
        children.addAll(nodes);
    }

    @Override
    public Collection<Node> getChildren() {
        return children;
    }

    @Override
    public String gen() {
        return generate != null ? generate.apply(this) : null;
    }
}
