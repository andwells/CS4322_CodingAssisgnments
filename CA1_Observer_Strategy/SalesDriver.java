public class SalesDriver
{
   public static void main(String[] args)
   {
      try
      {
         Corporation c = new  Corporation();
         System.out.println(c.printReport());
      }
      catch (Exception ex)
      {
         System.out.println(ex);
      }
   }
}