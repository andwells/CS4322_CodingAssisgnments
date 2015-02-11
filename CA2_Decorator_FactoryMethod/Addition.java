public class Addition extends Function
{
   private Function leftSide;
   private Function rightSide;
   
   public Addition(Function left, Function right)
   {
      this.leftSide = left;
      this.rightSide = right;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) + rightSide.evaluate(at);
   }
   
   public void setRight(Function right)
   {
      rightSide = right;
   }
}
