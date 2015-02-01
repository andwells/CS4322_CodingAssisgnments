import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class PerOrderStrategy implements SalesStrategy
{
   
   @Override
   public SalesStats Read(File toRead) 
   {
      Scanner reader;
      try
      {
         reader = new Scanner(toRead);
      }
      catch (FileNotFoundException fnfEx)
      {
         return null;
      }
      
      ArrayList<Double> orders = new ArrayList<Double>();
      while(reader.hasNext())
      {
         orders.add(reader.nextDouble());
      }
      
      return new SalesStats(orders);
   }

}
