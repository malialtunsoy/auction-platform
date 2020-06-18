import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ShoppingCart
{


   public static ArrayList<Integer> readCart(int userID)throws FileNotFoundException
   {
     Scanner in = new Scanner(new File("CartDataBase.txt")); //input scanner
     
     ArrayList<Integer> cart = new ArrayList<Integer>();
     int id;
     
     
     while (in.hasNext())
     {
      String line = in.nextLine();

         id = Integer.parseInt(FileReader.findIn("##" , line));
      
         if(userID == id)
         {
           cart =  takeCart(line);
         }
 
     }
     in.close();
     return cart;
   }
   
    public static void writeCart()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("CartDataBase.txt");
    
    for(int i = 0; i < UserContainer.userList.size(); i++)
    {
      int userID;
      ArrayList<Integer> carts;
      userID = UserContainer.userList.get(i).getUserID(); 
      carts = UserContainer.userList.get(i).getShoppingCart(); 
     
      
      
      
      out.print("##"+userID+"##\t\t**" );
      for(int ii = 0 ; ii < carts.size() ; ii++)
      {
        out.print( carts.get(ii) + "**");
      }
      out.println();
    }

    out.close();
  }
   
   
  
    static public ArrayList<Integer> takeCart(String line)
   {
      int sentinelStart=0;
      int sentinelEnd=0;
      ArrayList<Integer> carts = new ArrayList<Integer>();
     
      while(line.indexOf("**", sentinelStart) > 0)
      {
      sentinelStart = line.indexOf("**",sentinelStart);
      sentinelEnd = line.indexOf("**", sentinelStart +1);
      int tempCart = 0;
      if(sentinelEnd > 0)
      {
      tempCart = Integer.parseInt(line.substring(sentinelStart + 2 , sentinelEnd));

      carts.add(tempCart);
      }
        
      sentinelStart++;
      }
     return carts;
   }
   

}