import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class PerCsvStrategy implements SalesStrategy
{
   public PerCsvStrategy()
   {
   }
   
   public SalesStats Read(File toRead)
   {
      Scanner scan;
      try
      {
         scan = new Scanner(toRead);
      }
      catch(IOException io)
      {
         return null;
      }
      ArrayList<String> lines = new ArrayList<String>();
      ArrayList<Double> orders = new ArrayList<Double>();
      
      
      while(scan.hasNext())
      {
         String[] row = scan.nextLine().split(",");
         double orderSum = 0.0;
         for(int j = 0; j < row.length; j++)
         {
            orderSum+= Double.parseDouble(row[j]);
         }
         orders.add(orderSum);
      }
      
      return new SalesStats(orders);
   }
}