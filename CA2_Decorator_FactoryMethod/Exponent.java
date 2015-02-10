public class Exponent extends Function
{
   private Function leftSide;
   private int power;
   
   public Exponent(Function left, int pow)
   {
      leftSide = left;
      this.power = pow;
   }
   
   public double evaluate(double at)
   {
      return Math.pow(leftSide.evaluate(at), power);
   }
}
