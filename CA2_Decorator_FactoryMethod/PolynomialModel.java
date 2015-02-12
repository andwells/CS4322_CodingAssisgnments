import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      String cleanedFunc = func.replace(" ", "");
      
      Pattern power = Pattern.compile("(\\p{Digit})*\\p{Alpha}\\^(\\p{Digit})");
      Pattern linear = Pattern.compile("(\\p{Digit})*\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher powerMatch = power.matcher(cleanedFunc);
      Matcher numsMatch = numbers.matcher(cleanedFunc);
      
            
      if(powerMatch.find())
      {//start   
         powerMatch.reset();
         int previousPow = Integer.MAX_VALUE;
         Modifiable prevSign = null;
         
         int endOfMatch = 0;
         while(powerMatch.find())
         {//while
            String part = powerMatch.group();
            String numsFound = "";
            int number = 1;
            numsMatch = numbers.matcher(part);
            if(numsMatch.find())
            {
               number = Integer.parseInt(numsMatch.group());
               if(previousPow == Integer.MAX_VALUE)
               {
                  previousPow = number;
               }
               else if(number >= previousPow)
               {
                  //throw malformed excepiton
               }
            }
            int curPow = Integer.parseInt(part.split("\\^")[1]);
            Function variable = new Variable();
            Function exp = new Exponent(variable, curPow);
            Function mult = new Multiply(new Constant(number), exp);
            
                        
            char sign = cleanedFunc.charAt(powerMatch.end());
            Modifiable plusMinus;
            if(prevSign == null)
            {
               if(sign == '+')
               {
                  plusMinus = new Addition(mult, null);
               }
               else
               {
                  plusMinus = new Subtract(mult, null);
               }
            }
            else
            {
               prevSign.setRight(mult);
               if(sign == '+')
               {
                  plusMinus = new Addition((Function)prevSign, null);
               }
               else
               {
                  plusMinus = new Subtract((Function)prevSign, null);
               }
            }
            prevSign = plusMinus;
            endOfMatch = powerMatch.end();
         }
         //Start linear parsing
         int start = (endOfMatch + 1);
         String part = cleanedFunc.substring(start);
         
         Matcher linMatch = numbers.matcher(part);
         
         int mult = 1;
         if(linMatch.find())
         {
            mult = Integer.parseInt(linMatch.group());
         }
         
         Function c = new Constant(mult);
         Function var = new Variable();
         Function multi = new Multiply(c, var);
         
         int addSub = 0;
         Modifiable plusMin;
         if(part.contains("+"))
         {
            addSub = Integer.parseInt(part.split("\\+")[1]);
            plusMin = new Addition(multi, new Constant(addSub));
         }
         else
         {
            addSub = Integer.parseInt(part.split("-")[1]);
            plusMin = new Subtract(multi, new Constant(addSub));
         }
         
         prevSign.setRight((Function)plusMin);
         
         
         return (Function)prevSign;
      } 
      return null;
   }
}
