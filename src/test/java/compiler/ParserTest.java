package compiler;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Majid Vaghari on 5/29/2016.
 */
public class ParserTest {
    private Parser parser;

    @Before
    public void initialize() {
        try {
            parser = new Parser("src/test/resources/parser/b1.l");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parse() {
        try {
            parser.parse();
            System.out.println("Ok, bye!");
        } catch (UnexpectedTokenException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
