import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class ContentProvider implements Content
{
   private Integer notifyThreshold;   
   private ArrayList<Subscription> subscribers;
   private ArrayList<PressRelease> newsBuffer;
   private Scanner scan;
   private boolean isChanged;
   
   public ContentProvider() throws IOException
   {
      notifyThreshold = 10;
      subscribers = new ArrayList<Subscription>();
      newsBuffer = new ArrayList<PressRelease>();
      scan = new Scanner(new File("movies.txt"));
      isChanged = false;
   }
   
   public void setThreshold(Integer newThreshold)
   {
      if(newThreshold>0)
         notifyThreshold = newThreshold;
   }
   
   public void notifySubscribers()
   {
      if(isChanged)
      {
         for(Subscription sub : subscribers)
         {
            sub.update(new ArrayList<PressRelease>(newsBuffer));
         }
         newsBuffer.clear();
         isChanged = false;
      }
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

   
   public boolean readFromFile()
   {
      String line;
      if(scan.hasNext())
      {
         line = scan.nextLine();
         String[] movieDetails = line.split("::");
         PressRelease movie = new PressRelease(movieDetails[0], Integer.parseInt(movieDetails[1]), movieDetails[2]);
         
         
         
         newsBuffer.add(movie);
         setChanged();
         if(isChanged)
         {
            notifySubscribers();
         }
         
         return true;
      }
      else
      {
         return false;
      }
      
   }
   
   public void start()
   {
      int counter = 0;
      boolean result = true;
      while(result)
      {
         result = readFromFile();
         counter++;
         if(counter %2 == 0)
         {
            this.setThreshold(counter / 2);
         }
      }
   }
   
   protected void setChanged()
   {
      if(newsBuffer.size() >= notifyThreshold)
      {
         isChanged = true;
      }
   }
   
}