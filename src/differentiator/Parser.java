package differentiator;

import java.util.ArrayList;
import java.util.Iterator;

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
    private final Iterator<Token> tokens;
    
    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.tokens = lexer.wrapperLexer().iterator();
    }

    public Lexer getLexer() {
        return lexer;
    }

    public Token getTokens() {
        if (tokens.hasNext())
            return tokens.next();
        else
            return null;
    }
    
    public void expect(Token token){
        if (getTokens() == token )
            consume();
        else
            throw new IllegalArgumentException("Illegal token");
        
    }
    private void consume() {
        tokens.next();                
    }

    public Expression eParser(){
        Expression t = null;
        t = expr();
        expect(null);
        return t;
        
    }
    
    private Expression expr() {
        // TODO Auto-generated method stub
        Expression t = null;
        Expression t1 = null;
        t = component();
        Token next = getTokens();
        if (next.getType().equals(Token.Type.SUM)){
            consume();
            Expression t1= factor(); 
            
        }
        return Sum(t,t1);
        
    }

    public static void main(String[] args) {
        Parser parse = new Parser(new Lexer("(3.8a * 3 + 4 +  1000.1)"));
        
    }
    
}
