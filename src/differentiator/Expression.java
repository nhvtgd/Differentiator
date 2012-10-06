package differentiator;

public interface Expression {

    @Override
    public String toString();
    public <R> R accept(DiffVisitor<R> v);
    

}
