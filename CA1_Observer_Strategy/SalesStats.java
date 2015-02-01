import java.util.ArrayList;
import java.util.Arrays;
public class SalesStats {
  private double total;

  private double average;

  private double median;

  private double standDev;

  private double min;

  private double max;

  public SalesStats(ArrayList values)
  {
      total = calcTotal(values);
      average = calcAverage(values);
      median = calcMedian(values);
      standDev = calcStandDev(values);
      min = calcMin(values);
      max = calcMax(values);
  }
  
  public double getTotal()
  {
      return this.total;
  }

  public double getAverage()
  {
      return this.average;
  }

  public double getMedian()
  {
      return this.median;
  }

  public double getStandardDeviation()
  {
      return this.standDev;
  }

  public double getMinimum()
  {
      return this.min;
  }

  public double getMaximum()
  {
      return this.max;
  }
  
  private double calcTotal(ArrayList<Double> values)
  {
      double tot = 0.0;
      for(double d : values)
      {
         tot += d;
      }
      return tot;
  }
  
  private double calcAverage(ArrayList<Double> values)
  {
      double sum = 0.0;
      for(double d: values)
      {
         sum += d;
      }
      return sum/values.size();
  }
  
  private double calcMedian(ArrayList<Double> values)
  {
      
      Double[] items = new Double[values.size()];
      items = values.toArray(items);
      Arrays.sort(items);
            
      return items[items.length/2];
  }
  
  private double calcStandDev(ArrayList<Double> values)
  {
      return 0.0;
  }
  
  private double calcMin(ArrayList<Double> values)
  {
      double aMin = Double.MAX_VALUE;
      for(Double d : values)
      {
         if(d <= aMin)
         {
            aMin = d;
         }
      }
      return aMin;
  }
  
  private double calcMax(ArrayList<Double> values)
  {
      double aMax = Double.MIN_VALUE;
      for(Double d: values)
      {
         if(d >= aMax)
         {
            aMax = d;
         }
      }
      
      return aMax;
  }
}