import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
public class Corporation
{

  private SalesStrategy  salesStrategy;      //The current strategy for reading data
  private HashMap<String, SalesStats> stores;//Maps stores names to sales data
  
  public Corporation()
  {
      stores = new HashMap<String, SalesStats>();
      salesStrategy = null;
      
      Scanner scan = new Scanner("Corporations.txt");
      scan.nextLine();//Consumes the column headers
      
      //Loops through the listing of files
      while(scan.hasNext())
      {
         //Grabs a row of data
         String storeName = scan.next();
         int format = scan.nextInt();
         String fileName = scan.next();
         
         //Sets the salesStrategy
         salesStrategy = setStrategy(format);
         
         //1)Calls the strategy's read method
         //2)Adds the resulting pair of storeName and SalesStats object to the map
         stores.put(storeName, salesStrategy.Read(new File(fileName)));
      }
  }
  
  /**
  * setStrategy
  * @param format a number indicating what SalesStrategy to use
  * @return the selected SalesStrategy
  */
  public SalesStrategy setStrategy(int format)
  {
      switch(format)
      {
         case 1:
            return new PerItemStrategy();
         case 2:
            return new PerOrderStrategy();
         default:
            return null;   
      }
  }
  
  public void setStrategy(SalesStrategy strategy)
  {
      this.salesStrategy = strategy;
  }
  
  /**
  * getStats
  * @param storeName the description of the store
  * @return the SalesStats object associated with the given store name
  */
  public SalesStats getStats(String storeName)
  {
      return stores.get(storeName);
  }
  
  
  /**
  * printReport
  * @return prints a formated report of all the data for the week, listed by store
  */
  public String printReport()
  {
      String report = "***\tSales Report\t****\n";
      for(String s : stores.keySet())
      {
         report+="\n*****" + s + "*****\n";
         SalesStats stat = stores.get(s);
         
         report += "Total:\t\t" + Math.round(stat.getTotal()) + "\n";
         report += "Average:\t\t" + Math.round(stat.getAverage()) + "\n";
         report += "Standard Deviation\t\t" + Math.round(stat.getStandardDeviation()) + "\n";
         report += "Minimum\t\t" + Math.round(stat.getMinimum()) + "\n";
         report += "Median\t\t" + Math.round(stat.getMedian()) + "\n";
         report += "Median\t\t" + Math.round(stat.getMaximum()) + "\n";         
      }
      report += "\n*****End of Report*****";
      
      return report;
  } 
}