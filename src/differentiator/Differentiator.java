package differentiator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** Symbolic differentiator */
public class Differentiator {
    /**
     * Differentiates the passed expression string with respect to variable
     * and returns its derivative as a string.  If the expression or variable
     * is null, behavior is undefined.  If the expression is not parsable,
     * throws an exception.
     * @param expression The expression.
     * @param variable The variable to differentiate by.
     * @return The expression's derivative.
     */
    public String evaluate(String expression, String variable) {
        Lexer lex = new Lexer(expression);
        Parser parse = new Parser(lex);
        DiffVisitor<Expression> diff = new DifferentiateExpression(variable);
        Expression result = parse.eParser().accept(diff);
        return result.toString();
    }

    /**
     * Repeatedly reads expressions from the console, and outputs the results of
     * evaluating them. Inputting an empty line will terminate the program.
     * @param args unused
     */
    public static void main(String[] args) throws IOException {
        String result;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expression;
        do {
            // display prompt
            System.out.print("> ");
            // read input
            expression = in.readLine();
            // terminate if input empty
            if (!expression.equals("")) {
                try {
                    Differentiator diff = new Differentiator();
                    result = diff.evaluate(expression, "x");
                    System.out.println(result);
                } catch (RuntimeException re) {
                    System.err.println("Error: " + re.getMessage());
                }
            }
        } while (!expression.equals(""));
    }
}
