public class Cubed extends Function
{
   private Function leftSide;
   
   public Cubed(Function left)
   {
      leftSide = left;   
   }
   
   public double evaluate(double at)
   {
      return Math.pow(leftSide.evaluate(at), 3);
   }
}
