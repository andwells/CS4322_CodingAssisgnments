public abstract class Model 
{
  
  protected abstract Function createFunction(String func);
  
  //other methods here... like evaluate()
  
  public void evalute(String func, double[] xValues)
  {
    createFunction(func);
  }
  
}