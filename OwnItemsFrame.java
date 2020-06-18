
import java.awt.BorderLayout;

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
public class OwnItemsFrame extends JFrame
{
  final int WIDTH = 300;
  final int HEIGHT = 450;
  
  JFrame mainItemFrame;
  
  int productID;
  
  JPanel mainItemsPanel;
  GridBagConstraints c;
  
  JLabel nameLabel;
  
  JPanel tags;
  JLabel infoTag;
  JLabel dateTag;
  JLabel pricePaidTag;
  JLabel imagesTag;
  
  JPanel contents;
  JTextArea infoLabel;
  JLabel dateLabel;
  JLabel pricePaidLabel;
  JPanel images;
  
  JPanel commentRate;
  JLabel commentTag;
  JTextArea addComment;
  JLabel rateTag;
  //rate 
  static RateSellerPanel rateSellerPanel;
  
  JPanel buttonPanel;
  JButton submitButton;
  JButton cancelButton;
  
  ActionListener submitListener;
  ActionListener cancelListener;
  
 //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  public OwnItemsFrame( int productID )
  { 
   this.productID = productID;
    
//   new Menu();
    prepareMainItemPanel();
    prepareTags();
    prepareContents();
    prepareButtons();
    prepareCommentRate();
    
   
    
    add(mainItemsPanel);
  }
  
   //******************************************************************************** TAGS
  //********************************************************************************  PANEL
  public void prepareTags()
  {
  
   infoTag = new JLabel("Information:");
   dateTag = new JLabel("Auction Time:");
   pricePaidTag = new JLabel("Price Paid:");
   imagesTag = new JLabel("Images:");
  
   infoTag.setLocation( 20,50 );
   infoTag.setSize( 100, 20 );
   
   dateTag.setLocation( 20,140 );
   dateTag.setSize( 100, 20 );
   
   pricePaidTag.setLocation( 20,170 );
   pricePaidTag.setSize( 100, 20 );
   
   imagesTag.setLocation( 20,200 );
   imagesTag.setSize( 100, 20 );
   
   
   
    mainItemsPanel.add(infoTag);
    mainItemsPanel.add(dateTag);
    mainItemsPanel.add(pricePaidTag);
    mainItemsPanel.add(imagesTag);
  
  }
  
   //******************************************************************************** CONTENTS
  //********************************************************************************  PANEL
   public void prepareContents()
  {
   
     
   infoLabel = new JTextArea();
   dateLabel = new JLabel();
   pricePaidLabel = new JLabel();
   images = new JPanel();
   
   
    preparePricePaidLabel();
    
    prepareDateLabel();
    prepareInfoLabel();
    prepareImagePanel();
    
    infoLabel.setLineWrap(true);
    infoLabel.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(infoLabel); 
    scrollPane.setLocation( 200 , 50 );
    scrollPane.setSize( 400, 70 );
   
   dateLabel.setLocation( 200,140 );
   dateLabel.setSize( 100, 20 );
   
   pricePaidLabel.setLocation( 200,170 );
   pricePaidLabel.setSize( 100, 20 );
   
   images.setLocation( 200,200 );
   images.setSize( 400, 220 );
    
     mainItemsPanel.add(scrollPane);
    mainItemsPanel.add(dateLabel);
    mainItemsPanel.add(pricePaidLabel);
    mainItemsPanel.add(images);
   
  }
   
    public void preparePricePaidLabel()
   {
    pricePaidLabel.setText("$" + ProductContainer.productList.get(productID).getCurrentPrice() );
   }
     
