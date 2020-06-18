import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;

public class LogInGUI extends JFrame 
{
   static JFrame mainFrame;
   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 800;
   
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   
   private JButton button1;
   private JButton button2;
   
   private JTextField userName;
   private JPasswordField password;
  
   private JPanel panel;
   private JFrame frame;
   //öylesine password ayn? m? diye kontrol etmek için bi variable
   String pw = "abc";
   
   
   
   public LogInGUI()
   {
      //labels
      label1 = new JLabel("Welcome to AuctionHouse");
      label1.setLocation(50,50);
      label1.setSize(160,80);
      
      label2 = new JLabel("Log In");
      label2.setSize(60,50);
      label2.setLocation(50,150);
      
      label3 = new JLabel("To create a new user: Click me");
      label3.setSize(300,50);
      label3.setLocation(50,425);
      
      //buttons
      button1 = new JButton("Back");
      button1.setSize(130,50);
      button1.setLocation(50,520);
      
      button2 = new JButton("Sign In");
      button2.setSize(130,50);
      button2.setLocation(510,520);
      
      ActionListener listener = new SignButtonListener();
      button2.addActionListener(listener);
      
      ActionListener goBackListener = new goBackListener();
      button1.addActionListener(goBackListener);
      
      //textfields
      userName = new JTextField("UserName");
      userName.setSize(120,50);
      userName.setLocation(50,250);
      
      password = new JPasswordField(10);
      password.setText("Password");
      password.setSize(120,50);
      password.setLocation(50,350);

      
      //panel
      panel = new JPanel();
      panel.setLayout(null);
      panel.setSize(600,600);
      panel.setBackground(Color.pink);
      panel.add(label1);
      panel.add(label2);
      panel.add(label3);
      panel.add(button1);
      panel.add(button2);
      panel.add(userName);
      panel.add(password);
      
      //image
      BufferedImage image = null;
     try{ 
     image = ImageIO.read(new File("auction.png"));
    }catch(IOException ex){System.out.println("faileda");}
    
    JLabel imageLabel = new JLabel( new ImageIcon(image));
    imageLabel.setPreferredSize(new Dimension(400,400));

    imageLabel.setIcon(new ImageIcon(image.getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
     
     imageLabel.setLocation(300, 100);
     imageLabel.setSize(400,400);
     panel.add(imageLabel);
      
     setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(panel);
   }  
      public static void main (String[] args)
      {
         mainFrame = new LogInGUI();
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setVisible(true);
      }
      
      public void close()
   {
     mainFrame.setVisible(false);
   }
      //---------------------------inner classes for action listening-----------------------------
      public class SignButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
           String name = userName.getText();
           String pass = new String( password.getPassword());
           
           for(int i = 0; i < UserContainer.userList.size() ; i++)
           {
             String controlName = UserContainer.userList.get(i).getUserName();
             String controlPass = UserContainer.userList.get(i).getPassword();
               
             if(name.equals(controlName) && pass.equals(controlPass)   )
             {
               JFrame app = new App(i);
               app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               app.setSize(new Dimension(1600, 1080));
//               app.setVisible(true);
               dispose();
             }
               
           }
           
           
           
            
            
           
         }
      }
      
      
       //---------------------------inner class----------------------------------------------------
      class goBackListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JFrame frame =  new Home();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 500));
      frame.setVisible(true);
     dispose();
    }
  }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
