package differentiator;
/**
 * Interface for mathematical expression including number, variable
 * Summation, Multiplication
 * */
public interface Expression {

    @Override
    public String toString();
    public <R> R accept(DiffVisitor<R> v);
    

}
