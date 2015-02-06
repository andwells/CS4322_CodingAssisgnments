public class PressRelease
{
   private String name;
   private int releaseDate;
   private String category;
   public PressRelease(String name, int releaseDate, String category)
   {
      this.name = name;
      this.releaseDate = releaseDate;
      this.category = category;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public int getReleaseDate()
   {
      return this.releaseDate;
   }
   
   public String getCategory()
   {
      return this.category;
   }
}