import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Auto Generated Java Class.
 */
public class ProductInfoPop extends JFrame implements ActionListener {
  
   JFrame mainFrame;
  
  static JPanel mainPanel;
 
//   JPanel headingPanel;
   JLabel productNameLabel;
   StarRate stars;
  
//   JPanel contents;
   JLabel nameLabel;
   JLabel ratingLabel;
   JLabel priceLabel;
   JLabel BINLabel;
   JLabel dateLabel;
   JTextArea infoLabel;
   JLabel imageLabel;
   JPanel images;
   JLabel sellerLabel;
  
//   JPanel tagPanel;
   JLabel priceTagLabel;
   JLabel BINTagLabel;
   JLabel dateTagLabel;
   JLabel infoTagLabel;
   JLabel imageTagLabel;
   JLabel sellerTagLabel;
   
//   JPanel buttonPanel; 
   JButton addSCButton;
   JButton cancelButton;
   ActionListener cancelListener ;
   ActionListener addToCartListener;
 
   int productID;
   int userID;

  
 //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  public ProductInfoPop( int productID, int userID)
  {
    super("Product");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.productID = productID;
    this.userID = userID;
    JButton button = new JButton("Close window");
    button.addActionListener(this);
    
    new Menu();
    Container contentPane = getContentPane();

    
    createMainPanel();

    add( mainPanel);
  }
  

  //******************************************************************************** MAIN
  //******************************************************************************** PANEL
    public void createMainPanel()
  {
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    mainPanel.setPreferredSize(new Dimension(600, 550));

    
    createTagPanel();
    createContentPanel();
    createHeadingPanel();
    createButtonPanel();
    
  
    
  }
  
   //******************************************************************************** HEADING
  //******************************************************************************** PANEL
     public void createHeadingPanel()
    {
      productNameLabel = new JLabel(ProductContainer.productList.get(productID).getName());
      productNameLabel.setLocation( 30,20 );
      productNameLabel.setSize( 500,20 );
      productNameLabel.setFont( new Font("Verdana",Font.BOLD,20));
      
      stars = new StarRate(ProductContainer.productList.get(productID).getSeller().getUserRatingDouble());
      stars.setLocation( 450,20 );
      stars.setSize( 100,20 );
      
      
      productNameLabel.setText("" + ProductContainer.productList.get(productID).getName() );
     
      mainPanel.add(productNameLabel);
      mainPanel.add(stars);
                                    
 
    }
    
     
    
      
    
    
  
     //********************************************************************************TAG
  //******************************************************************************** PANEL
    public void createTagPanel()
  {
      
    final int BORDER = 30;  
    priceTagLabel = new JLabel("Price: ");
    priceTagLabel.setLocation( BORDER,80 );
    priceTagLabel.setSize( 100,20 );
      
    BINTagLabel = new JLabel("Buy It Now Price: ");
    BINTagLabel.setLocation( BORDER,110 );
    BINTagLabel.setSize( 100,20 );
      
    dateTagLabel = new JLabel("Auction Time: ");
    dateTagLabel.setLocation( BORDER,140 );
    dateTagLabel.setSize( 100,20 );
      
    infoTagLabel = new JLabel("Information: ");
    infoTagLabel.setLocation( BORDER,170 );
    infoTagLabel.setSize( 100,20 );
      
    imageTagLabel = new JLabel("Images: ");
    imageTagLabel.setLocation( BORDER,250 );
    imageTagLabel.setSize( 100,20 );
      
    sellerTagLabel = new JLabel("Seller: ");
    sellerTagLabel.setLocation( BORDER,470 );
    sellerTagLabel.setSize( 100,20 );
    
    
    
    
    mainPanel.add(priceTagLabel);
    mainPanel.add(BINTagLabel);
    mainPanel.add(dateTagLabel);
    mainPanel.add(infoTagLabel);
    mainPanel.add(imageTagLabel);
    mainPanel.add(sellerTagLabel);
    
    
  }
  
  
   //********************************************************************************CONTENT
  //******************************************************************************** PANEL
  
  
  
