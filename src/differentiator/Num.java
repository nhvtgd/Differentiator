package differentiator;
/**
 * Represent the constant class implement Expression interface
 * */
public class Num implements Expression{

    private String num;
    
    
    public Num(String num){
        this.num = num;
        
    }
    @Override
    public String toString() {
        return num;
    }
    
    public <R> R accept(DiffVisitor<R> v) {        
        return v.on(this);
    }
    
    

}