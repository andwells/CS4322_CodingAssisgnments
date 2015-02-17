import java.util.ArrayList;
import java.util.regex.*;
import java.util.InputMismatchException;
public class LinearModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      String cleanedFunc = func.replace(" ", "");
      Pattern linear = Pattern.compile("\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher linearMatch = linear.matcher(cleanedFunc);
      Matcher numsMatch = numbers.matcher(cleanedFunc);
      
      if(linearMatch.find())//Needs modification
      {
         
         int numFound = 1;
         if(numsMatch.find())
         {
            numFound = Integer.parseInt(numsMatch.group());
            Function f = new Constant(numFound);
         }
         
         Function f2 = new Variable();
         String remainder = "";
         
         Function mult = new Multiply(new Constant(numFound), f2);
         
         Connector plusMin;
         int addSub = 1;
         if(cleanedFunc.contains("+"))
         {
            addSub = Integer.parseInt(cleanedFunc.split("\\+")[1]);
            plusMin = new Addition(mult, new Constant(addSub));
         }
         else
         {
            addSub = Integer.parseInt(cleanedFunc.split("-")[1]);
            plusMin = new Subtract(mult, new Constant(addSub));
         }
         return plusMin;
      }
      else
      {
         throw new InputMismatchException("Could not find a linear expression.");
      }
   }
}