     public void createContentPanel()
  {
    priceLabel = new JLabel();
    BINLabel = new JLabel();
    dateLabel = new JLabel();
    infoLabel = new JTextArea();
    imageLabel = new JLabel();
    sellerLabel = new JLabel();
    
    preparePriceLabel();
    prepareBINLabel();
    prepareDateLabel();
    prepareInfoLabel();
    prepareImageLabel();
    prepareSellerLabel();
    
   
      final int BORDER = 30;  
    priceLabel.setLocation( BORDER + 120 ,80);
    priceLabel.setSize( 100,20 );
    
      BINLabel.setLocation( BORDER + 120,110 );
    BINLabel.setSize( 100,20 );
    
      dateLabel.setLocation( BORDER + 120,140 );
    dateLabel.setSize( 100,20 );
    
    infoLabel.setLineWrap(true);
    infoLabel.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(infoLabel); 
    
      scrollPane.setLocation( BORDER + 120,170 );
    scrollPane.setSize( 400,60 );
      
    images.setLocation( BORDER + 120,245 );
    images.setSize( 400,220);
    
    sellerLabel.setLocation( BORDER + 120,470 );
    sellerLabel.setSize( 100,20 );
    
    
    
   
    
    
    
    
    
    mainPanel.add(priceLabel);
    mainPanel.add(BINLabel);
    mainPanel.add(dateLabel);
    mainPanel.add(scrollPane);
    mainPanel.add(images);
    mainPanel.add(sellerLabel);
    
    
    
   
  }
   
      public void preparePriceLabel()
   {
    priceLabel.setText("$" + ProductContainer.productList.get(productID).getCurrentPrice() );
   }
     public void prepareBINLabel()
   {
     BINLabel.setText("$" + ProductContainer.productList.get(productID).getBuyItNowPrice() );
   }
     public void prepareDateLabel()
   {
     dateLabel.setText(ProductContainer.productList.get(productID).getDate());
   }
     public void prepareInfoLabel()
   {
    
//    infoLabel.setPreferredSize(new Dimension(50,75));
    
    infoLabel.setText( ProductContainer.productList.get(productID).getInformation()  );
    
//    infoLabel.setOpaque(true);
//    Color renk = new Color(210,210,210);
//    infoLabel.setBackground(renk);
   }
     public void prepareImageLabel()
   {
       images = new ImageGalleryPanel(productID);   
       
   }
     public void  prepareSellerLabel()
   {
     sellerLabel.setText("" + ProductContainer.productList.get(productID).getSeller().getUserName() );
   }
   
   
   //******************************************************************************** BUTTON
  //******************************************************************************** PANEL  
  
     public void createButtonPanel()
   {
     addSCButton = new JButton("Add to Shopping Cart");
     cancelButton = new JButton("Close");;
     
      addSCButton.setLocation( 250 ,500 );
    addSCButton.setSize( 180,20 );
    
    
      cancelButton.setLocation( 440 ,500 );
    cancelButton.setSize( 100,20 );
     
    
     createAddToCartListener();
      createCancelListener();
     
     addSCButton.addActionListener(addToCartListener);
     cancelButton.addActionListener(cancelListener);
    
    
     
     
     mainPanel.add(addSCButton);
     mainPanel.add(cancelButton);
     
   
   }
   
    public void createAddToCartListener()
  {
    addToCartListener = new addToCartListener();
  }
    public void createCancelListener()
  {
    cancelListener = new cancelListener();
  }
   
   
  
 
  
  
   //******************************************************************************** OTHER
  //******************************************************************************** CODES
  
  
  
  //Make the button do the same thing as the default close operation
  //(DISPOSE_ON_CLOSE).
  public void actionPerformed(ActionEvent e) {
    setVisible(false);
    dispose();
  }
  
   class cancelListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
    setVisible(false);
    dispose();
    }
  }
   
   class addToCartListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      System.out.println(userID);  
      UserContainer.userList.get(userID).addCart(ProductContainer.productList.get(productID).getProductID());
      Menu.updateUserList();
      Menu.updateCartList();
      setVisible(false);
      dispose();
      
    }
   }
  
  
  
  
  public static void createAndShowGUI() {

    
    JFrame frame = new ProductInfoPop( 0 , 0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(mainPanel);

    frame.pack();
    frame.setVisible(true);
  }
 

  public static void main(String[] args) 
  {  
    createAndShowGUI();
  }
  
  
  
   
  
}
