
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.*;
/**
 * Auto Generated Java Class.
 */
public class FileWriter {
   
  
  
  public static void productWriter()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("ProductDataBase.txt");
    
    ArrayList<Product> temp = ProductContainer.getProductList();
    
    for(int i = 0; i < temp.size(); i++)
    {
      String ownerID;
      if(temp.get(i).getOwner() == null)
      {
        ownerID = null;
      }
      else
      {
        ownerID = ""+ temp.get(i).getOwner().getUserID();
      }
      
      
      out.println("##"+temp.get(i).getProductID() +"##\t\t"
                 +"=="+temp.get(i).getName() +"=="
                 +"@@"+temp.get(i).getInformation() +"@@"
                 +"**"+temp.get(i).getType() +"**"
                 +"$$"+temp.get(i).getStartPrice() +"$$"
                 +"££"+temp.get(i).getBuyItNowPrice() +"££"
                 +"%%"+temp.get(i).getCurrentPrice() +"%%"
                 +"--"+temp.get(i).getSeller().getUserID() +"--"
                 +"??"+temp.get(i).getSolded() +"??"
                 +"++"+ownerID +"++"
                 +"&&"+temp.get(i).getDate()+"&&"
//                 +"!!"+ProductContainer.productList.get(i).getProductImage()+"!!"
                 );
    }

    out.close();
    
    ProductContainer.update();
  }
  
  public static void userWriter()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("UserDataBase.txt");
    
    for(int i = 0; i < UserContainer.userList.size(); i++)
    {
     
      out.println("##"+UserContainer.userList.get(i).getUserID() +"##\t\t"
                 +"=="+UserContainer.userList.get(i).getUserName() +"=="
                 +"@@"+UserContainer.userList.get(i).getPassword() +"@@"
                 +"**"+UserContainer.userList.get(i).getBalance() +"**"
//                 +"%%"+comments +"%%"
                 );
    }

    out.close();
  }
  
  
}
