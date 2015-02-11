import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      String cleanedString = func.replace("_", "");
      
      
      Pattern power = Pattern.compile("(\\p{Digit})*\\p{Alpha}\\^(\\p{Digit})");
      Pattern linear = Pattern.compile("(\\p{Digit})*\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher powerMatch = power.matcher(func);
      Matcher linearMatch = linear.matcher(func);
      Matcher numsMatch = numbers.matcher(func);
      
            
      if(powerMatch.find())
      {//start   
         powerMatch.reset();
         int previousPow = Integer.MIN_VALUE;
         Modifiable prevSign = null;
         while(powerMatch.find())
         {//while
            String part = powerMatch.group();
            String numsFound = "";
            int number = 1;
            numsMatch = numbers.matcher(part);
            if(numsMatch.find())
            {
               number = Integer.parseInt(numsMatch.group());
               if(number >= previousPow)
               {
                  //throw malformed excepiton
               }
            }
            int curPow = Integer.parseInt(part.split("^")[1]);
            Function variable = new Variable();
            Function exp = new Exponent(variable, curPow);
            Function mult = new Multiply(new Constant(number), exp);
            
            if(prevSign != null)
            {
               prevSign.setRight(mult);
            }
            
            char sign = func.charAt(powerMatch.end());
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
            else
            {
               /*Logic may need to be refined.
               In this case, we are assuming that if no sign is found it's the end of the function*/
               return ;
            }
            
         }
         //Unfinished
      } 
//       char firstVar = ' ';
//       ArrayList<Function> parts = new ArrayList<Function>();
// 
//       for(int i = 0; i < func.length();i++)
//       {
//          char currentChar = func.charAt(i);
//       	if(isLegalChar(currentChar))
//       	{
//             if(Character.isAlphabetic(currentChar) && currentChar == firstVar)
//             {
//                //throw exception
//             }
//             else if (Character.isAlphabetic(currentChar))
//             {
//                firstVar = currentChar;
//             }
//       		//do something
//       	}
//       	else
//       	{
//             //throw exception 
//       	}
//       }
    return null;
   }
}
