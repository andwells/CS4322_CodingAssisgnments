import java.util.regex.*;

public class NotMath{

  public static void main(String[] args){

    String problem1 = "4x^4 + 3x^3 + 2x^2 + x + 1";
    String problem2 = "20x + 15";
    String problem3 = "4322";
    String problem4 = "3x^3 + 2x^2 + x + 1";
    Model mod = new PolynomialModel();
    Model dev = new PolynomialDerivativeModel();
    Model mod2 = new LinearModel();
    Model dev2 = new LinearDerivativeModel();
    Model mod3 = new ConstantModel();
    Model dev3 = new ConstantDerivativeModel();
    
    double[] x = new double[] {1.0, 2.0, 3.0};
    
    
    
    
    //Polynomial
    double[] y = mod.evaluate(problem1, x);
    System.out.printf("Evaluating %s%n", problem1);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
    
    //Polynomial Derivative
    System.out.printf("Evaluating %s%n", problem4);
    y = dev.evaluate(problem4, x);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
    
    //Linear
    System.out.printf("Evaluating %s%n", problem2);
    y = mod2.evaluate(problem2, x);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
    
    //Linear Derivative    
    System.out.printf("Evaluating %s%n", problem2);
    y = dev2.evaluate(problem2, x);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
    
    //Constant
    System.out.printf("Evaluating %s%n", problem3);
    y = mod3.evaluate(problem3, x);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }

    //Constant Derivative    
    System.out.printf("Evaluating %s%n", problem3);
    y = dev3.evaluate(problem3, x);
    for(int i = 0; i < x.length; i++)
    {
      System.out.printf("X:\t%f%nY:\t%f%n%n", x[i], y[i]);
    }
  } 
}

