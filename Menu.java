import java.util.*; 
import java.io.FileNotFoundException;
/**
 * Auto Generated Java Class.
 */
public class Menu {
  
  static Scanner input = new Scanner(System.in);
  
  
  
//  public static void main(String[] args) 
//  { 
//    menu();
//  }
  public Menu()
  {
  new FileReader();
  new FileWriter();
  new ProductContainer();
  new UserContainer();
  new Comments();
  new Rating();
  new Images();
  new ShoppingCart();
  }
  
  public static void menu()
  {
    int option = 0;
    do
    {
     
    System.out.println("Select an Option"
                         + "\n1-display users"
                         +  "\n2-display products"
                         + "\n3-display user comments"
                         +"\n4-add user"
                         +"\n5-delete user"
                         +"\n6-add product"
                         +"\n7-delete product"
                         +"\n8-add a comment"
                         +"\n9-add a rate"
                         +"\n10-display rates"
                      );
    
    
    
    option = input.nextInt();
      
      if(option == 1) //display users
      {
        UserContainer.displayContainer() ;
      }
      if(option == 2) //display products
      {
        ProductContainer.displayContainer() ;
      }
      if(option == 3) //display users and comments
      {
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          System.out.println(UserContainer.userList.get(i).getUserID() +"  Comments: "+ UserContainer.userList.get(i).getUserComments());
        }
      }
      if(option == 4) //add user
      {
        input.nextLine();
        System.out.println("Enter a name");
        String userName = input.nextLine();
        System.out.println("Enter a password");
        String password = input.nextLine();
        
        double balance = 0;
        int id = findBiggestUserID();
        ArrayList<String> comments = new ArrayList<String>();
        ArrayList<Double> ratings = new ArrayList<Double>();
        ArrayList<Integer> shoppingCart = new ArrayList<Integer>();
        
        UserContainer.userList.add(new User( userName, password, balance, id, comments, ratings, shoppingCart )  );
        updateUserList();
        updateCommentList();
        updateRatingList();
      }
      if(option == 5) //delete user
      {
        UserContainer.displayContainer() ;
        System.out.println("Enter a user id that you want to delete");
        int delete = input.nextInt();
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          if(delete == UserContainer.userList.get(i).getUserID())
          {
            UserContainer.userList.remove(i);
            System.out.println("succesful");
          }
        }
        updateUserList();
        updateCommentList();
        updateRatingList();
        
      }
      if(option == 6) //add product
      {
        input.nextLine();
        System.out.println("Enter a name");
        String name = input.nextLine();
        System.out.println("Enter a information");
        String info = input.nextLine();
        System.out.println("Enter a type");
        String type = input.nextLine();
        System.out.println("Enter a starting price");
        double startingPrice = input.nextDouble();
        System.out.println("Enter a buy it now price");
        double buyItNowPrice = input.nextDouble();
        String date = "";
        input.nextLine();
        double currentPrice = startingPrice;
//        System.out.println("enter Image name");
//        String productImage = input.nextLine();
        System.out.println("select an owner by id\n");
        UserContainer.displayContainer() ;
        int selectSeller = input.nextInt();
        User seller = null;
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          if(selectSeller == UserContainer.userList.get(i).getUserID())
          {
            seller = UserContainer.userList.get(i);
            System.out.println("User " +  UserContainer.userList.get(i).getUserID() + " selected" );
          }
        }
        boolean solded = false;
        User owner = null;
        int id = findBiggestProductID() ;
        ArrayList<String> productImage = new ArrayList<String>();
        
