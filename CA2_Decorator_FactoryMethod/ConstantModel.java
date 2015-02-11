import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern constant = Pattern.compile("^\\b(\\p{Digit})+\\b$");
      Pattern numbers = Pattern.compile("\\p{Digit}+");
      
      Matcher constMatch = constant.matcher(func);
      Matcher numsMatch = numbers.matcher(func);
      
      if(constMatch.find()) //Needs modification
      {
         return new Constant(Integer.parseInt(func));
      }
      else
      {
         //throw error
      }
    return null;
   }
}
