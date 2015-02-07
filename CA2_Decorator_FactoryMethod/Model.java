public abstract class Model
{
  
  protected abstract Function createFunction(String func);
  
  public void evalute(String func, double[] xValues){
    createFunction(func);
  }
  
}
