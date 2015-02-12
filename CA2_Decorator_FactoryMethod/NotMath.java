import java.util.regex.*;

public class NotMath{

  public static void main(String[] args){

    String problem1 = "4x^4 + 3x^3 + 2x^2 + x + 1";
    String problem2 = "20x + 15";
    String problem3 = "4322";
    Model mod = new PolynomialModel();
    
    double[] x = new double[] {1.0, 2.0, 3.0};
    
    double[] y = mod.evaluate(problem1, x);
    
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
    
    /*CheckString(problem1);
    CheckString(problem2);
    CheckString(problem3);*/
    
  }
  
  /*public static void CheckString(String checkMeOut){
  
    if(checkMeOut.contains("^"))
      // call evaluate for polynomial
    else if(checkMeOut.contains(Pattern.compile("\\p{Alpha}).matcher(checkMeOut).find());
      // call evaluate for linear
    else
      // call evaluate for constant
  
  }*/
  
}