        ProductContainer.productList.add(new Product( name, info, type, startingPrice, buyItNowPrice, currentPrice, seller, solded, owner, id, productImage, date)  );
        System.out.println("succesful");
        updateProductList();
        updateImageList();
      }
      if(option == 7)//delete product
      {
        ProductContainer.displayContainer() ;
        System.out.println("Enter a product id that you want to delete");
        int delete = input.nextInt();
        for(int i = 0; i < ProductContainer.productList.size() ; i++)
        {
          if(delete == ProductContainer.productList.get(i).getProductID())
          {
            ProductContainer.productList.remove(i);
            System.out.println("succesful");
          }
        }
        updateProductList();
      }
      if(option == 8)//add a comment 
      {
        System.out.println("select a user id that you want to add a comment");
        UserContainer.displayContainer() ;
         int select = input.nextInt();
         input.nextLine();
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          if(select == UserContainer.userList.get(i).getUserID())
          {
            System.out.println("Wrtie a comments");
            String comment = input.nextLine();
            UserContainer.userList.get(i).addComment(comment);
            System.out.println("comment added");
          }
        }
        updateCommentList();
        
      }
      if(option == 9)//add a rating
      {
        System.out.println("select a user id that you want to add a comment");
        UserContainer.displayContainer() ;
         int select = input.nextInt();
         input.nextLine();
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          if(select == UserContainer.userList.get(i).getUserID())
          {
            System.out.println("Rate a number between 0-5");
            
            Double rate = input.nextDouble();
            UserContainer.userList.get(i).addRating(rate);
            System.out.println("rated");
          }
        }
      
        updateRatingList();
        
      }
      if(option == 10) //display users and ratings
      {
        for(int i = 0; i < UserContainer.userList.size() ; i++)
        {
          double averageRate;
          double sum = 0;
          for(int ii = 0; ii < UserContainer.userList.get(i).getUserRatings().size(); ii++)
          {
            sum = sum + UserContainer.userList.get(i).getUserRatings().get(ii);
          }
          averageRate = sum / UserContainer.userList.get(i).getUserRatings().size();
          System.out.println(UserContainer.userList.get(i).getUserID() +"  Rating: "+ averageRate);
        }
      }
      if(option == 11)//add a image
      {
        System.out.println("select a product id that you want to add a comment");
        ProductContainer.displayContainer() ;
         int select = input.nextInt();
         input.nextLine();
        for(int i = 0; i < ProductContainer.productList.size() ; i++)
        {
          if(select == ProductContainer.productList.get(i).getProductID())
          {
            System.out.println("enter an image name");
            String img = input.nextLine();
            ProductContainer.productList.get(i).addImage(img);
            System.out.println("image added");
          }
        }
        updateImageList();
        
      }
      
    }while(option != 0);
  }
  
  public static void updateUserList()
  {
    try{      
      FileWriter.userWriter();
    }catch(FileNotFoundException ex){System.out.println("failed");}
    
  }
  
  public static void updateProductList()
  {
    try{ 
      
      FileWriter.productWriter();
      System.out.println("Product List updated");
    }catch(FileNotFoundException ex){System.out.println("failed");}
  }
  public static void updateRatingList()
  {
    try{ 
      
      Rating.writeRatings();
    }catch(FileNotFoundException ex){System.out.println("failed");}
  }
  
  public static void updateCommentList()
  {
    try{ 
      
      Comments.writeComments();
    }catch(FileNotFoundException ex){System.out.println("failed");}
  }
   public static void updateImageList()
  {
    try{ 
      
      Images.writeImages();
    }catch(FileNotFoundException ex){System.out.println("failed");}
  }
     public static void updateCartList()
  {
    try{ 
      
      ShoppingCart.writeCart();
    }catch(FileNotFoundException ex){System.out.println("failed");}
  }
  public static int findBiggestUserID()
  {
    int ID = 0;
    for(int i = 0; i < UserContainer.userList.size(); i++)
    {
      if(ID <  UserContainer.userList.get(i).getUserID())
      {
        ID = UserContainer.userList.get(i).getUserID();
      }   
    }
    return ID+1;
  }
   public static int findBiggestProductID()
  {
    int ID = 0;
     for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      if(ID <   ProductContainer.productList.get(i).getProductID())
      {
        ID =  ProductContainer.productList.get(i).getProductID();
      }   
    }
    return ID+1;
  }
  
  
}
