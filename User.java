import java.util.*; 
public class User
{
   private String userName;
   private String password;
   private int userId; //sonra düzenl
   private double balance;
   
   private ArrayList<Product> usersCart;
   
   ArrayList<String> comments;
   ArrayList<Double> ratings;
   ArrayList<Integer> shoppingCart;

   
   public User(String userName, String password, double balance, int id, ArrayList<String> comments, ArrayList<Double> ratings,  ArrayList<Integer> shoppingCart)
   {
   this.userName = userName;
   this.password = password;
   this.balance = balance;
   this.userId = id;
   this.comments = comments;
   this.ratings = ratings;
   this.shoppingCart = shoppingCart;
   
   }
   
   public String getUserName()
   {
      return userName ;
   }
   public void setUserName( String userName )
   {
      
   }
   
   public String getPassword()
   {
      return password;
   }
   public void setPassword( String password )
   {
      
   }
   
   
   public void setUserName( double userRating )
   {
      
   }
   
//   public ProductContainer displayUserShop()
//   {
//      
//   }
   
   public void addProduct( Product product )
   {
      
   }
   
//   public ProductContainer displayUserCart()
//   {
//      
//   }
//   
//   public ProductContainer displayUserItems()
//   {
//      
//   }
   
   public double getBalance()
   {
      return balance;
   }
   public void setBalance( int balance )
   {
      
   }
   
    public int getUserID()
   {
     return userId;
   }
   public void setUserID(int id)
   {
     userId = id;
   }
   public ArrayList<String> getUserComments()
   {
     return comments;
   }
   public void addComment( String comm )
   {
     comments.add( comm );
   }
     public ArrayList<Double> getUserRatings()
   {
     return ratings;
   }
     public double getUserRatingDouble()
     {
        double averageRate;
          double sum = 0;
          for(int ii = 0; ii < getUserRatings().size(); ii++)
          {
            sum = sum + getUserRatings().get(ii);
          }
          averageRate = sum / getUserRatings().size();
          return averageRate;
     }
     public void addRating( Double rate )
   {
     ratings.add( rate );
//     System.out.println( "aaaaaa" );
   }
    public ArrayList<Integer> getShoppingCart()
   {
     return shoppingCart;
   }
    public void addCart( int cart )
   {
     shoppingCart.add( cart );
   }
    public void removeCart( int productID )
    {
      for(int i = shoppingCart.size() - 1; -1 < i ; i--)
      {
       if(   shoppingCart.get(i) == productID     )
       {
         shoppingCart.remove(i);
       }
        
      } 
    }
     
}