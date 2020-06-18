import javax.swing.JFrame;
/**
 * Auto Generated Java Class.
 */
public class App extends JFrame {
  static JFrame AuctionAppFrame;
  
  
  public static void main(String[] args) { 
    
    int id = 0;
//    new App(2); //for test
 
  }
  
  public App(int id)
  {
   AuctionAppFrame = new JFrame();  //Create a new Frame
   AuctionAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    TheMainPanel MainPanel = new TheMainPanel(id); //Create a new TheMa?nPanel
    AuctionAppFrame.add(MainPanel); //Add a panel to the frame

    
    AuctionAppFrame.pack();
    AuctionAppFrame.setVisible(true);
  
  }
  
  public static void signOut()   //signOut 
  {
    AuctionAppFrame.setVisible(false); 
  }
  
  
}
