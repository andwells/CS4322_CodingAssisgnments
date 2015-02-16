public class Multiply extends Connector
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
   
   public void setRight(Function right)
   {
      rightSide = right;
   }
}