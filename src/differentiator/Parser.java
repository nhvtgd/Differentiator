package differentiator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

/**
 * The parser gets a bunch of tokens from the lexer and determines what
 * expression was written by the user.
 */
public class Parser {
    /**
     * Creates a new parser over the lexer. This parser will use the passed
     * lexer to get tokens--which it will then parse.
     * 
     * @param lexer
     * E := "(" + T +|* + T + ")"
     * T := Var | Num | E
     */

    private final Lexer lexer;
    private final Iterator<Token> tokens;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.tokens = lexer.wrapperLexer().iterator();
        this.currentToken = null;

    }

    public Lexer getLexer() {
        return lexer;
    }

    public Token getTokens() {
        if (tokens.hasNext())
            return tokens.next();
        else
            return new Token(Token.Type.EOF, "EOF");
    }

    public void expect(Token.Type token) {
        if (currentToken.getType() == token)
            return;
        else
            throw new IllegalArgumentException("Illegal token +" + token);

    }

    private void consume() {
        tokens.next();
    }

    public Expression eParser() {
        Expression t = null;
        currentToken = getTokens();
        t = E();
        expect(Token.Type.EOF);
        return t;

    }

    private Expression E() {
        // TODO Auto-generated method stub
        Expression t = null;
        Expression t1 = null;
        Token next = currentToken;
        if (next.getType().equals(Token.Type.LEFTPAREN)) {
            currentToken = getTokens();
            t = T();
            Token next2 = currentToken;
            if (next2.getType().equals(Token.Type.RIGHTPAREN)){
                currentToken = getTokens();
                return t;
            }
            else if (next2.getType().equals(Token.Type.SUM)
                    || next2.getType().equals(Token.Type.PROD)) {
                currentToken = getTokens();
                t1 = T();
                if (currentToken.getType().equals(Token.Type.RIGHTPAREN)) {
                    switch (next2.getType()) {
                    case SUM:
                        currentToken = getTokens();
                        return new Sum(t, t1);
                    case PROD:
                        currentToken = getTokens();
                        return new Multiply(t, t1);
                    default:
                        throw new RuntimeException("Illegal TOKEN "
                                + next2.getType());
                    }

                }
                else
                    throw new RuntimeException("Expected Rightparen");

            }
            else
                throw new RuntimeException("Missing right paren or operator");
        }
        else
            throw new RuntimeException("Expected Opening parenthesis ");
        // System.out.println("E: " + next);
        // if (next.getType().equals(Token.Type.SUM)) {
        // // consume();
        // t1 = T();
        // }
        // return new Sum(t, t1);
        

    }

    private Expression T() {
        // TODO Auto-generated method stub
        // Expression t = null;
        // Expression t1 = null;
        // t = F();
        // Token next = getTokens();
        // System.out.println("T: " + next);
        // if (next.getType().equals(Token.Type.PROD)) {
        // // consume();
        // t1 = F();
        //
        // }
        // return new Multiply(t, t1);
        Expression t = null;
        Token next = currentToken;
        System.out.println(next);
        if (next.getType().equals(Token.Type.NUMERIC)) {
            t = new Num(next.getPattern());
            // consume();
            currentToken = getTokens();
            return t;
        }

        else if (next.getType().equals(Token.Type.VARIABLE)) {
            t = new Var(next.getPattern());
            currentToken = getTokens();
            // consume();
            return t;
        }

        else {
            // consume();
            t = E();            
            return t;
        }
        // } else
        // throw new IllegalArgumentException(
        // "There are something wrong with your expression");
    }

    // private Expression F() {
    // // TODO Auto-generated method stub
    // Expression t = null;
    // Token next = getTokens();
    // System.out.println(next);
    // if (next.getType().equals(Token.Type.NUMERIC)) {
    // t = new Num(next.getPattern());
    // // consume();
    // return t;
    // }
    //
    // else if (next.getType().equals(Token.Type.VARIABLE)) {
    // t = new Var(next.getPattern());
    // // consume();
    // return t;
    // }
    //
    // else if (next.getType().equals(Token.Type.LEFTPAREN)) {
    // // consume();
    // t = E();
    // expect(Token.Type.RIGHTPAREN);
    // return t;
    // } else
    // throw new IllegalArgumentException(
    // "There are something wrong with your expression");
    //
    // }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return eParser().toString();
    }

    public static void main(String[] args) {
        Parser parse = new Parser(new Lexer("((((a+2)*c) + (10+5)) + 5)"));
        System.out.println(parse);

    }

}
