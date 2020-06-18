
import java.awt.BorderLayout;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;



import javax.swing.*;

import java.awt.Dimension;


import java.awt.Color;


import java.util.*; 


/**
 * Auto Generated Java Class.
 */
public class ImageGalleryPanel extends JPanel {
  
  
  static JPanel mainGalleryPanel;
  JPanel inner;
  int productID = 0;

   //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  
  public ImageGalleryPanel( int id )
  { 
    super();
//    new Menu(); //sonra sil
    this.productID = id;
    createGallery();
    add(mainGalleryPanel);
    
  }
  
  public ImageGalleryPanel( ArrayList<String> a )
  { 
    super();

    
    createGallery(a);
    add(mainGalleryPanel);
    
  }
  
   //******************************************************************************** GUI
  //******************************************************************************** 
   public static void main(String[] args) 
  { 
      JFrame frame = new JFrame();
      frame.setSize(new Dimension(1250,500));
      new ImageGalleryPanel(1);
      frame.add(mainGalleryPanel);
      frame.setVisible(true);
  }
  
   //******************************************************************************** GALLERY
  //******************************************************************************** 
  public void createGallery()
  {
    inner = new JPanel();
    mainGalleryPanel = new JPanel();
    BoxLayout boxlayout = new BoxLayout(inner, BoxLayout.X_AXIS);
    inner.setLayout(boxlayout);

    

    JScrollPane imageScroll = new JScrollPane(inner,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
    imageScroll.setPreferredSize(new Dimension(400,200));
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
     
      
     int wantedId = ProductContainer.productList.get(productID).getProductID();
     
      System.out.println("i: " + i + "getProductId: " + ProductContainer.productList.get(i).getProductID()+ " productID: " + wantedId);
     
      if(ProductContainer.productList.get(i).getProductID() == wantedId  ) //****************
      {
          JLabel[] images = createImagePanel(i);
          
          for( int ii = 0; ii < images.length ; ii++)
          {
            inner.add( images[ii] ,BorderLayout.LINE_END);
          }          
      }    
    } 
    mainGalleryPanel.add(imageScroll, BorderLayout.CENTER);
  }
  

   //******************************************************************************** TAKE
  //******************************************************************************** IMAGES
  public  JLabel[] createImagePanel(int id)
  {
    
//        System.out.println( "aa" );
    ArrayList<String> imagesList = ProductContainer.productList.get(id).getProductImages();
    
//    System.out.println( "aa" + imagesList + ProductContainer.productList.get(id) );
    
    BufferedImage[] images = new BufferedImage[imagesList.size()];
    JLabel[] imageLabels = new JLabel[imagesList.size()];
    
    for(int ii = 0; ii < imagesList.size() ; ii++)
    { 
      try{ 
      images[ii] = ImageIO.read(new File( imagesList.get(ii) ));
       
      }catch(IOException ex){System.out.println("failed");}
      
      imageLabels[ii] = new JLabel( new ImageIcon(images[ii]));
      imageLabels[ii].setPreferredSize(new Dimension(200, 180));
      imageLabels[ii].setBorder(BorderFactory.createLineBorder(Color.black, 3));
      imageLabels[ii].setIcon(new ImageIcon( images[ii].getScaledInstance(200, 180, Image.SCALE_SMOOTH)));
    }
    return imageLabels;   
  }
   
  
  
  
  
  
  
  
  
  
  
  
   public void createGallery( ArrayList<String> a)
  {
    inner = new JPanel();
    mainGalleryPanel = new JPanel();
    BoxLayout boxlayout = new BoxLayout(inner, BoxLayout.X_AXIS);
    inner.setLayout(boxlayout);
    

    

    JScrollPane imageScroll = new JScrollPane(inner,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
    imageScroll.setPreferredSize(new Dimension(400,200));
    
   
          JLabel[] images = createImagePanel(a);
          
          for( int ii = 0; ii < images.length ; ii++)
          {
            inner.add( images[ii] ,BorderLayout.LINE_END);
          }          
     
    mainGalleryPanel.add(imageScroll, BorderLayout.CENTER);
  }
  
  
  
   public  JLabel[] createImagePanel(ArrayList<String> a)
  {
    
        
    ArrayList<String> imagesList = a;
    
    
    
    BufferedImage[] images = new BufferedImage[imagesList.size()];
    JLabel[] imageLabels = new JLabel[imagesList.size()];
    
    for(int ii = 0; ii < imagesList.size() ; ii++)
    { 
      try{ 
      images[ii] = ImageIO.read(new File( imagesList.get(ii) ));
       
      }catch(IOException ex){System.out.println("failed");}
      
      imageLabels[ii] = new JLabel( new ImageIcon(images[ii]));
      imageLabels[ii].setPreferredSize(new Dimension(200, 180));
       imageLabels[ii].setBorder(BorderFactory.createLineBorder(Color.black, 3));
      imageLabels[ii].setIcon(new ImageIcon( images[ii].getScaledInstance(200, 180, Image.SCALE_SMOOTH)));
    }
    return imageLabels;   
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
