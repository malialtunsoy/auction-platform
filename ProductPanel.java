
import java.awt.BorderLayout;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.event.MouseInputAdapter;


import javax.swing.event.MouseInputAdapter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
/**
 * Auto Generated Java Class.
 */
public class ProductPanel extends JPanel {
  
  final int WIDTH = 300;
  final int HEIGHT = 450;
  
//  JPanel proPanel = new JPanel(new GridBagLayout());;
  GridBagConstraints c = new GridBagConstraints();
  JLabel nameLabel = new JLabel();
  //foto
  //rating
  JLabel priceTagLabel = new JLabel();
  JLabel priceLabel = new JLabel();
  JLabel dateTagLabel = new JLabel();
  //date
  JLabel infoTagLabel = new JLabel();
  JLabel infoLabel = new JLabel();
  
  JLabel imageLabel;
  StarRate stars;
  int productID;
  int userID;
  
  
  //********************************************************************************CONSTRUCTOR
  //******************************************************************************** 
  
  
  public ProductPanel(int productID, int userID )
  {
    super(new GridBagLayout());
    
//    this.setLayout(new BorderLayout() );
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.productID = productID;
    this.userID = userID;
    
    createPanel();
    
    addMouseListener(new Mouse());
    
  }
  
  @Override
  protected void paintComponent (Graphics g) {
    super.paintComponent(g);
    
    
  }
  
  //******************************************************************************** MAIN 
  //******************************************************************************** PANEL
  
  
  
  public void createPanel()
  {
    
    createNameLabel();
    createPriceLabel();
    createInfoLabel();
    setBorder(BorderFactory.createLineBorder(Color.black, 1));
    createImagePanel();
    createDateLabel();
    createStarPanel();
    
    
    
    
    c.fill = GridBagConstraints.NORTH; //name
    c.gridx = 0;
    c.gridy = 0;
    add(nameLabel,c);
    
    c.fill = GridBagConstraints.HORIZONTAL; //image
    c.gridx = 0;
    c.gridy = 1; 
    add(imageLabel,c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    add(stars,c);
    
    
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 3;
    add(priceTagLabel,c);
    
    
    
    c.fill = GridBagConstraints.EAST;
    
    c.gridx = 0;
    c.gridy = 3;
    add(priceLabel,c);
    
    
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 4;
    add(dateTagLabel,c);
    
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 5;
    add(infoTagLabel,c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weighty = 1.0;
    c.gridx = 0;
    c.gridy = 6;
    add(infoLabel,c);
    
    
  }
  
  //******************************************************************************** CREATE
  //******************************************************************************** LABELS
  
  public void createNameLabel()
  {
    nameLabel.setText( "" + ProductContainer.productList.get(productID).getName() );
    nameLabel.setFont( new Font("Verdana",Font.BOLD,20));
    
  }
  public void createPriceLabel()
  {
    priceTagLabel.setText("Price: ");
    priceLabel.setText("$" + ProductContainer.productList.get(productID).getCurrentPrice() );
    
//    priceLabel.setPreferredSize(new Dimension(10,50));
//    priceLabel.setHorizontalTextPosition(JLabel.RIGHT);
//    priceLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
  }
  public void createStarPanel()
  {
    stars = new StarRate(ProductContainer.productList.get(productID).getSeller().getUserRatingDouble());
    
    
  }
  public void createDateLabel()
  {
    dateTagLabel.setText("Date:    " + ProductContainer.productList.get(productID).getDate());
    
    
    
  }
  public void createInfoLabel()
  {
    infoTagLabel.setText("Information: ");
    infoLabel.setPreferredSize(new Dimension(50,75));
    
    infoLabel.setText( "<html>" + ProductContainer.productList.get(productID).getInformation() +"</html>" );
    infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
    infoLabel.setVerticalAlignment(SwingConstants.NORTH);
    infoLabel.setOpaque(true);
    Color renk = new Color(210,210,210);
    infoLabel.setBackground(renk);
    
    
    
  }
  
  public void createImagePanel()
  {
    BufferedImage image = null;
     try{ 
     image = ImageIO.read(new File("blank.png"));
    }catch(IOException ex){System.out.println("faileda");}
    try{ 
//      System.out.println(productID);
//      System.out.println(ProductContainer.productList.get(productID).getProductImages().get(0));
      image = ImageIO.read(new File(ProductContainer.productList.get(productID).getProductImages().get(0)));
//        ProductContainer.productList.get(productID).getProductImage()
    }catch(IOException ex){System.out.println("failed");}
    imageLabel = new JLabel( new ImageIcon(image));
    imageLabel.setPreferredSize(new Dimension(270,250));
//     Image dimage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
//        Image.SCALE_SMOOTH);
    
    imageLabel.setIcon(new ImageIcon(image.getScaledInstance(270, 250, Image.SCALE_SMOOTH)));
    
  }
  
  //******************************************************************************** OTHER
  //******************************************************************************** THINGS
  
  public void setFrame()
  {
    //make program
    this.add(Box.createRigidArea(new Dimension(10,0)),BorderLayout.WEST); //more organised
    this.add(Box.createRigidArea(new Dimension(10,0)),BorderLayout.EAST);
//    this.add(grid,BorderLayout.CENTER);
//    this.add(proPanel,BorderLayout.SOUTH);    
    
    
  }
  
  
  class clickListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
//      System.out.println("aaa");
    }
  }
  
  class Mouse extends MouseInputAdapter
  {
    public void mousePressed(MouseEvent event)
    {
      super.mousePressed(event);
//      System.out.println(ProductContainer.productList.get(productID).getName());
      
      JFrame frame = new ProductInfoPop( productID, userID);
      frame.setSize(new Dimension(600, 600));
      frame.setVisible(true);
           
    }
    
  }
  
  
  
  
}



