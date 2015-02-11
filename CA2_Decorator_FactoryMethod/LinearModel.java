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
         
         int numFound = 1;
         if(numsMatch.find())
         {
            numFound = Integer.parseInt(numsMatch.group());
            Function f = new Constant(numFound);
         }
         
         //Matcher letter = Pattern.compile("\\p{Alpha}").matcher(func);
         //letter.find();
         
         Function f2 = new Variable();
         String remainder = "";
         
         Function mult = new Multiply(new Constant(number), f2);
         
         char sign = func.charAt(linearMatch.end());
            Modifiable plusMinus;
            if(prevSign != null)
            {
               if(sign == '+')
               {
                  plusMinus = new Addition(mult, null);
               }
               else if(sign == '-')
               {
                  plusMinus = new Subtract(mult, null);
               }

            }
      }
      else
      {
         //throw error
      }
    return null;
   }
}
