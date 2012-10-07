package differentiator;

public class DifferentiateExpression implements DiffVisitor<Expression> {
    
    private String variable;


    public DifferentiateExpression(String variable){
        this.variable = variable;
    }
    public Expression on(Num n) {
        
        return new Num("0");
    }

    
    public Expression on(Var v) {
        if (v.getVar().equals(variable)) 
            return new Var("1");
        else
            return new Num("0");
    }

    
    public Expression on(Sum s) {
        // TODO Auto-generated method stub
        Expression expr1 = s.getExpr1().accept(this);
        Expression expr2 = s.getExpr2().accept(this);
        return new Sum(expr1,expr2);
    }

    
    public Expression on(Multiply l) {               
        Expression expr1 = l.getExpr1().accept(this);
        Expression expr2 = l.getExpr2().accept(this);
        return new Sum(new Multiply(l.getExpr1(),expr2),new Multiply(l.getExpr2(),expr1));
    }

    

}
