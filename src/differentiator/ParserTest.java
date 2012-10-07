package differentiator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

    @Test
    public void testSingleton() {
        Lexer lexer = new Lexer("(x)");
        Parser parser = new Parser(lexer);
        String output = "x";
        assertEquals(parser.toString(),output);
        
        Lexer lexer2 = new Lexer("(3)");
        Parser parser2 = new Parser(lexer2);
        String output2 = "3";
        assertEquals(parser2.toString(),output2);
    }
    
    @Test
    public void testPlusExpression() {
        Lexer lexer = new Lexer("(x+b)");
        Parser parser = new Parser(lexer);
        String output = "(x+b)";
        assertEquals(parser.toString(),output);
        
        Lexer lexer2 = new Lexer("(3+       b)");
        Parser parser2 = new Parser(lexer2);
        String output2 = "(3+b)";
        assertEquals(parser2.toString(),output2);
        
        Lexer lexer3 = new Lexer("(3        +       3)");
        Parser parser3 = new Parser(lexer3);
        String output3 = "(3+3)";
        assertEquals(parser3.toString(),output3);
    }
    
    
    @Test
    public void testMultiplyExpression() {
        Lexer lexer = new Lexer("(x*b)");
        Parser parser = new Parser(lexer);
        String output = "(x*b)";
        assertEquals(parser.toString(),output);
        
        Lexer lexer2 = new Lexer("(3*       b)");
        Parser parser2 = new Parser(lexer2);
        String output2 = "(3*b)";
        assertEquals(parser2.toString(),output2);
        
        Lexer lexer3 = new Lexer("(3        *       3)");
        Parser parser3 = new Parser(lexer3);
        String output3 = "(3*3)";
        assertEquals(parser3.toString(),output3);
    }
    
    @Test
    public void testNestedExpression() {
        Lexer lexer = new Lexer("((x*b)+(2*3))");
        Parser parser = new Parser(lexer);
        String output = "((x*b)+(2*3))";
        assertEquals(parser.toString(),output);
        
        Lexer lexer2 = new Lexer("((2*x    )+     (   y*x     ))");
        Parser parser2 = new Parser(lexer2);
        String output2 = "((2*x)+(y*x))";
        assertEquals(parser2.toString(),output2);
        
        Lexer lexer3 = new Lexer("((4 + (3 * x)) + (((2 * x) * x) + ((1 * x) * (x * x))))");
        Parser parser3 = new Parser(lexer3);
        String output3 = "((4+(3*x))+(((2*x)*x)+((1*x)*(x*x))))";
        assertEquals(parser3.toString(),output3);
    }
    
    @Test(expected=RuntimeException.class)
    public void testIllegalParen() {
        Lexer lexer = new Lexer("x*b+2*3");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testUnbalancedParen() {
        Lexer lexer = new Lexer("(x*b+2*3");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testIllegalInput() {
        Lexer lexer = new Lexer("(3x)");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testIllegalOperator() {
        Lexer lexer = new Lexer("(3-x)");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testIllegalCharacter() {
        Lexer lexer = new Lexer("(3!)");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testIllegalEndOfFile() {
        Lexer lexer = new Lexer("(3 + 5) +");
        Parser parser = new Parser(lexer);
        parser.eParser();
        
        
    }

}
