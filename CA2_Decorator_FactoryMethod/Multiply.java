public class Multiply extends Function
{
   private Function leftSide;
   
   public Multiply(Function left)
   {
      leftSide = left;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) * at;
   }
}