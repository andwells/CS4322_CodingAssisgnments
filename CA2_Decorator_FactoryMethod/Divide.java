/*public class Divide extends Function
{
   private Function leftSide;
   private Function rightSide;
   
   public Divide(Function left, Function right)
   {
      leftSide = left;
      rightSide = right;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) / rightSide.evaluate(at);
   }
}*/

public class Divide extends Function
{
   private Function leftSide;
   private Function rightSide;
   
   public Divide(Function left, Function right)
   {
      leftSide = left;
      rightSide = right;
   }
   
   public double evaluate(double at)
   {
      double right = evaluateRight(at);
      
      if (right != 0)
         return leftSide.evaluate(at) / right;
      else
         // error handle instead of null
         return null;
   }
   
   public double evaluateRight(double at)
   {
      return rightSide.evaluate(at)
   }
}
