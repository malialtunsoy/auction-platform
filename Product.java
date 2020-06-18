import java.util.*; 
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.io.FileNotFoundException;

public class Product
{
   private String productName;
   private int productID;
   private String information;
   private String type;
   private ArrayList<String> productImages;
   private double startingPrice;
   private double buyItNowPrice;
   private double currentPrice;
   private User seller;
   boolean solded;
   private User owner;
   
   String date;
   Timer leftTime;
   LocalDateTime d1;
   LocalDateTime d2;
   
     
   
//   private image images;
//   private Time auctionTime;
   
   public Product( String productName, String information, String type, double startingPrice, double buyItNowPrice,
                 double currentPrice, User seller, boolean solded, User owner, int productID, ArrayList<String> productImages , String date)
   {
   this.productName = productName;
   this.information = information;
   this.type = type;
   this.startingPrice = startingPrice;
   this.buyItNowPrice = buyItNowPrice;
   this.currentPrice = currentPrice;
   this.seller = seller;
   this.owner = owner;
   this.solded = solded;
   this.productID = productID;
   this.productImages = productImages;
   
   this.date = date;
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      d1 = LocalDateTime.now();
      d2 = LocalDateTime.parse(date, formatter);
      leftTime = new Timer( d1, d2 );
   }
   
   public String getName()
   {
      return productName;
   }
   public void setName( String productName )
   {
      this.productName = productName;
   }
   
   public String getInformation()
   {
      return information;
   }
   public void setInformation( String information )
   {
      this.information = information;
   }
   
   public String getType()
   {
      return type;
   }
   public void setType( String type )
   {
      this.type = type;
   }
   
   public double getStartPrice()
   {
      return startingPrice;
   }
   public void setStartPrice( double startingPrice )
   {
      this.startingPrice = startingPrice;
   }
   
   public double getBuyItNowPrice()
   {
      return buyItNowPrice;
   }
   public void setBuyItNowPrice( double buyItNowPrice )
   {
      this.buyItNowPrice = buyItNowPrice;
   }
   
   public double getCurrentPrice()
   {
      return currentPrice;
   }
   public void setCurrentPrice( double currentPrice )
   {
      this.currentPrice = currentPrice;
      
       try{ 
            FileWriter.productWriter();
//            System.out.println("Product List updated" + currentPrice );
          }catch(FileNotFoundException ex){System.out.println("failed");}
          
//          ProductContainer.update();
     
   }
   
   public User getSeller()
   {
      return seller;
   }
   public void setSeller( User seller )
   {
      this.seller = seller;
   }
   public User getOwner()
   {
      return owner;
   }
   public void setOwner( User owner )
   {
      this.owner = owner;
   }
   public boolean getSolded()
   {
     return solded;
   }
   public void setSolded( boolean solded)
   {
     this.solded = solded;
   }
   public int getProductID()
   {
     return productID;
   }
   public void setProductID(int id)
   {
     productID = id;
   }
   public ArrayList<String> getProductImages()
   {
     return productImages;
   }
   public void addImage( String img )
   {
     productImages.add( img );
   }
   
   public String getDate()
   {
     return date;
   }
   
   
}




