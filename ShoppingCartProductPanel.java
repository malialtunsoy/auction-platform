
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Dimension;


import java.awt.Color;
import java.awt.Font;




import java.awt.GridBagConstraints;

/**
 * Auto Generated Java Class.
 */
public class ShoppingCartProductPanel extends JPanel {
  
  final int WIDTH = 300;
  final int HEIGHT = 400;
  
  static JPanel mainCartPanel;
  
  GridBagConstraints c = new GridBagConstraints();
  JLabel nameLabel = new JLabel();
  JLabel imageLabel;
  StarRate stars;
//  JLabel priceTagLabel = new JLabel();
//  JLabel priceLabel = new JLabel();
  JLabel dateTagLabel = new JLabel();
  //date
  JTextArea outbid;
  JPanel AuctionPanel;
   JLabel outbidTag;
   JLabel buyOutTag;
  JLabel lastOfferTag;
  JLabel lastOffer;
  JButton outbidSubmit ;
  
  int productID;
  int userID;
  
//********************************************************************************CONSTRUCTOR
  //******************************************************************************** 
  public ShoppingCartProductPanel(int productID, int userID) 
  { 
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.productID = productID;
    this.userID = userID;
    new Menu();
    
    createPanel();
    
    add(mainCartPanel);
  }
  
  //******************************************************************************** MAIN 
  //******************************************************************************** PANEL
  public void createPanel()
  { 
    mainCartPanel = new JPanel();
    mainCartPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//    mainCartPanel.setLayout(null);
    mainCartPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    BoxLayout boxlayout = new BoxLayout(mainCartPanel, BoxLayout.Y_AXIS);
    mainCartPanel.setLayout(boxlayout);
    
    createNameLabel();
//    createPriceLabel();
//    setBorder(BorderFactory.createLineBorder(Color.black, 1));
    createImagePanel();
    createDateLabel();
    createStarPanel();
    createAuctionPanel();
    
    mainCartPanel.add(nameLabel);
    mainCartPanel.add(imageLabel);
    mainCartPanel.add(stars);
    mainCartPanel.add(dateTagLabel);
    mainCartPanel.add(AuctionPanel);
    
  }
  
  //******************************************************************************** CREATE
  //******************************************************************************** LABELS
   public void createNameLabel()
  {
    nameLabel.setText( "" + ProductContainer.productList.get(productID).getName() );
    nameLabel.setFont( new Font("Verdana",Font.BOLD,20));
    
  }
   public void createImagePanel()
  {
    BufferedImage image = null;
    try{ 
    image = ImageIO.read(new File(ProductContainer.productList.get(productID).getProductImages().get(0)));
    }catch(IOException ex){System.out.println("failed");}
    imageLabel = new JLabel( new ImageIcon(image));
    imageLabel.setPreferredSize(new Dimension(250,180));
  
    imageLabel.setIcon(new ImageIcon(image.getScaledInstance(200, 180, Image.SCALE_SMOOTH)));   
  }
    public void createStarPanel()
  {
    stars = new StarRate(ProductContainer.productList.get(productID).getSeller().getUserRatingDouble());
  }
//  public void createPriceLabel()
//  {
//    priceTagLabel.setText("Price: ");
//    priceLabel.setText("$" + ProductContainer.productList.get(productID).getCurrentPrice() );
//  }
   public void createDateLabel()
  {
    dateTagLabel.setText("Date:    " + ProductContainer.productList.get(productID).getDate());
 }
   
   
  public void createAuctionPanel()
  {
    AuctionPanel = new JPanel();
    AuctionPanel.setLayout(null);
    
    lastOfferTag = new JLabel("Last Offer : ");
    lastOfferTag.setLocation( 20,14 );
    lastOfferTag.setSize( 100,15 );
    
    buyOutTag = new JLabel("Buy it now price :                            " +"$"+ProductContainer.productList.get(productID).getBuyItNowPrice() );
    buyOutTag.setLocation( 20,28 );
    buyOutTag.setSize( 300,15 );
    
    updatedCurrentPrice();
    
      
    outbidTag =  new JLabel("Outbid        : ");
    outbidTag.setLocation( 20,35 );
    outbidTag.setSize( 100,51 );
    
    
    outbid = new JTextArea();
     outbid.setLocation( 100,50 );
     outbid.setSize( 80, 20 );
     outbid.setBorder(BorderFactory.createLineBorder(Color.black, 1));
   

    
    outbidSubmit = new JButton("Submit");
    outbidSubmit.setLocation( 180,50 );
     outbidSubmit.setSize( 80, 20 );
     ActionListener submitListener = new submitListener();
     outbidSubmit.addActionListener(submitListener);
    
    AuctionPanel.setPreferredSize(new Dimension(250,70));
    AuctionPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
    AuctionPanel.add(lastOfferTag);
    
    AuctionPanel.add(outbidTag);
    AuctionPanel.add(outbid);
    AuctionPanel.add(outbidSubmit);
    AuctionPanel.add(buyOutTag);
  }
  
  
  public void updatedCurrentPrice()
  {
    lastOffer = new JLabel();
    lastOffer.setText("$" + ProductContainer.productList.get(productID).getCurrentPrice());
//    System.out.println(ProductContainer.productList.get(productID).getCurrentPrice());
    lastOffer.setLocation(200, 14);
    lastOffer.setSize(100, 15);
    AuctionPanel.add(lastOffer);
  }
  
 
  //******************************************************************************** GUI
  //********************************************************************************   
  public static void main(String[] args) 
  { 
      JFrame frame = new JFrame();
      frame.setSize(new Dimension(300,400));
      new ShoppingCartProductPanel(0,1);
      frame.add(mainCartPanel);
      frame.setVisible(true);
  }
  
  class submitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      
      int id = ProductContainer.productList.get(productID).getProductID();
      if(!(outbid.getText().equals("")))
      { 
         for(int i = 0; i < ProductContainer.productList.size() ; i++)
            {
               if(id == ProductContainer.productList.get(i).getProductID())
               {
                  Double currentPrice = Double.parseDouble(outbid.getText());
                  if( ProductContainer.productList.get(i).getCurrentPrice() < currentPrice )
                  {
                     if( currentPrice >= ProductContainer.productList.get(i).getBuyItNowPrice() )
                     {
                       
                       for( int ii = 0; ii < UserContainer.userList.size() ; ii++)
                       {
                         if(UserContainer.userList.get(ii).getUserID() == userID)
                         {
                           UserContainer.userList.get(ii).removeCart( ProductContainer.productList.get(i).getProductID() );
                           ProductContainer.productList.get(i).setSolded(true);
                           ProductContainer.productList.get(i).setOwner(UserContainer.userList.get(ii));
                           Menu.updateProductList();
                           Menu.updateCartList();
                           Menu.updateUserList();
                           Inventory.updateItemScroll();
                           Inventory.updateOwnerPanel();
                         }
                       }
                       
                        System.out.println("bu item artik senin");
                     }
                     else
                        ProductContainer.productList.get(i).setCurrentPrice(currentPrice);
                  }
            try{ 
            FileWriter.productWriter();
           }catch(FileNotFoundException ex){System.out.println("failed");}
           ProductContainer.update();
            

          }
        }
      }
      
      AuctionPanel.remove(lastOffer);
//      AuctionPanel.add(lastOffer);
//      createAuctionPanel();
      updatedCurrentPrice();
      AuctionPanel.revalidate();
      AuctionPanel.repaint();
      
      
         
      lastOffer.revalidate();
      lastOffer.repaint();

      }
   }
}
