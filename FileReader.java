import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
/**
 * Auto Generated Java Class.
 */
public class FileReader {
  
  
  public static void main(String[] args) throws FileNotFoundException
  { 
     readProduct();
   }
  

   public static ArrayList<Product> readProduct()throws FileNotFoundException
   {
   
   Scanner in = new Scanner(new File("ProductDataBase.txt")); //input scanner
 
   
   
   ArrayList<Product> temp = new ArrayList<Product>();
    
    //read word from text
      while (in.hasNext())
      {
         String line = in.nextLine();
         
         int id = 0;
         String name = "";
         String info = "";
         String type = "";
         String date = "";
         double startingPrice = 0;
         double buyItNowPrice = 0;
         double currentPrice = 0;
         int sellerId = 0;
         boolean solded = false;
         User seller;
         User owner;
         int ownerId = 0;
         ArrayList<String> productImages = new ArrayList<String>();
         
         id = Integer.parseInt(findIn("##" , line)); //------------------produtID
         name = findIn("==" , line); //------------------name
         info = findIn("@@" , line); //------------------info
         type = findIn("**" , line); //------------------type
         startingPrice = Double.parseDouble(findIn("$$" , line)); //------------------startingPrice
         buyItNowPrice = Double.parseDouble(findIn("££" , line)); //------------------buyItNowPrice
         currentPrice = Double.parseDouble(findIn("%%" , line)); //------------------currentPrice
         sellerId = Integer.parseInt(findIn("--" , line)); //------------------seller
         seller = idToUser(sellerId);
         date = findIn("&&" , line);
         String trueFalse = findIn("??" , line); //------------------solded or not
         if (trueFalse.equals("true"))
         {
           solded = true;
         }
         if (trueFalse.equals("false"))
         {
           solded = false;
         }
         
         if(findIn("++" , line).equals("null"))
         {
           owner = null;
         }
         else
         {
         ownerId = Integer.parseInt(findIn("++" , line));      //------------------ownwerId
         owner = idToUser(ownerId);
         
         }
         productImages = Images.readImages(id);   // --------image
        

//---------------------------------------------------------------------------------------------
    
         Product tempa;
         tempa = new Product( name, info, type, startingPrice, buyItNowPrice, currentPrice, seller, solded, owner, id, productImages, date);
        
         temp.add(tempa);
   
         }
          in.close(); //close scanners
    
    return temp;
    
      }
   
   
   
   //*****************************************************************************************************
    //*****************************************************************************************************
    public static ArrayList<User> readUser()throws FileNotFoundException
   {
     
   Scanner input = new Scanner(new File("UserDataBase.txt")); //input scanner
 
   
    ArrayList<User> temp = new ArrayList<User>();
    
    //read word from text
      while (input.hasNext())
      {

         String line = input.nextLine();
         
         int id = 0;
         String name = "";
         String password = "";
         double balance = 0;
         ArrayList<String> comments;
         ArrayList<Double> ratings;
          ArrayList<Integer> shoppingCart;
//         Comments comment;
        
         
         id = Integer.parseInt(findIn("##" , line)); //------------------userID
         name = findIn("==" , line); //------------------userName
         password = findIn("@@" , line); //------------------userPassword
         balance = Double.parseDouble(findIn("**" , line)); //------------------balance
         comments = Comments.readComments(id);
         shoppingCart = ShoppingCart.readCart(id);
         ratings = Rating.readRatings(id);
         //---------------------------------------------------------------------------------------------

//         FileReader a = new FileReader();
        
         User tempa;
         tempa = new User( name, password, balance, id, comments, ratings, shoppingCart);
         
         temp.add(tempa);

         }
    input.close(); //close scanners
    
    return temp;
      
    }
  
    static public User idToUser(int id)
    {
      ArrayList<User> temp = takeUsers();
      
      for(int i=0; i < temp.size() ; i++)
      {
        
        if(temp.get(i).getUserID() == id)
        {
          
          return temp.get(i);
          
        }
      }
      
      return null;
    }
   
   static  public ArrayList<Product> takeProducts()
    {
     ArrayList<Product> temp;
     temp=null;
     try{ 
       
          temp = readProduct();
     }catch(FileNotFoundException ex){System.out.println("failed");}
      
      return temp;
    }
   
   static  public ArrayList<User> takeUsers()
    {
     ArrayList<User> temp;
     temp=null;
     try{ 
       
          temp = readUser();
     }catch(FileNotFoundException ex){System.out.println("failed");}
      
      return temp;
    }
   
   static public String findIn(String sent, String line)
   {
      int sentinelStart;
      int sentinelEnd;

      sentinelStart = line.indexOf(sent);
      sentinelEnd = line.indexOf(sent, sentinelStart +1);
         if(sentinelStart > -1)
         {
         return line.substring(sentinelStart + 2 , sentinelEnd);
         }
         return "";
   }
   
   
  
}
