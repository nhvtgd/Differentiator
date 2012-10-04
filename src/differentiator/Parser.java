package differentiator;

import java.util.ArrayList;

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
     *            The lexer. grammer:
     * 
     *            DiffExp::= Expression (Op Expression)* Value::=
     *            Integer|Float|Variable Expression ::= Paren Value Paren |
     *            Value Op Value Paren Op ::= Plus|Mul Integer ::= [0-9]+ Float
     *            ::= Interger.Integer Variable ::= [a-z]+ Plus ::= + Mul ::= *
     *            Paren ::= (+|)+
     */

    private final Lexer lexer;
    private final ArrayList<Token> tokens;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.tokens = lexer.checkValidExpression(lexer.lexAnalysis());
    }

    public Lexer getLexer() {
        return lexer;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
    
    
    // TODO fill in useful methods and such!

    // NOTE: Remember to build a recursively-defined AST.
}
