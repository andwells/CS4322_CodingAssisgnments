public class Subtract extends Function
{
   private Function leftSide;
   
   public Subtract(Function left)
   {
      leftSide = left;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) - at;
   }
}