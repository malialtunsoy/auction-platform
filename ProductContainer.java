import java.util.*; 

public class ProductContainer extends UserContainer
{
  //properties
   static ArrayList<Product> productList;
   
    public  ProductContainer()
   {
     productList = FileReader.takeProducts();
   }
   
  public static void update()
  {
    productList = FileReader.takeProducts();
  }
   
   public void addProduct( Product product )
   {
      productList.add(product);
   }
   
   public static void displayContainer()
   {
      for(int i = 0; i < productList.size(); i++)
      {
        
        System.out.println("Product ID: " + productList.get(i).getProductID());
        System.out.println("Product Name: " + productList.get(i).getName());
        System.out.println("Product Information: " + productList.get(i).getInformation());
        System.out.println("Product Type: " + productList.get(i).getType());
        System.out.println("Product Starting Price: " + productList.get(i).getStartPrice());
        System.out.println("Product Buy it now Price: " + productList.get(i).getBuyItNowPrice());
        System.out.println("Product Current Price: " + productList.get(i).getCurrentPrice());
        System.out.println("Products Seller: " + productList.get(i).getSeller().getUserName());
        if(productList.get(i).getOwner() == null)
        {
          System.out.println("Products Owner: null" );
        }
        else
        {
        System.out.println("Products Owner: " + productList.get(i).getOwner().getUserName());
        }
        System.out.println("Is Product sold?: " + productList.get(i).getSolded());
//        System.out.println("Image name: " + productList.get(i).getProductImages());
         System.out.println("\n\n");
      }
          
   }
   
   public int size()
   {
      return productList.size();
   }
   
   public static ArrayList<Product> getProductList()
   {
     return productList;
   }
   
   public Product get( int index )
   {
      return productList.get(index);
   }
}