package differentiator;

/**
 * A token is a lexical item that the parser uses.
 */
public class Token {
    /**
     * All the types of tokens that can be made. (*\d*[0-9]*[\+\*]+*[a-z]*
     * Operation :+,*, var : [a-z]+ number : integer and floating point, paren,
     * DiffExp::= Expression (Op Expression)* Value::= Integer|Float|Variable
     * Expression ::= Paren Value | Value Op Value Paren Op ::= Plus|Mul Integer
     * ::= [0-9]+ Float ::= Interger.Integer Variable ::= [a-z]+ Plus ::= + Mul
     * ::= * Paren ::= (+|)+
     */
    public static enum Type {
        FLOAT("\\d*\\.\\d+"), INTEGER("\\d+"), VARIABLE("[a-z]+"),
        OPERATION("[+|*]"), WHITESPACE("[ ]+"), PAREN("[(|)]");

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

    public String toString() {
        return String.format("%s: %s", this.type.name(), this.pattern);
    }

    // TODO write me
}