package differentiator;

public class Num implements Expression{

    private String num;
    
    
    public Num(String num){
        this.num = num;
        
    }
    @Override
    public String toString() {
        return "Num("+num+")";
    }

}