import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.util.*;

public class Inventory extends JPanel
{
  final int WIDTH = 1300;
  final int HEIGHT = 1000;
  
  static JPanel mainInvPanel;
  
  JPanel invHeadingPanel;
  JLabel userNameLabel;
  JLabel userBalanceLabel;
  
  static JPanel  shoppingCartPanel;
  static JLabel SCTagLabel;
  static JPanel cartItemsPanel;
  
  static JPanel yourItemsPanel;
  static JLabel YITagLabel;
  static JPanel itemsPanel;
  
  static String userName;
  static int userID;
 
  static int id;

//********************************************************************************CONSTRUCTOR
  //******************************************************************************** 
  public Inventory(int id) 
  { 
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    new Menu();
    this.id = id;
    prepareHeadingPanel();
    prepareCartPanel();
    prepareYourItemsPanel();
    
    prepareMainPanel();
    
    
    userName = UserContainer.userList.get(id).getUserName();
    userID = UserContainer.userList.get(id).getUserID();
    
    add(mainInvPanel);
  }
  
  
  //********************************************************************************HEADING
  //********************************************************************************PANEL 
  public void prepareHeadingPanel()
  {
    invHeadingPanel = new JPanel();
    String blank = "                                                                                                ";
    userNameLabel = new JLabel("User: " + UserContainer.userList.get(id).getUserName() + blank+ "Amount Due: "+
    UserContainer.userList.get(id).getBalance());
    userNameLabel.setFont( new Font("Verdana",Font.BOLD,15));
    userBalanceLabel = new JLabel();
    
    invHeadingPanel.setPreferredSize( new Dimension( 1200, 50 ) );
    invHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    invHeadingPanel.add(userNameLabel);
  }
  
  
  //********************************************************************************SHOPPING CART
  //********************************************************************************PANEL 
  public void prepareCartPanel()
  {
    shoppingCartPanel = new JPanel(new BorderLayout());
    
    shoppingCartPanel.setPreferredSize( new Dimension( 1200, 420 ) );
//    shoppingCartPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    SCTagLabel = new JLabel("Your Shopping Cart:");
    SCTagLabel.setFont( new Font("Verdana",Font.BOLD,15));
    
    cartItemsPanel = new JPanel();
    
    BoxLayout boxlayout = new BoxLayout(cartItemsPanel, BoxLayout.X_AXIS);
    cartItemsPanel.setLayout(boxlayout);
    
    updateItemScroll();
    
   
    
    
    
  }
  
  public static JScrollPane updateItemScroll()
  {
    shoppingCartPanel.removeAll();
    cartItemsPanel.removeAll();
    shoppingCartPanel.revalidate();
    JScrollPane itemsScroll = new JScrollPane(cartItemsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
    itemsScroll.setPreferredSize(new Dimension(1200,400));
    ArrayList<Integer> cart = UserContainer.userList.get(id).getShoppingCart();
    
    for(int ii = 0; ii < cart.size() ; ii++)
    {
      for(int i = 0; i < ProductContainer.productList.size(); i++)
      {
        if(ProductContainer.productList.get(i).getProductID() == cart.get(ii) )
        {
          if(ProductContainer.productList.get(i).getOwner() == null)
             {
          cartItemsPanel.add( new ShoppingCartProductPanel(i, userID),BorderLayout.LINE_END);
          }
        }    
      }
    }
    shoppingCartPanel.add(SCTagLabel,BorderLayout.NORTH);
    shoppingCartPanel.add(itemsScroll,BorderLayout.CENTER);
    
    shoppingCartPanel.repaint();
    return itemsScroll;
  }
  
  
  //********************************************************************************YOUR ITEM
  //********************************************************************************PANEL
  public void prepareYourItemsPanel()
  {
    yourItemsPanel = new JPanel(new BorderLayout());
    
    yourItemsPanel.setPreferredSize( new Dimension( 1200, 500 ) );
    yourItemsPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    YITagLabel = new JLabel("Your Items:");
    YITagLabel.setFont( new Font("Verdana",Font.BOLD,15));
    
    itemsPanel = new JPanel();
    
    BoxLayout boxlayout = new BoxLayout(itemsPanel, BoxLayout.X_AXIS);
    itemsPanel.setLayout(boxlayout);
   
    updateOwnerPanel();
  
    
    
  
  }
  
  public static void updateOwnerPanel()
  {
    yourItemsPanel.removeAll();
    itemsPanel.removeAll();
    yourItemsPanel.revalidate();
    
    JScrollPane itemsScroll = new JScrollPane(itemsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
    itemsScroll.setPreferredSize(new Dimension(1200,470));
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      if(!(ProductContainer.productList.get(i).getOwner() == null))
      {
        if(ProductContainer.productList.get(i).getOwner().getUserName().equals(userName))
        {
          
          itemsPanel.add( new OwnItemsPanel(i),BorderLayout.LINE_END);
          
        }   
      }
    }
    yourItemsPanel.add(YITagLabel,BorderLayout.NORTH);
    yourItemsPanel.add(itemsScroll, BorderLayout.CENTER);
    itemsScroll.repaint();
  }

  
  //********************************************************************************MAIN
  //********************************************************************************PANEL
  public void prepareMainPanel()
  {
    mainInvPanel = new JPanel();
    
    BoxLayout mainInvBoxlayout = new BoxLayout(mainInvPanel, BoxLayout.Y_AXIS);
    mainInvPanel.setLayout(mainInvBoxlayout);
    
    mainInvPanel.add(invHeadingPanel);
    mainInvPanel.add(shoppingCartPanel);
    mainInvPanel.add(yourItemsPanel);
    
  }
  
 
  
   public static void createAndShowGUI() {
    //Create and set up the window.
    new Inventory(id);
    JFrame frame = new JFrame("deneme");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Set up the content pane.
    frame.add(mainInvPanel);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
 

  public static void main(String[] args) 
  {  
    createAndShowGUI();
  }
  

}
