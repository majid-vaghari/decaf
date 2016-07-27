package compiler;

import model.ast.AbstractSyntaxTree;
import model.ast.Node;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Majid Vaghari on 5/29/2016.
 */
public class ParserTest {
    private Parser parser;

    @Before
    public void initialize() {
        try {
            parser = new Parser("src/test/resources/tests/Codegen/sort.l");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse() {
        try {
            parser.parse();
            System.out.println("Ok, bye!");
            System.out.println("tree: ");
            printTree(AbstractSyntaxTree.getInstance().getRoot(), 0);
        } catch (UnexpectedTokenException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTree(Node root, int level) {
        Objects.requireNonNull(root);

        System.out.println(new String(new char[level]).replace('\0', '\t') + root);
        root.getChildren().forEach(r -> printTree(r, level + 1));
    }
}
