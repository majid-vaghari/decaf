package model.ast;

import model.type.Types;

import java.util.Optional;

/**
 * Created by Majid Vaghari on 7/23/2016.
 */
public class Function extends AbstractNode {
    private Types  returnType;
    private String name;

    public Function(Node parent) {
        super(parent);
    }

    public Function(Node parent, Types returnType, String name) {
        super(parent);
        this.returnType = returnType;
        this.name = name;
    }

    public Types getReturnType() {
        return returnType;
    }

    public void setReturnType(Types returnType) {
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean doesReturn() {
        Optional<Block> op = getChildren().stream()
                                          .filter(e -> e instanceof Block)
                                          .map(e -> ((Block) e))
                                          .findAny();
        if (op.isPresent())
            return op.get().getChildren().stream().filter(e -> e instanceof ReturnStatement).count() > 0;
        return false;
    }
}