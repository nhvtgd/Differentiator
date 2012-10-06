package differentiator;

import java.util.HashMap;

/**
 * A token is a lexical item that the parser uses.
 */
public class Token {
    // symbols: +,*, [a-z]+, [0-9], [0-9]+.[0-9], (, )
    // Operator: +|*
    // Integer: [0-9]+
    // Float: [0-9]+.[0-9]+
    // Numeric: Integer|Float
    // Variable:[a-z]+
    // Term: Numeric|Variable
    // Expression: Term|(Expression)|(Expression Operator Expression)
    //
    // group: Operation(+,*), Integer([0-9]+), , 
    // whitespace, leftparen, rightparen, ForgotOpeartion, UnrecognizedOp.
    /**
     * All the types of tokens that can be made. (*\d*[0-9]*[\+\*]+*[a-z]*
     * Operation :+,*, var : [a-z]+ number : integer and floating point, paren,
     * DiffExp::= Expression (Op Expression)* Value::= Integer|Float|Variable
     * Expression ::= Paren Value | Value Op Value Paren Op ::= Plus|Mul Integer
     * ::= [0-9]+ Float ::= Interger.Integer Variable ::= [a-z]+ Plus ::= + Mul
     * ::= * Paren ::= (+|)+
     */
    public static enum Type {
      
        INVALID("[^0-9a-zA-Z+*().\\s]"),
        NUMERIC("\\d+\\.\\d+|\\d+"), VARIABLE("[a-z]+"),
        SUM("[+]"), PROD("[*]"), LEFTPAREN("[(]"),RIGHTPAREN("[)]"), EOF("EOF");
        
        
        private final String pattern;

        private Type(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
        
        
    }

    private final Type type;
    private final String pattern;

    public Token(Type type, String pattern) {
        this.type = type;
        this.pattern = pattern;
    }
    @Override
    public boolean equals(Object other){
        if (!(other instanceof Token)) return false;
        Token that = (Token) other;
        return (this.type.equals(that.type) && this.pattern.equals(that.pattern));
    }
    
    @Override
    public int hashCode(){
        return 0;
        
   }

    public String toString() {
        return String.format("%s: %s", this.type.name(), this.pattern);
    }

    public Type getType() {
        return type;
    }
    
    public String getPattern() {
        return pattern;
    }
}