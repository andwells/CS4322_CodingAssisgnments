public abstract class Model
{
  
  protected abstract Function createFunction(String func);
  
  protected boolean isLegalChar(char aChar)
  {//start
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
  
  public double[] evalute(String func, double[] xValues)
  {
    createFunction(func);
    return null;
  }
  
}
