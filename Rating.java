import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Rating
{


   public static ArrayList<Double> readRatings(int userID)throws FileNotFoundException
   {
     Scanner in = new Scanner(new File("RatingDataBase.txt")); //input scanner
     
     ArrayList<Double> rate = new ArrayList<Double>();
     int id;
     
     
     while (in.hasNext())
     {
      String line = in.nextLine();

         id = Integer.parseInt(FileReader.findIn("##" , line));
      
         if(userID == id)
         {
           rate = takeRatings(line);
         }
 
     }
     in.close();
     return rate;
   }
   
    public static void writeRatings()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("RatingDataBase.txt");
    
    for(int i = 0; i < UserContainer.userList.size(); i++)
    {
      int userID;
      ArrayList<Double> ratings;
      userID = UserContainer.userList.get(i).getUserID(); 
      ratings = UserContainer.userList.get(i).getUserRatings(); 
     
      
      
      
      out.print("##"+userID+"##\t\t**" );
      for(int ii = 0 ; ii < ratings.size() ; ii++)
      {
        out.print( ratings.get(ii) + "**");
      }
      out.println();
    }

    out.close();
  }
   
   
  
    static public ArrayList<Double> takeRatings(String line)
   {
      int sentinelStart=0;
      int sentinelEnd=0;
      ArrayList<Double> ratings = new ArrayList<Double>();
     
      while(line.indexOf("**", sentinelStart) > 0)
      {
      sentinelStart = line.indexOf("**",sentinelStart);
      sentinelEnd = line.indexOf("**", sentinelStart +1);
      Double tempRate = 0.0;
      if(sentinelEnd > 0)
      {
      tempRate = Double.parseDouble(line.substring(sentinelStart + 2 , sentinelEnd));

      ratings.add(tempRate);
      }
        
      sentinelStart++;
      }
     return ratings;
   }
   

}