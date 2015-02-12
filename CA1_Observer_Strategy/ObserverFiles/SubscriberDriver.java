import java.util.ArrayList;
public class SubscriberDriver
{
   public static void main(String[] args)
   {
      try
      {
         Content cp = new ContentProvider();
         Subscription s1 = new Subscriber("Peter", cp);
         Subscription s2 = new Subscriber2("Andrew", cp);
         cp.start();
         System.out.println("\n\nCalling pull notification\n\n");
         
         cp.notifySubscribers();
      }
      catch(Exception ex)
      {
         System.out.println(ex);
      }
   }
}