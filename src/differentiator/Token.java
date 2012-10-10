package differentiator;

import java.util.HashMap;

/**
 * A token is a lexical item that the parser uses.
 */
public class Token {
    // symbols:= +,*, [a-z]+, [0-9], [0-9]+.[0-9], (, )
    // Operator:= +|*
    // Integer:= [0-9]+
    // Float:= [0-9]+.[0-9]+
    // Numeric:= Integer|Float
    // Variable:= [a-z]+
    // Term:= Numeric|Variable
    // Expression:= Term|(Expression)|(Expression Operator Expression)
    // Invalid: anything that are not listed
    /**
     * All the types of tokens that can be made. 
     */
    public static enum Type {
      
        INVALID("[^0-9a-zA-Z+*().\\s]"),
        NUMERIC("\\d+\\.\\d+|\\d+"), VARIABLE("[a-zA-Z]+"),
        SUM("[+]"), PROD("[*]"), LEFTPAREN("[(]"),RIGHTPAREN("[)]"),
        EOF("EOF");
        
        
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