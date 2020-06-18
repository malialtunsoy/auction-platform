import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Comments
{

   public static ArrayList<String> readComments(int userID)throws FileNotFoundException
   {
     Scanner in = new Scanner(new File("CommentDataBase.txt")); //input scanner
     
     ArrayList<String> comm = new ArrayList<String>();
     int id;
     
     
     while (in.hasNext())
     {
      String line = in.nextLine();

         id = Integer.parseInt(FileReader.findIn("##" , line));
      
         if(userID == id)
         {
           comm = takeComments(line);
         }
     }
     in.close();
     return comm;
   }
   
    public static void writeComments()throws FileNotFoundException
  {
    PrintWriter out = new PrintWriter("CommentDataBase.txt");
    
    for(int i = 0; i < UserContainer.userList.size(); i++)
    {
      int userID;
      ArrayList<String> comments;
      userID = UserContainer.userList.get(i).getUserID(); 
      comments = UserContainer.userList.get(i).getUserComments(); 

      out.print("##"+userID+"##\t\t**" );
      for(int ii = 0 ; ii < comments.size() ; ii++)
      {
        out.print( comments.get(ii) + "**");
      }
      out.println();
    }
    out.close();
  }
   
    static public ArrayList<String> takeComments(String line)
   {
      int sentinelStart=0;
      int sentinelEnd=0;
      ArrayList<String> comments = new ArrayList<String>();
     
      while(line.indexOf("**", sentinelStart) > 0)
      {
      sentinelStart = line.indexOf("**",sentinelStart);
      sentinelEnd = line.indexOf("**", sentinelStart +1);
      String tempComment = "";
      if(sentinelEnd > 0)
      {
      tempComment = line.substring(sentinelStart + 2 , sentinelEnd);

      comments.add(tempComment);
      }
        
      sentinelStart++;
      }
     return comments;
   }
   

}