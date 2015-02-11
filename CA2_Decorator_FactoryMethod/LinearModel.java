import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
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
         
         int numFound = 0;
         if(numsMatch.find())
         {
            numFound = Integer.parseInt(numsMatch.group());
            Function f = new Constant(numFound);
         }
         
         Matcher letter = Pattern.compile("\\p{Alpha}").matcher(func);
         letter.find();
         
         Function f2 = new Variable();
         String remainder = "";
      }
      else
      {
         //throw error
      }
    return null;
   }
}
