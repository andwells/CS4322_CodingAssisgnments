import java.util.ArrayList;
import java.util.regex.*;
import java.util.InputMismatchException;
public class ConstantDerivativeModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern constant = Pattern.compile("^\\b(\\p{Digit})+\\b$");
      
      Matcher constMatch = constant.matcher(func);
      
      if(constMatch.find()) //Needs modification
      {
         return new Constant(0);
      }
      else
      {
         //throw error
      }
    return null;
   }
}
