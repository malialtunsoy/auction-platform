import java.util.*; 

public class UserContainer
{
  //properties
   static ArrayList<User> userList;
   
   public UserContainer()
   {
     userList = FileReader.takeUsers();
   }
   
   public static void displayContainer()
   {
      for(int i = 0; i < userList.size(); i++)
      {
        System.out.println("User ID: " + userList.get(i).getUserID());
        System.out.println("User Name: " + userList.get(i).getUserName());
        System.out.println("User Password: " + userList.get(i).getPassword());
        System.out.println("User Rating: " + userList.get(i).getUserRatings());
        System.out.println("User Balance: " + userList.get(i).getBalance());
        
      
        System.out.println("\n\n");
      }
          
   }
  
}
