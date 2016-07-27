package model.ast;

/**
 * Created by Majid Vaghari on 7/25/2016.
 */
public class AssignStatement extends Statement {
    private       Variable         variableDeclaration;

    public AssignStatement(Block parent) {
        this(parent, null);
    }

    public AssignStatement(Block parent, Variable variableDeclaration) {
        super(parent);
        this.variableDeclaration = variableDeclaration;
    }

    public Variable getVariableDeclaration() {
        return variableDeclaration;
    }

    public void setVariableDeclaration(Variable variableDeclaration) {
        this.variableDeclaration = variableDeclaration;
    }
}
