public abstract class Model
{
  
  protected abstract Function createFunction(String func);
  
  public double[] evalute(String func, double[] xValues){
    createFunction(func);
  }
  
}
