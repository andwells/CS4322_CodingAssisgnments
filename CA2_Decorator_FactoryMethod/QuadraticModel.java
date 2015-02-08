import java.util.ArrayList;
public class QuadraticModel{
  
  protected Function createFunction(String func)
  {
      char firstVar;
      ArrayList<Function> parts = new ArrayList<Function>();

      for(int i = 0; i < func.length();i++)
      {
         char currentChar = func.charAt(i);
      	if(isLegalChar(currentChar))
      	{
      		//do something
      	}
      	else
      	{
            //throw malformed 
      	}
      }
    
    
    return null;
  }
  
  public double[] evalute(String func, double[] xValues)
  {
    createFunction(func);
    return null;  
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