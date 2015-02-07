import java.util.ArrayList;
public class Subscriber2 implements Subscription
{
   private String subscriberName;
   
   public Subscriber2(String name)
   {
      subscriberName = name;
   }
   
   public void update(Object arg)
   {
      if(arg instanceof ArrayList)
      {
         System.out.printf("\n\nNew updates have been seen by %s! Printing data...\n", this.subscriberName);
         ArrayList<PressRelease> temp1 = (ArrayList<PressRelease>)arg;

         System.out.printf("%-50s\t%-14s\t%-10s\n", "Title", "Release Date", "Category");
         for(PressRelease pr : temp1)
         {
            System.out.printf("%-50s\t%-14s\t%-10s%n", pr.getName(), pr.getReleaseDate(), pr.getCategory());
         }

      }

   }
}