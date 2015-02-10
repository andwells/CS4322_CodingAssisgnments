public class Exponent extends Function
{
   private Function leftSide;
   
   public Exponent(Function left)
   {
      leftSide = left;   
   }
   
   public double evaluate(double at)
   {
      return Math.pow(leftSide.evaluate(at));
   }
}