     public void prepareDateLabel()
   {
     dateLabel.setText(ProductContainer.productList.get(productID).getDate() );
   }
     public void prepareInfoLabel()
   {
    infoLabel.setText(ProductContainer.productList.get(productID).getInformation());

   }
     public void prepareImagePanel()
   {
     images = new ImageGalleryPanel(productID);   
   }
   

     




//******************************************************************************** COMMENT RATE
  //******************************************************************************** PANEL
    public void prepareCommentRate()
  {
   
   commentTag = new JLabel("Comment Seller");
   addComment = new JTextArea(2, 40);
   addComment.setLineWrap(true);
   JScrollPane scrollPane = new JScrollPane(addComment); 

   rateTag = new JLabel("Rate Seller:");
   rateSellerPanel = new RateSellerPanel(0);
   rateSellerPanel.setPreferredSize(new Dimension(160, 50));
   
     commentTag.setLocation( 20,440 );
   commentTag.setSize( 100, 20 );
   
   scrollPane.setLocation( 20,470 );
   scrollPane.setSize( 580, 50 );
   
   rateTag.setLocation( 20,530 );
   rateTag.setSize( 200, 20 );
   
   rateSellerPanel.setLocation( 10,550 );
   rateSellerPanel.setSize( 200, 40 );
   

    mainItemsPanel.add(commentTag);
    mainItemsPanel.add(scrollPane);
    mainItemsPanel.add(rateTag);
    mainItemsPanel.add(rateSellerPanel);

       
  }
    
    //******************************************************************************** BUTTON
  //******************************************************************************** PANEL
    public void prepareButtons()
  {
      
   
   submitButton = new JButton("Submit");
   cancelButton = new JButton("Cancel");
   
   createSubmitListener();
   createCancelListener();
   
   submitButton.addActionListener(submitListener);
   cancelButton.addActionListener(cancelListener);
   
   submitButton.setLocation( 380,565 );
   submitButton.setSize( 100, 25);
   
   cancelButton.setLocation( 500,565 );
   cancelButton.setSize( 100, 25 );
   
   mainItemsPanel.add(submitButton);
   mainItemsPanel.add(cancelButton);
 
  }

     //******************************************************************************** MAIN
  //********************************************************************************   PANEL
     public void prepareMainItemPanel( )
  {
    mainItemsPanel = new JPanel();
    mainItemsPanel.setLayout(null);
    mainItemsPanel.setPreferredSize(new Dimension(630, 650));
    
    nameLabel = new JLabel(ProductContainer.productList.get(productID).getName());
    nameLabel.setFont( new Font("Verdana",Font.BOLD,20));
    
    JLabel line = new JLabel();
    line.setLocation( 10,43 );
     line.setSize( 600 , 1 );
     line.setBorder(BorderFactory.createLineBorder(Color.black, 1));
     
      JLabel line2 = new JLabel();
    line2.setLocation( 10,435 );
     line2.setSize( 600, 1 );
     line2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    
     nameLabel.setLocation( 20,15 );
     nameLabel.setSize( 100, 25 );
     
    mainItemsPanel.add(nameLabel);
     mainItemsPanel.add(line);
      mainItemsPanel.add(line2);
    
    
  }

   //******************************************************************************** GUI
  //********************************************************************************   
  
  public static void main(String[] args)
  { 
      JFrame frame = new OwnItemsFrame(1);
      frame.setSize(new Dimension(630, 650));
      frame.setVisible(true);
  }

   //******************************************************************************* ACTION
  //******************************************************************************** LISTENERS
    class cancelListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
    setVisible(false);
    dispose();
    }
  }
   
    class submitListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        
        int id = ProductContainer.productList.get(productID).getSeller().getUserID();
        if(!(addComment.getText().equals("")))
        {
          
          
          for(int i = 0; i < UserContainer.userList.size() ; i++)
          {
            if(id == UserContainer.userList.get(i).getUserID())
            {
              UserContainer.userList.get(i).addComment(addComment.getText());
              System.out.println("rated comments");
            }
          }   
          Menu.updateCommentList();   
        }
        
        Double rating;
        String aa = "" +  RateSellerPanel.getRate();
        rating = Double.parseDouble(aa);
         for(int i = 0; i < UserContainer.userList.size() ; i++)
          {
            if(id == UserContainer.userList.get(i).getUserID())
            {
              UserContainer.userList.get(i).addRating( rating );
              System.out.println("rated star");
            }
          }
       
        Menu.updateRatingList();
        Inventory.yourItemsPanel.revalidate();
        Inventory.yourItemsPanel.repaint();
        setVisible(false);
        dispose();
      }
    }
   
     public void createSubmitListener()
  {
    
    submitListener = new submitListener();
    
  }
    public void createCancelListener()
  {
    cancelListener = new cancelListener();
  }
    
}
