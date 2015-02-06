import java.util.ArrayList;
public class SubscriberDriver
{
   public static void main(String[] args)
   {
      try
      {
         Content cp = new ContentProvider();
         Subscription s1 = new Subscriber("Peter");
         Subscription s2 = new Subscriber2("Andrew");
         cp.subscribe(s1);
         cp.subscribe(s2);
         cp.start();
      }
      catch(Exception ex)
      {
         System.out.println(ex);
      }
   }
}