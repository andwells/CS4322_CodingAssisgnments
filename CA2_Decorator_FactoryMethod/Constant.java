public class Constant extends Function
{
   public Constant(double value)
   {
      this.value = value;
   }
   
   @Override
   public double evaluate(double at)
   {
      return value;
   }
}