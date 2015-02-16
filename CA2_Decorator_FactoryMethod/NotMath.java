import java.util.regex.*;
import java.util.InputMismatchException;
public class NotMath{

  public static void main(String[] args){

    String problem1 = "4x^4 + 3x3 + 2x^2 + x + 1";
    String problem2 = "20x + 15";
    String problem3 = "4322";
    
    Model mod = new PolynomialModel();
    Model mod2 = new LinearModel();
    Model mod3 = new ConstantModel();
    
    double[] x = new double[] {1.0, 2.0, 3.0};
    
    try
    {
       double[] y = mod.evaluate(problem1, x);
       System.out.printf("Evaluating %s%n%n", problem1);
       for(int i = 0; i < x.length; i++)
       {
         System.out.printf("X:\t%.2f%nY:\t%.2f%n%n", x[i], y[i]);
       }
       
       y = mod2.evaluate(problem2, x);
       System.out.printf("Evaluating %s%n%n", problem2);
       for(int i = 0; i < x.length; i++)
       {
         System.out.printf("X:\t%.2f%nY:\t%.2f%n%n", x[i], y[i]);
       }
       
       y = mod3.evaluate(problem3, x);
       System.out.printf("Evaluating %s%n%n", problem3);
       for(int i = 0; i < x.length; i++)
       {
         System.out.printf("X:\t%.2f%nY:\t%.2f%n%n", x[i], y[i]);
       } 
    }
    catch(InputMismatchException imEx)
    {
      imEx.printStackTrace();
    }
  }  
}

