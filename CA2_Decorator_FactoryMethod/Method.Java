public abstract class Model {

  public Model createModel(String type) {
    Function func;
    
    func = createFunction(type);
    
    return func;
  }
  
  proctected abstract Function createFunction(String type);
  
  // other methods here
  protected evaluate(//function){
  }
  
}
