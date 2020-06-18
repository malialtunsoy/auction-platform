import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Images
{


   public static ArrayList<String> readImages(int userID)throws FileNotFoundException
   {
     Scanner in = new Scanner(new File("ImageDataBase.txt")); //input scanner
     
     ArrayList<String> img = new ArrayList<String>();
     int id;
     
     
     while (in.hasNext())
     {
      String line = in.nextLine();

         id = Integer.parseInt(FileReader.findIn("##" , line));
      
         if(userID == id)
         {
           img = takeImages(line);
         }
 
     }
     in.close();
     return img;
   }
   
    public static void writeImages()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("ImageDataBase.txt");
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      int productID;
      ArrayList<String> images;
      productID = ProductContainer.productList.get(i).getProductID(); 
      images = ProductContainer.productList.get(i).getProductImages(); 
     
      
      
      
      
     
      if(images.size() == 0)
      {
        out.print("##"+productID+"##\t\t**" ); 
        out.print("blank.png**" );
      }
      else
      {
        out.print("##"+productID+"##\t\t**" ); 
        for(int ii = 0 ; ii < images.size() ; ii++)
        {
          out.print( images.get(ii) + "**");
        }
      }
      out.println();
    }

    out.close();
  }
   
   
  
    static public ArrayList<String> takeImages(String line)
   {
      int sentinelStart=0;
      int sentinelEnd=0;
      ArrayList<String> images = new ArrayList<String>();
     
      while(line.indexOf("**", sentinelStart) > 0)
      {
      sentinelStart = line.indexOf("**",sentinelStart);
      sentinelEnd = line.indexOf("**", sentinelStart +1);
      String tempImage = "";
      if(sentinelEnd > 0)
      {
      tempImage = line.substring(sentinelStart + 2 , sentinelEnd);

      images.add(tempImage);
      }
        
      sentinelStart++;
      }
     return images;
   }
   

}