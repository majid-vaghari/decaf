package model.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public abstract class AbstractNode implements Node {
    private final Node                                      parent;
    private       List<Node>                                children;
    private       java.util.function.Function<Node, String> generate;

    public AbstractNode(Node parent) {
        this(parent, new ArrayList<>());
    }

    protected AbstractNode(Node parent, List<Node> children) {
        this.parent = parent;
        this.children = children;
        if (Objects.nonNull(getParent()))
            getParent().addChild(this);
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void addChild(Node node) {
        if (!children.contains(node))
            children.add(node);
    }

    @Override
    public void addChildren(List<? extends Node> nodes) {
        children.addAll(nodes.stream().filter(e -> !children.contains(e)).collect(Collectors.toList()));
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String gen() {
        return generate != null ? generate.apply(this) : null;
    }

    protected java.util.function.Function<Node, String> getGenerate() {
        return generate;
    }

    public final void setGenerate(java.util.function.Function<Node, String> generate) {
        this.generate = generate;
    }
}
