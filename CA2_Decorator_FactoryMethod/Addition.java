public class Addition extends Function
{
   private Function leftSide;
   
   public Addition(Function left)
   {
      this.leftSide = left;
   }
   
   public double evaluate(double at)
   {
      return leftSide.evaluate(at) + at;
   }
}