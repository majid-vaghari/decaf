package model.ast;

import model.type.Types;

/**
 * Created by Majid Vaghari on 7/27/2016.
 */
public class TypeMismatchException extends Exception {
    public TypeMismatchException(Types t1, Types t2) {
        super("Types " + t1.toString().toLowerCase() + " and " + t2.toString().toLowerCase() + " don't match");
    }

    public TypeMismatchException(String message) {
        super(message);
    }
}
