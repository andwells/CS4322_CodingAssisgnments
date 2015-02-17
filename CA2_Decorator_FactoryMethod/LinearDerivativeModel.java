import java.util.ArrayList;
import java.util.regex.*;
import java.util.InputMismatchException;
public class LinearDerivativeModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern linear = Pattern.compile("\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher linearMatch = linear.matcher(func);
      Matcher numsMatch = numbers.matcher(func);
      
      if(linearMatch.find())//Needs modification
      {
         
         int numFound = 1;
         Function f = null;
         if(numsMatch.find())
         {
            numFound = Integer.parseInt(numsMatch.group());
            f = new Constant(numFound);
         }
         
         return f;
      }
      else
      {
         throw new InputMismatchException("Could not find a linear expression.");
      }
   }
}
