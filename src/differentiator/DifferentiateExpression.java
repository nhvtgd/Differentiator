package differentiator;

/**
 * This visitor class will differentiate expression based on the Type of the
 * expression
 * */
public class DifferentiateExpression implements DiffVisitor<Expression> {

	private final String variable;

	public DifferentiateExpression(String variable) {
		this.variable = variable;
	}

	@Override
	public Expression on(Num n) {

		return new Num("0");
	}

	@Override
	public Expression on(Var v) {
		if (v.getVar().equals(variable))
			return new Var("1");
		else
			return new Num("0");
	}

	@Override
	public Expression on(Sum s) {
		Expression expr1 = s.getExpr1().accept(this);
		Expression expr2 = s.getExpr2().accept(this);
		if (expr1.toString().equals("0") && !expr2.toString().equals("0"))
			return expr2;
		else if (!expr1.toString().equals("0") && expr2.toString().equals("0"))
			return expr1;
		else if (expr1.toString().equals("0") && expr2.toString().equals("0"))
			return new Num("0");
		else
			return new Sum(expr1, expr2);
	}

	@Override
	public Expression on(Multiply l) {
		Expression expr1 = l.getExpr1().accept(this);
		Expression expr2 = l.getExpr2().accept(this);
		Expression resultExpr1 = new Multiply(l.getExpr1(), expr2);
		Expression resultExpr2 = new Multiply(l.getExpr2(), expr1);
		if (l.getExpr1().toString().equals("0") || expr2.toString().equals("0")) {
			resultExpr1 = new Num("0");
		}
		if (l.getExpr2().toString().equals("0") || expr1.toString().equals("0")) {
			resultExpr2 = new Num("0");
		}
		if (l.getExpr1().toString().equals("1"))
			resultExpr1 = expr2;
		if (expr2.toString().equals("1"))
			resultExpr1 = l.getExpr1();
		if (l.getExpr2().toString().equals("1"))
			resultExpr2 = expr1;
		if (expr1.toString().equals("1"))
			resultExpr2 = l.getExpr2();
		return new Sum(resultExpr1, resultExpr2).simplify();
	}
}
