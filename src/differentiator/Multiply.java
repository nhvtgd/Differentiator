package differentiator;

public class Multiply implements Expression{

    private Expression expr1;
    private Expression expr2;
    
    public Multiply(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    @Override
    public String toString() {
        return "Prod("+ expr1.toString() +"," + expr2.toString() +")";
    }

}
