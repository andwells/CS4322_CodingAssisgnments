import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.regex.*;
public class LinearModel extends Model
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
         }
         
         Function f = new Constant(numFound);                  
         Function f2 = new Variable();
         String remainder = "";
         
         Function mult = new Multiply(new Constant(numFound), f2);
         
         
         int addSub = 0;
         Modifiable plusMin;
         if(func.contains("+"))
         {
            addSub = Integer.parseInt(func.split("\\+")[1]);
            plusMin = new Addition(mult, new Constant(addSub));
         }
         else
         {
            addSub = Integer.parseInt(func.split("-")[1]);
            plusMin = new Subtract(mult, new Constant(addSub));
         }
         
         return (Function) plusMin;
      }
      else
      {
         throw new InputMismatchException("Could not find a linear expression.");
      }
   }
}
