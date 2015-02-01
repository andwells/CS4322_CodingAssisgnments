import java.util.Scanner;
import java.io.*;
public class PerOrderStrategy implements SalesStrategy {

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
      
      while(reader.hasNext())
      {
         
      }
      
      return null;
  }

}