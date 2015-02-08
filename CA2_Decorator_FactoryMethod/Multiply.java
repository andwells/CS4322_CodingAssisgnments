public class Multiply extends Function
{
   private Function leftSide;
   private Function rightSide;
   
   public Multiply(Function left, Function right)
   {
      leftSide = left;
      rightSide = right;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) * rightSide.evaluate(at);
   }
}