package differentiator;
/**
 * Variable class that implements Expression interface
 * */
public class Var implements Expression{

    private String var;
    
    public Var(String var){
        this.var = var;
        
    }
    
    public String getVar() {
        return var;
    }
    @Override
    public String toString() {
        return var;
    }
    
    public <R> R accept(DiffVisitor<R> v) {        
        return v.on(this);
    }

}
