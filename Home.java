import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;

import java.awt.event.ActionListener;

  
 public class Home extends JFrame
{
  //properties
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 500;
   static JFrame mainFrame;
     
   private JLabel label;
   private JButton button1;
   private JButton button2;
   private JPanel buttonPanel;
   private JPanel panel;
   private JFrame frame;
   
   ActionListener logInListener = new logInListener();
   ActionListener signUpListener = new signUpListener();
   
   
   //constructor
   public Home()
   {
     new Menu();
      JLabel label = new JLabel("Welcome to AuctionHouse");
      JButton button1 = new JButton("Log In");
      JButton button2 = new JButton("Sign Up");
      JPanel buttonPanel = new JPanel();
      JPanel panel =  new JPanel();
     
     panel.setLayout(new BorderLayout());
     
     buttonPanel.setLayout(null);
     buttonPanel.setLocation(200, 200);
     buttonPanel.setSize(400,400);
     button1.setSize(100,40);
     button2.setSize(100,40);
     button1.setLocation(185,150);
     button2.setLocation(185,200);
     label.setLocation(165,65);
     label.setSize(300,40);
//     buttonPanel.setSize(50,50);
    button1.setBackground(Color.PINK);
    button1.setForeground(Color.BLACK);
    button2.setBackground(Color.PINK);
    button2.setForeground(Color.BLACK);
    
    button1.addActionListener(logInListener);
    button2.addActionListener(signUpListener);
    
     buttonPanel.add(button1);
     buttonPanel.add(button2);
     buttonPanel.add(label);
//     panel.add(buttonPanel, BorderLayout.CENTER);
     
     
     
      BufferedImage image = null;
     try{ 
     image = ImageIO.read(new File("auction.png"));
    }catch(IOException ex){System.out.println("faileda");}
    
    JLabel imageLabel = new JLabel( new ImageIcon(image));
    imageLabel.setPreferredSize(new Dimension(200,200));

    
    imageLabel.setIcon(new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
     
     imageLabel.setLocation(150, 250);
     imageLabel.setSize(200,200);
     
     
     
     
     buttonPanel.add( imageLabel );
     add(buttonPanel);
     setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }   
     //---------------------------------------------inner class-----------------------------------------------
  
      class logInListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { 
      JFrame frame =  new LogInGUI();
      frame.setSize(new Dimension(800, 800));
      frame.setVisible(true);
      dispose();
    }
  }
     class signUpListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JFrame frame =  new SignUpGUI();
      frame.setSize(new Dimension(900, 900));
      frame.setVisible(true);
      dispose();
    }
  }
      
     
     //-----------------------------------------------------------------------------------------------------
     
   public static void main (String[] args)
   {
     mainFrame = new Home();
     
     mainFrame.getContentPane().setBackground( Color.YELLOW );
     
     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     mainFrame.setVisible(true);
   }
   
   public void close()
   {
     mainFrame.setVisible(false);
   }
   
 }