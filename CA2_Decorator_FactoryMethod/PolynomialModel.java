import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern power = Pattern.compile("(\\p{Digit})*\\p{Alpha}\\^(\\p{Digit})+");
      Pattern linear = Pattern.compile("\\p{Alpha}((\\+|\\-)(\\p{Digit})+)?");
      Pattern constant = Pattern.compile("^\\b(\\p{Digit})+\\b$");
      
      Matcher powerMatch = power.matcher(func);
      Matcher linearMatch = linear.matcher(func);
      Matcher constMatch = constant.matcher(func);
      if(powerMatch.find())
      {
         
         String section = powerMatch.group();
         int degree = Integer.parseInt(section.substring(section.indexOf('^')));
         powerMatch.reset();
         
         while(powerMatch.find())
         {
            String part = powerMatch.group();
         }
         //Unfinished
      }
      else if(linearMatch.find())//Needs modification
      {
         Matcher numbers = Pattern.compile("(\\p{Digit})+").matcher(func);
         int numFound = 0;
         if(numbers.find())
         {
            numFound = Integer.parseInt(numbers.group());
            Function f = new Constant(numFound);
         }
         
         Matcher letter = Pattern.compile("\\p{Alpha}").matcher(func);
         letter.find();
         
         Function f2 = new Variable();
         String remainder = "";
         
         
      }
      else if(constMatch.find()) //Needs modification
      {
         return new Constant(Integer.parseInt(func));
      }
      else
      {
         //throw error
      }
      
      char firstVar = ' ';
      ArrayList<Function> parts = new ArrayList<Function>();

      // for(int i = 0; i < func.length();i++)
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
