import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Subscriber implements Subscription
{
   private String subscriberName;
   
   //Comparators for sorting
   Comparator<PressRelease> byName;
   Comparator<PressRelease> byDate;
   Comparator<PressRelease> byCategory;
   
   public Subscriber(String name)
   {
      subscriberName = name;
      byName = new byNameComparator();
      byDate = new byDateComparator();
      byCategory = new byCategoryComparator();
   }
   
   public void update(Object arg)
   {      
      if(arg instanceof ArrayList)
      {
         System.out.printf("\n\nNew updates have been seen by %s! Printing data...\n", this.subscriberName);
         ArrayList<PressRelease> temp1 = (ArrayList<PressRelease>)arg;
         Collections.sort(temp1, byName);
         
         System.out.println("\n***\tMovies sorted by Name\t***");
         System.out.printf("%-50s\t%-14s\t%-10s\n", "Title", "Release Date", "Category");
         for(PressRelease pr : temp1)
         {
            System.out.printf("%-50s\t%-14s\t%-10s%n", pr.getName(), pr.getReleaseDate(), pr.getCategory());
         }
         
         System.out.println("\n***\tMovies sorted by Newest Release Year\t***");
         Collections.sort(temp1, byDate);//Sort items by year
         Collections.reverse(temp1);//Put newest releases first
         System.out.printf("%-50s\t%-14s\t%-10s\n", "Title", "Release Date", "Category");
         for(PressRelease pr : temp1)
         {
            System.out.printf("%-50s\t%-14s\t%-10s%n", pr.getName(), pr.getReleaseDate(), pr.getCategory());
         }
         
         System.out.println("\n***\tMovies sorted by Category\t***");
         System.out.printf("%-50s\t%-14s\t%-10s\n", "Title", "Release Date", "Category");
         Collections.sort(temp1, byCategory);
         for(PressRelease pr : temp1)
         {
            System.out.printf("%-50s\t%-14s\t%-10s%n", pr.getName(), pr.getReleaseDate(), pr.getCategory());
         }
      }
   }
   
   private class byNameComparator implements Comparator<PressRelease>
   {
      public int compare(PressRelease pr1, PressRelease pr2)
      {
         if(pr1.getName().compareTo(pr2.getName()) < 0)
         {
            return -1;
         }
         else if(pr1.getName().compareTo(pr2.getName()) == 0)
         {
            return 0;
         }
         else
         {
            return 1;
         }
      }
   }
   
   private class byDateComparator implements Comparator<PressRelease>
   {
      public int compare(PressRelease pr1, PressRelease pr2)
      {
         if(pr1.getReleaseDate() < pr2.getReleaseDate())
         {
            return -1;
         }
         else if(pr1.getReleaseDate() == pr2.getReleaseDate())
         {
            return 0;
         }
         else
         {
            return 1;
         }
      }
   }
   
   private class byCategoryComparator implements Comparator<PressRelease>
   {
      public int compare(PressRelease pr1, PressRelease pr2)
      {
         if(pr1.getCategory().compareTo(pr2.getCategory()) < 0)
         {
            return -1;
         }
         else if(pr1.getCategory().compareTo(pr2.getCategory()) == 0)
         {
            return 0;
         }
         else
         {
            return 1;
         }
      }
   }
}