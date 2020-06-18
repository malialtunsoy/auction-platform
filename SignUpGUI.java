import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpGUI extends JFrame
{
   private static final int FRAME_WIDTH = 900;
   private static final int FRAME_HEIGHT = 900;
   
   private JLabel label1;
   private JLabel label2;
   
   private JButton button1;
   private JButton button2;
   
   private JTextField name;
   private JTextField surname;
   private JTextField email;
   private JTextField cellNumber;
   private JPasswordField password;
   private JPasswordField passwordAgain;
   private JTextField birthday;
  
   private JPanel panel;
   private JFrame frame;
   
   public SignUpGUI()
   {
      //labels
      label1 = new JLabel("Welcome to AuctionHouse");
      label1.setLocation(50,50);
      label1.setSize(160,30);
      
      label2 = new JLabel("Sign Up");
      label2.setSize(70,50);
      label2.setLocation(50,100);
      
     
      
      //buttons
      button1 = new JButton("Back");
      button1.setSize(130,50);
      button1.setLocation(50,580);
      
      ActionListener goBackListener = new goBackListener();
      button1.addActionListener(goBackListener);
      
      button2 = new JButton("Sign Up");
      button2.setSize(130,50);
      button2.setLocation(350,580);
      
      ActionListener listener = new SignUpButtonListener();
      button2.addActionListener(listener);
      
      //textfields
      name = new JTextField("Name");
      name.setSize(200,50);
      name.setLocation(50,200);
      
//      surname = new JTextField("Surname");
//      surname.setSize(200,50);
//      surname.setLocation(350,200);
      
      email = new JTextField("Email");
      email.setSize(200,50);
      email.setLocation(50,280);
      
      cellNumber = new JTextField("Cell number");
      cellNumber.setSize(200,50);
      cellNumber.setLocation(350,280);
      
      password = new JPasswordField(10);
      password.setText("Password");
      password.setSize(200,50);
      password.setLocation(50,360);
      
      passwordAgain = new JPasswordField(10);
      passwordAgain.setText("Password");
      passwordAgain.setSize(200,50);
      passwordAgain.setLocation(350,360);
      
      birthday = new JTextField("Birthday");
      birthday.setSize(200,50);
      birthday.setLocation(50,440);
      
      //panel
      panel = new JPanel();
      panel.setLayout(null);
      panel.setSize(800,800);
      panel.setBackground(Color.pink);
      panel.setLocation(100,100);
      panel.add(label1);
      panel.add(label2);
      panel.add(name);
      panel.add(button1);
      panel.add(button2);
//      panel.add(surname);
      panel.add(email);
      panel.add(cellNumber);
      panel.add(password);
      panel.add(passwordAgain);
      panel.add(birthday);
      
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(label1);
      add(panel);
   }  
      public static void main (String[] args)
      {
         JFrame frame = new SignUpGUI();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
      }
      
      //---------------------------inner classes for action listening-----------------------------
      public class SignUpButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
               String pass = new String(password.getPassword());
               String pass2 = new String(passwordAgain.getPassword());
               if(pass.equals(pass2))
               {
                  String userName = name.getText();
                    String password = pass;
                    double balance = 0;
                  int id = Menu.findBiggestUserID();
                  ArrayList<String> comments = new ArrayList<String>();
                  ArrayList<Double> ratings = new ArrayList<Double>();
                  ArrayList<Integer> shoppingCart = new ArrayList<Integer>();
                  
                  
                  UserContainer.userList.add(new User( userName, password, balance, id, comments, ratings, shoppingCart )  );
                   Menu.updateUserList();
                   Menu.updateCommentList();
                   Menu.updateRatingList();
                   Menu.updateCartList();
                   
                   JFrame frame =  new Home();
                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   frame.setSize(new Dimension(500, 500));
                   frame.setVisible(true);
                   dispose();
               }
               else System.out.println("password and password again are not the same");
               
           
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