public class Subtract extends Function
{
   private Function leftSide;
   private Function rightSide;
   
   public Subtract(Function left, Function right)
   {
      leftSide = left;
      rightSide = right;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) - rightSide.evaluate(at);
   }
   
   public void setRight(Function right)
   {
      rightSide = right;
   }
}
