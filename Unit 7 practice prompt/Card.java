/**
 * 
 */
public class Card
{
   private String name;

   public Card()
   {
      name = "";
   }

   public Card(String n)
   {
      name = n;
   }

   public String getName()
   {
      return name;
   }

   public boolean isExpired()
   {
      return false;
   }

   public String format()
   {
      return "Card holder: " + name;
   }
   
   public boolean equals(Object other)
   {
       if (other instanceof Card)
       {
           Card otherCard = (Card)other;
           if (this.getName().equals(otherCard.getName()))
           {
               return true;
           }
       }
       return false;
   }
}