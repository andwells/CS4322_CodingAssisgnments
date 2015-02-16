import java.util.ArrayList;
import java.util.regex.*;
import java.util.InputMismatchException;
public class PolynomialModel extends Model
{  
   protected Function createFunction(String func)
   {      
      //Patterns for checking different expressions in an equations
      Pattern power = Pattern.compile("(\\p{Digit})*\\p{Alpha}\\^(\\p{Digit})");
      Pattern linear = Pattern.compile("(\\p{Digit})*\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher powerMatch = power.matcher(func);
      Matcher numsMatch;
                  
      if(powerMatch.find())
      {
         powerMatch.reset();//Move to beginning because of find()
         int previousPow = Integer.MAX_VALUE;
         Modifiable prevSign = null;
         char prevVar = ' ';
         
         /*This is declared so that after all items of the form cx^n are found,
         we can determine where to start looking for where the linear part of the equation starts*/
         int endOfMatch = 0;
         
         while(powerMatch.find())//Looks for all items of the form cx^n
         {
            String part = powerMatch.group();
            
            int number = 1;
            numsMatch = numbers.matcher(part);
            if(numsMatch.find())
            {
               number = Integer.parseInt(numsMatch.group());
            }
            
            for(int i = 0; i < part.length(); i++)//Checks to make sure that this section uses the same variable character
            {
               if(Character.isLetter(part.charAt(i)))
               {
                  char curVar = part.charAt(i);
                  
                  if(prevVar == ' ')
                  {
                     prevVar = curVar;
                  }
                  else if(prevVar != curVar)
                  {
                     throw new InputMismatchException("Multiples variables entered into single-varaiable equation.");
                  }
               }
            }
            
            int curPow = Integer.parseInt(part.split("\\^")[1]);
                        
            if(previousPow == Integer.MAX_VALUE)
            {
               previousPow = curPow;
            }
            else
            {
               if(curPow >= previousPow)
               {
               //Could be replaced with a more meaningful exception
               throw new InputMismatchException("Powers of terms not entered in descending order.");
               }
               else if(curPow != (previousPow - 1))
               {
                  //Could be replaced with a more meaningful exception
                  throw new InputMismatchException("Powers not entered in format of n, n-1, n-2...");
               }
               previousPow = curPow;
            }
                        
            Function variable = new Variable();
            Function exp = new Exponent(variable, curPow);
            Function mult = new Multiply(new Constant(number), exp);
                        
            char sign = func.charAt(powerMatch.end());
            Modifiable plusMinus;
            
            if(prevSign == null)//If this is the first connector (+ or -) that we've found, signify this
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
            else//Otherwise, connect this expression with the previous one
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
         String part = func.substring(start);
         
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
         
         //Joins previous expression with the expression that was just created
         prevSign.setRight((Function)plusMin);
                  
         return (Function)prevSign;
      } 
      else
      {
         throw new InputMismatchException("Could not find a polynomial expression");
      }
   }
}