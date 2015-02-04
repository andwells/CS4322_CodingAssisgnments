import java.util.ArrayList;
import java.util.Scanner;

public class ContentProvider implements Content
{
   private Integer notifyThreshold;   
   private ArrayList<Subscription> subscribers;
   private ArrayList<String> newsBuffer;
   private Scanner scan;
   
   public void setThreshold(Integer newThreshold)
   {
      if(newThreshold>0)
         notifyThreshold = newThreshold;
   }
   
   public void notifySubscribers()
   {
      for(Subscription sub : subscribers)
         sub.Update(null);
   }
   
   public Boolean subscribe(Subscription aSubscription)
   {
      subscribers.add(aSubscription);
      return true;
   }
   
   public Boolean unsubscribe(Subscription toRemove)
   {
      if(subscribers.contains(toRemove)
      {
         subscribers.remove(toRemove);
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public ContentProvider() throws IOException
   {
         notifyThreshold = 10;
         subscribers = new ArrayList<Subscription>;
         newsBuffer = new ArrayList<String>;
         scan = new Scanner(new File("news.txt"));
   }
   
   public void readFromFile() 
   {
      if(scan.hasNext())
      {
         newsBuffer.add(scan.NextLine());
         if(newsBuffer.size()>=notifyThreshold)
            notifySubscribers();
      }
   }
   
}
