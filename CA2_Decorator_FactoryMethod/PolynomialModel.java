import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern p = Pattern.compile("\\p{Alpha}\\^\\p{Digit}");
      Pattern p3 = Pattern.compile("\\p{Alpha}(\\+|\\-)?(\\p{Digit})?");
      Pattern p4 = Pattern.compile("^\\b\\p{Digit}\\b$");
      
      // Matcher m = p.matcher(func);
//       if(m.find())
//       {
//          //check for highest power
//       }
//       else if(true)//Needs modification
//       {
//          //check for linear
//       }
//       else if(true) //Needs modification
//       {
//          //Check for constant
//       }
//       else
//       {
//          
//       }
      
      char firstVar = ' ';
      ArrayList<Function> parts = new ArrayList<Function>();

      for(int i = 0; i < func.length();i++)
      {
         char currentChar = func.charAt(i);
      	if(isLegalChar(currentChar))
      	{
            if(Character.isAlphabetic(currentChar) && currentChar == firstVar)
            {
               //throw exception
            }
            else if (Character.isAlphabetic(currentChar))
            {
               firstVar = currentChar;
            }
      		//do something
      	}
      	else
      	{
            //throw exception 
      	}
      }
    return null;
   }
}
