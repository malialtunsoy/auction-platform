import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.util.*;

/**
 * Add Product Frame call from Profile
 */
public class addProductFrame extends JFrame
{

  JFrame mainItemFrame;
  
  int userID = 0;
  
  JPanel mainAddPanel;
  
  JLabel heading;
  JLabel productNameTag;
  JLabel typeTag;
  JLabel startingPriceTag;
  JLabel buyItNowPriceTag;
  JLabel dateTag;
  JLabel informationTag;
  JLabel imagesTag;
  
  JTextArea productName;
  JTextArea type;
  JTextArea startingPrice;
  JTextArea buyItNowPrice;
  JTextArea date;
  JTextArea information;
  JTextArea images;
  
  JPanel imagesDisplay;
  
  JButton importImage;
  ArrayList<String> productImages = new ArrayList<String>();
  
  JButton addButton;
  JButton cancelButton;
  
  ActionListener addListener;
  ActionListener cancelListener;
  ActionListener imageListener;
  
  
  
 //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  public addProductFrame( int userID )
  { 
   this.userID = userID ;
    
//   new Menu();
    
   prepareMainPanel();
    
   add(mainAddPanel);
  }
  

     //******************************************************************************** MAIN
  //********************************************************************************   PANEL
     public void prepareMainPanel( )
  {
       mainAddPanel = new JPanel();
       mainAddPanel.setLayout(null);
       mainAddPanel.setPreferredSize(new Dimension(800, 550));
       
       heading = new JLabel("Add Product:");  //              SET TAGS
       heading.setFont( new Font("Verdana",Font.BOLD,20));
       productNameTag = new JLabel("Product Name:");
       typeTag = new JLabel("Product Type:");
       startingPriceTag = new JLabel("Starting Price:");
       buyItNowPriceTag = new JLabel("Buy It Now Price:");
       dateTag = new JLabel("Auction Time:");
       informationTag = new JLabel("Information:");
       imagesTag = new JLabel("Images:");
       
       productName = new JTextArea();   //                 SET JTextAreas
       type =  new JTextArea();
       startingPrice = new JTextArea();
       buyItNowPrice = new JTextArea();
       date = new JTextArea();
       information = new JTextArea();
       information.setLineWrap(true);
       JScrollPane infoScrollPane = new JScrollPane(information); 
       images = new JTextArea();
       
       imagesDisplay = new JPanel();//                     imageDisplay Menu
       imagesDisplay.setPreferredSize(new Dimension(400, 200));

       
       productName.setBorder(BorderFactory.createLineBorder(Color.black, 1)); //set a Border
       type.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       startingPrice.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       buyItNowPrice.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       date.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       images.setBorder(BorderFactory.createLineBorder(Color.black, 1));
       
    

       
       addButton = new JButton("Add Product");   //set BUttons
       cancelButton = new JButton("Cancel");
       importImage = new JButton("Import Image");;
    
      //-------------------------------------------------------------------------------------- TAGS
       //--------------------------------------------------------------------------------------
       
       
       int border = 20;
       int yBorder = 20;
       
       heading.setLocation(border, 10);  // SET LOCATIONS
       heading.setSize(200,25);
       
        productNameTag.setLocation(border,yBorder + 40);
       productNameTag.setSize(100,15);
       
       typeTag.setLocation(border,yBorder + 70);
       typeTag.setSize(100,15);
       
        startingPriceTag.setLocation(border,yBorder + 100);
       startingPriceTag.setSize(100,15);
       
        buyItNowPriceTag.setLocation(border,yBorder + 130);
       buyItNowPriceTag.setSize(100,15);
       
        dateTag.setLocation(border,yBorder + 160);
       dateTag.setSize(100,15);
       
       informationTag.setLocation(border,yBorder + 190);
       informationTag.setSize(1000,15);
       
       imagesTag.setLocation(border,yBorder + 290);
       imagesTag.setSize(100,15);
       
       
       
       
    
    //-------------------------------------------------------------------------------------- TEXT
       //--------------------------------------------------------------------------------------AREAS
    
       int textBorder = 120;
       int textYBorder = 20;
       
       
       productName.setLocation(textBorder + border,yBorder + 40);  //SET LOCATIONS
       productName.setSize(100,20);
       
        type.setLocation(textBorder + border,yBorder + 70);
       type.setSize(100,20);
       
       startingPrice.setLocation(textBorder + border,yBorder + 100);
       startingPrice.setSize(100,20);
       
        buyItNowPrice.setLocation(textBorder + border,yBorder + 130);
       buyItNowPrice.setSize(100,20);
       
       date.setLocation(textBorder + border,yBorder + 160);
       date.setSize(100,20);
       
       infoScrollPane.setLocation(textBorder + border,yBorder + 190);
       infoScrollPane.setSize(500,80);
       
        images.setLocation(textBorder + border,yBorder + 290);
       images.setSize(100,20);
    
       
       imagesDisplay.setLocation(textBorder + border,yBorder + 320);
       imagesDisplay.setSize(400,220);
    //-------------------------------------------------------------------------------------- BUTTONS
    //--------------------------------------------------------------------------------------
       
       importImage.setLocation(textBorder + border + 110,yBorder + 290);  //SET LOCATIONS
       importImage.setSize(130,20);
       
       
       addButton.setLocation(textBorder + border + 300, yBorder + 630);
       addButton.setSize(140,20);
       
       cancelButton.setLocation(textBorder + border + 450,yBorder + 630);
       cancelButton.setSize(100,20);
       
     //-------------------------------------------------------------------------------------- ACTION
    //--------------------------------------------------------------------------------------LISTENERS
       addListener = new addListener();     //ADD LOCATIONS
       addButton.addActionListener(addListener);
       
       cancelListener = new cancelListener();
       cancelButton.addActionListener(cancelListener);
       
       imageListener = new imageListener();
       importImage.addActionListener(imageListener);
       
       
         
    //--------------------------------------------------------------------------------------ADD
    //--------------------------------------------------------------------------------------TO PANEL
    
    
   
    mainAddPanel.add(heading);  //         ADD THINGS TO THE PANEL
    mainAddPanel.add(productNameTag);
    mainAddPanel.add(typeTag);
    mainAddPanel.add(startingPriceTag);
    mainAddPanel.add(buyItNowPriceTag);
    mainAddPanel.add(dateTag);
    mainAddPanel.add(informationTag);
    mainAddPanel.add(imagesTag);
    
    
    mainAddPanel.add(productName);
    mainAddPanel.add(type);
    mainAddPanel.add(startingPrice);
    mainAddPanel.add(buyItNowPrice);
    mainAddPanel.add(date);
    mainAddPanel.add(infoScrollPane);
    mainAddPanel.add(images);
     mainAddPanel.add(imagesDisplay);
    
                                
    mainAddPanel.add(importImage);
    mainAddPanel.add(addButton);
    mainAddPanel.add(cancelButton);
                                
     
  }
     public void updateImageDisplay ( JPanel imageGallery ) //UPDATE IMAGE DISPLAY PANEL
    {
      imagesDisplay.removeAll();
      imagesDisplay.add(imageGallery);
      imagesDisplay.revalidate();
      imagesDisplay.repaint();
      mainAddPanel.revalidate();
      mainAddPanel.repaint();
    }
   //******************************************************************************** GUI
  //********************************************************************************   
  
