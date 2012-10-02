package differentiator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A lexer takes a string and splits it into tokens that are meaningful to a
 * parser.
 */
public class Lexer {
    private final String lex;

    /**
     * Creates the lexer over the passed string.
     * 
     * @param string
     *            The string to tokenize.
     */
    public Lexer(String string) {
        this.lex = string;
    }

    public ArrayList<Token> lexAnalysis() {
        ArrayList<Token> tokens = new ArrayList<Token>();
        StringBuffer buffer = new StringBuffer();
        for (Token.Type type : Token.Type.values()) {
            buffer.append(type.getPattern() + "|");
        }             
        Pattern pattern = Pattern.compile(new String(buffer));
        Matcher matcher = pattern.matcher(lex);
        while (matcher.find()) {
            if (matcher.group().matches(Token.Type.INTEGER.getPattern())) {
                tokens.add(new Token(Token.Type.INTEGER, matcher.group()));
                continue;
            } else if (matcher.group().matches(Token.Type.FLOAT.getPattern())) {
                tokens.add(new Token(Token.Type.FLOAT, matcher.group()));
                continue;
                // } else if
                // (matcher.group().matches(Token.Type.PLUS.getPattern())) {
                // tokens.add(new Token(Token.Type.PLUS, matcher.group()));
                // continue;
            } else if (matcher.group().matches(
                    Token.Type.OPERATION.getPattern())) {
                tokens.add(new Token(Token.Type.OPERATION, matcher.group()));
                continue;
            } else if (matcher.group()
                    .matches(Token.Type.VARIABLE.getPattern())) {
                tokens.add(new Token(Token.Type.VARIABLE, matcher.group()));
                continue;
            } else if (matcher.group().matches(
                    Token.Type.WHITESPACE.getPattern())) {
                tokens.add(new Token(Token.Type.WHITESPACE, matcher.group()));
                continue;
            } else if (matcher.group().matches(Token.Type.PAREN.getPattern())) {
                tokens.add(new Token(Token.Type.PAREN, matcher.group()));
                continue;
            }

        }
        return tokens;
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer("((3 * (x + 2.4) + (2*x)*x)) + ((1*x)*(x*x))");
        ArrayList<Token> tokens = lexer.lexAnalysis();
        System.out.println(tokens.toString());
        for (Token token : tokens)
            System.out.println(token);
    }
    // TODO add methods you think will be useful.
}
