import java.util.ArrayList;
public class QuadraticModel extends Model
{
  
  protected Function createFunction(String func)
  {
      char firstVar = ' ';
      ArrayList<Function> parts = new ArrayList<Function>();

      for(int i = 0; i < func.length();i++)
      {
         char currentChar = func.charAt(i);
      	if(super.isLegalChar(currentChar))
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
  
  public double[] evalute(String func, double[] xValues)
  {
    Function f = createFunction(func);
    double[] yValues = new double[xValues.length];
    for(int i = 0; i < yValues.length;i++)
    {
      yValues[i] = f.evaluate(xValues[i]);
    }  
    return yValues;
  }
  
 
}