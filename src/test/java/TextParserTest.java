import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TextParserTest {

    private static TextParser textParser;

    @BeforeAll
    static void setup() {
        textParser = new TextParser();
    }

    @Test
    public void parseTest1() throws FileNotFoundException {
        String parse = textParser.parse("test1.txt");
        assertEquals("The amount to pay RENE is: 215 USD", parse);
    }

    @Test
    public void parseTest2() throws FileNotFoundException {
        String parse = textParser.parse("test2.txt");
        assertEquals("The amount to pay ASTRID is: 85 USD", parse);
    }


}
