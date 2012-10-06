package differentiator;

public interface DiffVisitor<R> {
    public R on(Num n);
    public R on(Var v);
    public R on(Sum s);
    public R on(Multiply l);
}
