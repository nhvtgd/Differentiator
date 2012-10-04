package differentiator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class LexerTest {

    @Test
    public void testPlus() {
        // constant + constant
        // constant * constant
        ArrayList<Token> expectedOutput = new ArrayList<Token>();
        expectedOutput.add(new Token(Token.Type.LEFTPAREN, "("));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "3"));
        expectedOutput.add(new Token(Token.Type.SUM, "+"));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "4"));
        expectedOutput.add(new Token(Token.Type.RIGHTPAREN, ")"));
        Lexer actual = new Lexer("(3+4)");
        ArrayList<Token> actualResult = actual.lexAnalysis();
        assertArrayEquals(expectedOutput.toArray(), actualResult.toArray());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertTrue(expectedOutput.get(i).equals(actualResult.get(i)));
            // System.out.println(actual.get(i));
        }

    }

    @Test
    public void testMultiply() {
        // constant + constant
        // constant * constant
        ArrayList<Token> expectedOutput = new ArrayList<Token>();
        expectedOutput.add(new Token(Token.Type.LEFTPAREN, "("));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "3"));
        expectedOutput.add(new Token(Token.Type.PROD, "*"));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "4"));
        expectedOutput.add(new Token(Token.Type.RIGHTPAREN, ")"));
        Lexer actual = new Lexer("(3 * 4)");
        ArrayList<Token> actualResult = actual.lexAnalysis();
        assertArrayEquals(expectedOutput.toArray(), actualResult.toArray());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertTrue(expectedOutput.get(i).equals(actualResult.get(i)));
            // System.out.println(actual.get(i));
        }

    }
    
    @Test
    public void testNumeric() {
        // constant + constant
        // constant * constant
        ArrayList<Token> expectedOutput = new ArrayList<Token>();
        expectedOutput.add(new Token(Token.Type.NUMERIC, "3.5"));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "3"));
        expectedOutput.add(new Token(Token.Type.PROD, "*"));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "4"));
        expectedOutput.add(new Token(Token.Type.NUMERIC, "1000.1"));
        Lexer actual = new Lexer("3.5 3 * 4 1000.1");
        ArrayList<Token> actualResult = actual.lexAnalysis();
        assertArrayEquals(expectedOutput.toArray(), actualResult.toArray());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertTrue(expectedOutput.get(i).equals(actualResult.get(i)));
            // System.out.println(actual.get(i));
        }

    }
    
    @Test
    public void testVariable() {
        // constant + constant
        // constant * constant
        ArrayList<Token> expectedOutput = new ArrayList<Token>();
        expectedOutput.add(new Token(Token.Type.VARIABLE, "fooo"));
        expectedOutput.add(new Token(Token.Type.VARIABLE, "abc"));
        expectedOutput.add(new Token(Token.Type.VARIABLE, "x"));
        expectedOutput.add(new Token(Token.Type.VARIABLE, "zzzzzzz"));
        Lexer actual = new Lexer("fooo abc x zzzzzzz ");
        ArrayList<Token> actualResult = actual.lexAnalysis();
        assertArrayEquals(expectedOutput.toArray(), actualResult.toArray());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertTrue(expectedOutput.get(i).equals(actualResult.get(i)));
            // System.out.println(actual.get(i));
        }

    }
    @Test
    public void testEmpty() {
        // constant + constant
        // constant * constant
        ArrayList<Token> expectedOutput = new ArrayList<Token>();
        Lexer actual = new Lexer("");
        ArrayList<Token> actualResult = actual.lexAnalysis();
        assertArrayEquals(expectedOutput.toArray(), actualResult.toArray());

    }
}
