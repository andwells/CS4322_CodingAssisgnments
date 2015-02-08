import java.util.ArrayList;
public class QuadraticModel{
  
  protected Function createFunction(String func)
  {
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
  
  private boolean isLegalChar(char aChar)
  {
      if(aChar >= 40 && aChar <= 43)
   	{
   		return true;
   	}
   	else if(aChar >= 45 && aChar <= 57)
   	{
   		return true;	
   	}
   	else if(aChar >= 65 && aChar <= 90)
   	{
   		return true;
   	}
   	else if(aChar == 94)
   	{
   		return true;	
   	}
   	else if(aChar >= 97 && aChar <= 122)
   	{
   		return true;
   	}
   	else
   	{
   		return false;
   	} 		
   }
}