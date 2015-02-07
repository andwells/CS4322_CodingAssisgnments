public class Divide extends Function
{
   private Function leftSide;
   
   public Divide(Function left)
   {
      leftSide = left;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) / at;
   }
}