import java.util.*;


public class GeneralContainer
{
   ArrayList<User> userList;
   ProductContainer allProducts;
   ProductContainer searchContainer; 
   
   public GeneralContainer()
   {
      userList = new ArrayList<User>();
   }
   
   public void addUser( User user )
   {
      userList.add(user);
   }
   
   public ArrayList<User> displayUsers()
   {
      return userList;
   }
   
   public ProductContainer displayAllProduct()
   {
      return allProducts;
   }
   
   public ProductContainer searchProduct( String prodName )
   {
      for( int i = 0; i < allProducts.size(); i++ )
      {
         if( allProducts.get(i).getName().equals( prodName ) )
         {
            searchContainer.addProduct( allProducts.get(i) );
         }
      }
      return searchContainer;
   }
}