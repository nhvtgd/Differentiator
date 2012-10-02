package differentiator;

/**
 * A token is a lexical item that the parser uses.
 */
public class Token {
    /**
     * All the types of tokens that can be made.
     * (*\d*[0-9]*[\+\*]+*[a-z]*
     * Operation :+,*, var : [a-z]+
     * number : integer and floating point, paren,
     * DiffExp::= Expression (Op Expression)*
     * Value::= Integer|Float|Variable
     * Expression ::= Paren Value | Value Op Value Paren
     * Op ::=  Plus|Mul
     * Integer ::= [0-9]+
     * Float ::= Interger.Integer
     * Variable ::= [a-z]+
     * Plus ::= +
     * Mul ::= *
     * Paren ::= (+|)+
     */
    public static enum Type {
        Integer,
        Float,
        Variable,
        Plus,
        Mul,
        Value(Integer|Float|Variable), 
        Expression,
        Op,
        Paren,
        DiffExp(Paren);
        
        private final String pattern;
        private final Token.Type type;
        
        private Type(String pattern){
            this.pattern = pattern;
        }
        
        private Type(Token.Type type){
            this.type = type;
        }
    }
    

    // TODO write me
}