  public static void main(String[] args) //FOR TEST
  { 
      JFrame frame = new addProductFrame(1);
      frame.setSize(new Dimension(800,800));
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
   
    class addListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
         
         // TAKE CONTENTS
        String nameX = productName.getText();
        
        String typeX = type.getText();;
        
        String infoX = information.getText();
          
        double startingPriceX = Double.parseDouble( startingPrice.getText() );
        
        double buyItNowPriceX = Double.parseDouble(buyItNowPrice.getText());
       
        double currentPriceX = Double.parseDouble( startingPrice.getText() );

        String dateX = date.getText();
        
        User seller = UserContainer.userList.get(userID);
        
        boolean solded = false;
        User owner = null;
        int id = Menu.findBiggestProductID() ;
        ArrayList<String> tempImages = productImages;
        
        // ADD PRODUCT
        ProductContainer.productList.add(new Product( nameX, infoX, typeX, startingPriceX, buyItNowPriceX, currentPriceX, seller, solded, owner, id, tempImages, dateX)  );
        
        //UPDATE MENU
        Menu.updateImageList();
        Menu.updateProductList();
        
        //UPDATE SHOP PANEL
        Profile.yourShopPanel.removeAll();
        Profile.updateShopPanel();
         
        //REPAINT
        Profile.yourShopPanel.revalidate();
        Profile.yourShopPanel.repaint();

        setVisible(false);
        dispose();
      }
    }
   
    

    
    
    
      class imageListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      productImages.add( images.getText() );
    
      
      JPanel images = new ImageGalleryPanel( productImages );
      updateImageDisplay( images );
    }
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public void createAddListener()
  {
    
    addListener = new addListener();
    
  }
    public void createCancelListener()
  {
    cancelListener = new cancelListener();
  }
    
}
