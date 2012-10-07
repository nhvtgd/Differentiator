package differentiator;

public class Sum implements Expression{

    private Expression expr1;
    private Expression expr2;
    
    public Sum(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    public Expression getExpr1() {
        return expr1;
    }
    public Expression getExpr2() {
        return expr2;
    }
    @Override
    public String toString() {
        return "("+ expr1.toString() + "+" + expr2.toString() +")";
    }
    
    public <R> R accept(DiffVisitor<R> v) {        
        return v.on(this);
    }

}
