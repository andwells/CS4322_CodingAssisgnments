import java.util.ArrayList;
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
      return 0.0;
  }
  
  private double calcAverage(ArrayList<Double> values)
  {
      return 0.0;
  }
  
  private double calcMedian(ArrayList<Double> values)
  {
      return 0.0;
  }
  
  private double calcStandDev(ArrayList<Double> values)
  {
      return 0.0;
  }
  
  private double calcMin(ArrayList<Double> values)
  {
      return 0.0;
  }
  
  private double calcMax(ArrayList<Double> values)
  {
      return 0.0;
  }
}