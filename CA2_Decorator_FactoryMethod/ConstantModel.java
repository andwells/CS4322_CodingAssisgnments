import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.regex.*;
public class ConstantModel extends Model
{
   private int degree;
   
   protected Function createFunction(String func)
   {
      Pattern constant = Pattern.compile("^\\b(\\p{Digit})+\\b$");
      
      Matcher constMatch = constant.matcher(func);
      
      if(constMatch.find())
      {
         return new Constant(Integer.parseInt(func));
      }
      else
      {
         throw new InputMismatchException("Could not find a string of digits.");
      }
   }
}