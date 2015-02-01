import java.io.File
import java.util.Scanner

public class PerItemStrategy implements SalesStrategy
{

  public SalesStats Read(File toRead)
  {
    
    Scanner reader;
    try
    {
      reader = new Scanner(toRead)
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
        orders.Add(itemSum)
        itemSum = 0;
      }
      else
        itemSum += Double.Parse(item);
    }
  
  return new SalesStats(orders);
  
  }
}
