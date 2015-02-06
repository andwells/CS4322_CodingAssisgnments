import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class ContentProvider implements Content
{
   private Integer notifyThreshold;   
   private ArrayList<Subscription> subscribers;
   private ArrayList<PressRelease> newsBuffer;
   private Scanner scan;
   
   public ContentProvider() throws IOException
   {
      notifyThreshold = 10;
      subscribers = new ArrayList<Subscription>();
      newsBuffer = new ArrayList<PressRelease>();
      scan = new Scanner(new File("news.txt"));
   }
   
   public void setThreshold(Integer newThreshold)
   {
      if(newThreshold>0)
         notifyThreshold = newThreshold;
   }
   
   public void notifySubscribers()
   {
      for(Subscription sub : subscribers)
      {
         sub.update(new ArrayList<PressRelease>(newsBuffer));
      }
      newsBuffer.clear();
   }
   
   public Boolean subscribe(Subscription aSubscription)
   {
      subscribers.add(aSubscription);
      return true;
   }
   
   public Boolean unsubscribe(Subscription toRemove)
   {
      if(subscribers.contains(toRemove))
      {
         subscribers.remove(toRemove);
         return true;
      }
      else
      {
         return false;
      }
   }
   
      
   /*public void readFromFile() 
   {
      if(scan.hasNext())
      {
         newsBuffer.add(scan.NextLine());
         if(newsBuffer.size()>=notifyThreshold)
            notifySubscribers();
      }
   }*/
   
   public boolean readFromFile()
   {
      String line;
      if(scan.hasNext())
      {
         line = scan.nextLine();
         String[] movieDetails = line.split("::");
         // SimpleDateFormat df = new SimpleDateFormat();
//          df.parseObject(movieDetails[1]);
         PressRelease movie = new PressRelease(movieDetails[0], Integer.parseInt(movieDetails[1]), movieDetails[2]);
         newsBuffer.add(movie);         
         return true;
      }
      else
      {
         return false;
      }
      
   }
   
   public void start()
   {
      boolean result = true;
      while(result)
      {
         result = readFromFile();
      }
   }
   
}