import java.util.ArrayList;
public class QuadraticModel{
  
  protected Function createFunction(String func)
  {
      char firstVar;
      ArrayList<Function> parts = new ArrayList<Function>();

      for(int i = 0; i < func.length();i++)
      {
         char currentChar = func.charAt(i);
      	if(!isLegalChar(currentChar))
      	{
      		//throw new exception
      	}
      	else if(true)
      	{
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
      if(aChar <= 41)
   	{
   		return false;
   	}
   	else if(aChar == 44)
   	{
   		return false;	
   	}
   	else if(aChar >= 58 || aChar <= 64)
   	{
   		return false;
   	}
   	else if(aChar == 91 || aChar == 92 || aChar == 93)
   	{
   		return false;	
   	}
   	else if(aChar == 95 || aChar == 96)
   	{
   		return false;
   	}
   	else if(aChar >= 123)
   	{
   		return false;
   	}
   	else
   	{
   		return true;
   	} 		
   }
}