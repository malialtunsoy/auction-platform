import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

/**
 * Auto Generated Java Class.
 */
public class Profile extends JPanel {
  
    final int WIDTH = 1300;
    final int HEIGHT = 1000;
    
    static JPanel mainProfilePanel;
    
    JPanel profileHeadingPanel;
    static JPanel yourShopPanel;
    static JPanel yourShopPanelInner;
    static JScrollPane ShopScroll;
    JPanel commentsPanel;
    JLabel balance;
    static int userID;
    int wantedUserID = 0;
    
    ActionListener addProductListener = new addProductListener();
    ActionListener signOutListener = new signOutListener();
  
  //********************************************************************************CONSTRUCTOR
  //******************************************************************************** 
  public Profile(int userID)
  { 
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.userID = userID;
//    new Menu();
    findUser();
    prepareMainPanel();
    
    
    add(mainProfilePanel);
  }
  
  
  public void findUser()
  {
    for(int i = 0 ; i < UserContainer.userList.size() ; i++)
    {
      if( UserContainer.userList.get(i).getUserID() == userID )
      {
//        System.out.println("" + i + "      "  + userID );
        wantedUserID = i;
      }
      
    }
  }
  
  
   //********************************************************************************MAIN
  //******************************************************************************** PANEL
  
   public void prepareMainPanel()
  {
     mainProfilePanel = new JPanel();
     mainProfilePanel.setPreferredSize(new Dimension(1300,1000));
     
    prepareHeadingPanel();
    prepareShopPanel();
    prepareCommentsPanel();
    
    mainProfilePanel.add(profileHeadingPanel);
    mainProfilePanel.add(yourShopPanel);
    mainProfilePanel.add(commentsPanel);
    
    balance = new JLabel( "Balance: $" + UserContainer.userList.get(userID).getBalance()  );
    
    mainProfilePanel.add(balance);
  }
  
  
   //********************************************************************************HEADING
  //******************************************************************************** PANEL
  public void prepareHeadingPanel()
  {
    profileHeadingPanel = new JPanel();
    profileHeadingPanel.setLayout(null);
    profileHeadingPanel.setPreferredSize(new Dimension(1300,200));
    profileHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    JLabel userName =  new JLabel("User: " + UserContainer.userList.get(userID).getUserName());
    userName.setLocation( 20,35 );
    userName.setSize( 200,51 );
    
    
    StarRate stars = new StarRate(ProductContainer.productList.get(userID).getSeller().getUserRatingDouble());
    stars.setLocation( 20,135 );
    stars.setSize( 100,51 );
    
    
    JLabel addProduct  =  new JLabel("Add a new product to your shop");
    addProduct.setLocation( 800,35  );
    addProduct.setSize( 200,51 );
    
    
    JLabel signOut =  new JLabel("Sign Out from your prifle");
    signOut.setLocation( 800,135  );
    signOut.setSize( 200,51 );
    
    JButton addProductButton = new JButton("Add Product");
    addProductButton.setLocation( 1050,35  );
    addProductButton.setSize( 200,51 );
    addProductButton.addActionListener(addProductListener);
    
    JButton signOutButton = new JButton("Sign Out");
    signOutButton.setLocation( 1050,135  );
    signOutButton.setSize( 200,51 );
    signOutButton.addActionListener(signOutListener);
    
    profileHeadingPanel.add(userName);
    profileHeadingPanel.add(stars);
    profileHeadingPanel.add(addProduct);
    profileHeadingPanel.add(signOut);
    profileHeadingPanel.add(addProductButton);
    profileHeadingPanel.add(signOutButton);
       
  }
  
  
   //********************************************************************************YOUR SHOP
  //******************************************************************************** PANEL
  
  public void prepareShopPanel()
  {
    yourShopPanel = new JPanel();
    yourShopPanel.setLayout(null);
    yourShopPanel.setPreferredSize(new Dimension(1300,500));
    yourShopPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
 
    
    updateShopPanel();    
   
  
  }
  
  public static void updateShopPanel()
  { 
    JLabel yourShopLabel = new JLabel("Your Shop:");
    yourShopLabel.setLocation(10,0  );
    yourShopLabel.setSize(100,51 );
    
    
    yourShopPanelInner = new JPanel();

    yourShopPanelInner.setBorder(BorderFactory.createLineBorder(Color.black, 1));

    
    BoxLayout boxlayout = new BoxLayout(yourShopPanelInner, BoxLayout.X_AXIS);
    yourShopPanelInner.setLayout(boxlayout);
    
    
    
    for(int i = 0 ; i < ProductContainer.productList.size() ; i++)
    {
      if( ProductContainer.productList.get(i).getSeller().getUserID() == UserContainer.userList.get(userID).getUserID() ) 
      {
        yourShopPanelInner.add( new yourShopProductPanel(i) );
      } 
    }
    
    ShopScroll = new JScrollPane(yourShopPanelInner,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
    ShopScroll.setPreferredSize(new Dimension(1290,470));
    
    ShopScroll.setLocation(10,30  );
    ShopScroll.setSize(1290,470 );
    
    yourShopPanel.add(yourShopLabel);
    yourShopPanel.add(ShopScroll);
  }
  
  
  
  
   //********************************************************************************COMMENTS
  //******************************************************************************** PANEL
  
    public void prepareCommentsPanel()
  {
    commentsPanel = new JPanel();
    commentsPanel.setLayout(null);
    commentsPanel.setPreferredSize(new Dimension(1300,220));
    commentsPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    JLabel commentsTag = new JLabel("Comments:");
     commentsTag.setLocation(10,5  );
    commentsTag.setSize(100,51 );
    
    JPanel comments = new JPanel();
    
    BoxLayout boxlayout = new BoxLayout(comments, BoxLayout.Y_AXIS);
    comments.setLayout(boxlayout);
    
    JScrollPane commentsScroll = new JScrollPane(comments,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
    comments.setPreferredSize(new Dimension(1250,170));
    
     ArrayList<String> tempUserComments = UserContainer.userList.get(userID).getUserComments();
//    System.out.println(tempUserComments.size());
    comments.setPreferredSize(new Dimension(1250,60 * tempUserComments.size() ));
    for(int i = 0; i < tempUserComments.size() ; i++)
    {
      JLabel temp =  addCommentLabel();
      temp.setText( "::  " + tempUserComments.get(i) );
      comments.add(   temp   );
      comments.add(   addCommentLabel()   );
      
    }

    commentsScroll.setLocation(25,45);
    commentsScroll.setSize(1250,170);
    
    
    
     commentsPanel.add(commentsTag);
     commentsPanel.add(commentsScroll);
  }
  
  
  public JLabel addCommentLabel()
  {
    JLabel tempCommentLabel = new JLabel(" ");
    tempCommentLabel.setPreferredSize(new Dimension(1200,50));
    tempCommentLabel.setFont( new Font("Verdana",Font.TRUETYPE_FONT,17));
   
    return tempCommentLabel;
  }
  
        
  class addProductListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JFrame frame = new addProductFrame(userID);
      frame.setSize(new Dimension(800,800));
      frame.setVisible(true);
    }
  }
  
    class signOutListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JFrame frame =  new Home();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 500));
      frame.setVisible(true);
      App.signOut();
    }
  }
 
  
  
  
  //********************************************************************************GUI
  //********************************************************************************
  public static void createAndShowGUI() {
    //Create and set up the window.
    new Profile(6);
    JFrame frame = new JFrame("deneme");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Set up the content pane.
    frame.add(mainProfilePanel);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
 

  public static void main(String[] args) 
  {  
    createAndShowGUI();
  }
  

  
}
