package model.descriptors;

/**
 * Created by Majid Vaghari on 7/27/2016.
 */
public class DuplicateDefinitionException extends Exception {
    public DuplicateDefinitionException(String name) {
        super("Duplicate Definition: " + name);
    }
}
