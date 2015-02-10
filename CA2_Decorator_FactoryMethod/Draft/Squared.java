public class Squared extends Function
{
   private Function leftSide;
   
   public Squared(Function left)
   {
      leftSide = left;   
   }
   
   public double evaluate(double at)
   {
      return Math.pow(leftSide.evaluate(at), 2);
   }
}