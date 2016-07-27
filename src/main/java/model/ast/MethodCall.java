package model.ast;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class MethodCall extends AbstractNode {
    private Function functionDeclaration;

    public MethodCall(Node parent, Function functionDeclaration) {
        super(parent);
        this.functionDeclaration = functionDeclaration;
    }

    public MethodCall(Node parent) {
        super(parent);
    }

    public Function getFunctionDeclaration() {
        return functionDeclaration;
    }

    public void setFunctionDeclaration(Function functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }
}
