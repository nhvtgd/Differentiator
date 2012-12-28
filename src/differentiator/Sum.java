package differentiator;

public class Sum implements Expression {

	private final Expression expr1;
	private final Expression expr2;

	public Sum(Expression expr1, Expression expr2) {
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
		return "(" + expr1.toString() + "+" + expr2.toString() + ")";
	}

	public Expression simplify() {
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
	public <R> R accept(DiffVisitor<R> v) {
		return v.on(this);
	}

}
