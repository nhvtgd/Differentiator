package differentiator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DifferentiatorTest {

    @Test
    public void singletonVar() {
        Differentiator diff = new Differentiator();
        String output = "1";
        String actual = diff.evaluate("(x)","x");
        assertEquals(output, actual);
    }
    
    @Test
    public void singletonNum() {
        Differentiator diff = new Differentiator();
        String output = "0";
        String actual = diff.evaluate("(3)","x");
        assertEquals(output, actual);
    }
    
    @Test
    public void singleExpression() {
        Differentiator diff = new Differentiator();
        String output = "(0+1)";
        String actual = diff.evaluate("(3+x)","x");
        assertEquals(output, actual);
    }
    
    @Test
    public void nestedExpression() {
        Differentiator diff = new Differentiator();
        String output = "(((2*1)+(x*0))+((3*1)+(x*0)))";
        String actual = diff.evaluate("((2*x)+(3*x))","x");
        assertEquals(output, actual);
    }
    
    @Test
    public void differentVariable() {
        Differentiator diff = new Differentiator();
        String output = "(((2*1)+(x*0))+((3*0)+(y*0)))";
        String actual = diff.evaluate("((2*x)+(3*y))","x");
        assertEquals(output, actual);
    }
    
    @Test
    public void multiParenthesisVariable() {
        Differentiator diff = new Differentiator();
        String output = "(1+0)";
        String actual = diff.evaluate("(((((x+3)))))","x");
        assertEquals(output, actual);
    }
    
    
    @Test
    public void longVariable() {
        Differentiator diff = new Differentiator();
        String output = "(1+0)";
        String actual = diff.evaluate("(foo + bar)","foo");
        assertEquals(output, actual);
    }
    
    @Test
    public void complexExpression() {
        Differentiator diff = new Differentiator();
        String output = "((((((0+0)+0)+0)+0)+0)+0)";
        String actual = diff.evaluate("(((((((1) + 2) + 3) + 4) + 5) + 6) + 7)","x");
        assertEquals(output, actual);
    }
   
    @Test
    public void complexExpressionWithCap() {
        Differentiator diff = new Differentiator();
        String output = "(((((A+B)*(C+D))+((E+F)*(G+H)))*((((I*0)+(J*0))+((K*0)+(L*0)))+(((M+N)*(0+0))+((O+P)*(0+0)))))+((((I*J)+(K*L))+((M+N)*(O+P)))*((((A+B)*(0+0))+((C+D)*(1+0)))+(((E+F)*(0+0))+((G+H)*(0+0))))))";
        String actual = diff.evaluate("((((A+B) * (C+D)) + ((E+F) * (G+H))) * (((I*J) + (K*L)) + ((M+N) * (O+P))))","A");
        assertEquals(output, actual);
    }
}
