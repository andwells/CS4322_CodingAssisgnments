public abstract class Model {
  
  proctected abstract Function createFunction(String func);
  
  // other methods here... like evaluate()
  
  public void evalute(String func, double[] xValues){
    createFunction(func);
  }
  
}
