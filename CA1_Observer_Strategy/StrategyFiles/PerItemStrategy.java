import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PerItemStrategy implements SalesStrategy
{

  public SalesStats Read(File toRead)
  {
    
    Scanner reader;
    try
    {
      reader = new Scanner(toRead);
    }
    catch (FileNotFoundException fnEx)
    {
      return null;
    }
    
    double itemSum = 0;
    String item;
    ArrayList<Double> orders = new ArrayList<Double>();
    while(reader.hasNext())
    {
      item = reader.next();
      if(item.equals("#"))
      {
        orders.add(itemSum);
        itemSum = 0;
      }
      else
        itemSum += Double.parseDouble(item);
    }
  
  return new SalesStats(orders);
  
  }
}
