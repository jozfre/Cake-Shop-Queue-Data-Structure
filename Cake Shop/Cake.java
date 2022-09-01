/* 
Author: Johan Zafri bin Johar

This is the Cake Java class
*/
import java.lang.*;
public class Cake
{
  
   private String custID; //D001, P003
   private String cakeType; //D24 Chocolate Cake,Red Velvet,Burnt Cheese Cake,Black Forest
   private int qty;
   private double price;
   
   public Cake(String ID,String cakeType, int qty)
   {    this.custID=ID;
        this.cakeType=cakeType;
        this.qty=qty;
   }
   
   public void setID(String ID){this.custID=ID;}
   public void setCakeType(String cakeType){this.cakeType=cakeType;}
   public void setQty(int qty){this.qty=qty;}
   
   //2.a)Write the retriever method for custID, cakeType and qty
   public String getID() {return custID;}
   public String getType() {return cakeType;}
   public int getQuantity() {return qty;}
  
   //2.b)Write the detPrice() method that will return the price of cake based on cakeType.Refer 2_GroupProject.docx
   public double detPrice()
   {
       if(getType().equalsIgnoreCase("D24 Chocolate Cake"))
       {
           price=120.00;
       }
       else if(getType().equalsIgnoreCase("Red Velvet"))
       {
           price=80.00;
       }
       else if(getType().equalsIgnoreCase("Burnt Cheese Cake"))
       {
           price=100.00;
       }
       else if(getType().equalsIgnoreCase("Black Forest"))
       {
           price=80.00;
       }
       return price;
   }
   
   //2.c)Write the toString method that will return the output look like as below:
   //Customer ID:XXXX    Cake Type:XXXXXXX   Price: RM XX.XX   Quantity:XX
   public String toString()
   {
        return String.format("Customer ID:%-5s Cake Type:%-19s Price:RM %-7.2f Quantity:%-3d",getID(),getType(),detPrice(),getQuantity());
   }
      
}