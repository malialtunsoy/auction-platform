


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Dimension;




/**
 * Auto Generated Java Class.
 */
public class deleteItemFrame extends JFrame
{
  
  
  JFrame mainItemFrame;
  
  int productID;
  
  JPanel mainItemPanel;
  
  JButton deleteButton;
  JButton cancelButton;
  
  ActionListener deleteListener;
  ActionListener cancelListener;
  
  int wantedProductID = 0;
  
 //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  public deleteItemFrame( int productID )
  { 
   this.productID = productID ;
    
//   new Menu();
    
    prepareMainPanel();
    
    add(mainItemPanel);
  }
  
    
    //******************************************************************************** BUTTON
  //******************************************************************************** PANEL
    public void prepareButtons()
  {

   deleteButton = new JButton("Remove Product");
   cancelButton = new JButton("Cancel");
   
   createDeleteListener();
   createCancelListener();
   
   deleteButton.addActionListener(deleteListener);
   cancelButton.addActionListener(cancelListener);
  
  }

     //******************************************************************************** MAIN
  //********************************************************************************   PANEL
     public void prepareMainPanel( )
  {
    prepareButtons();   
    mainItemPanel = new JPanel();
    mainItemPanel.setLayout(null);
    mainItemPanel.setPreferredSize(new Dimension(400, 240));
   
    JLabel itemName = new JLabel("Product: "  + ProductContainer.productList.get(productID).getName() );
    itemName.setLocation(50,20);
    itemName.setSize(150,15);
    
    deleteButton.setLocation(50,60);
    deleteButton.setSize(150,80);
    
    cancelButton.setLocation(240,60);
    cancelButton.setSize(80,80);
       
       mainItemPanel.add(deleteButton);
       mainItemPanel.add(cancelButton);
        mainItemPanel.add(itemName);
       
  }

   //******************************************************************************** GUI
  //********************************************************************************   
  
  public static void main(String[] args)
  { 
      JFrame frame = new deleteItemFrame(1);
      frame.setSize(new Dimension(400, 240));
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
   
    class deleteListener implements ActionListener
    {
       public void actionPerformed(ActionEvent event)
       {
          
          ProductContainer.productList.remove(productID);
          System.out.println("succesful");
          
          Profile.yourShopPanel.removeAll();
          Profile.updateShopPanel();
          Menu.updateProductList();
          
          
          Profile.yourShopPanel.revalidate();
          Profile.yourShopPanel.repaint();
          setVisible(false);
          dispose();
       }
    }
   
     public void createDeleteListener()
  {
    
    deleteListener = new deleteListener();
    
  }
    public void createCancelListener()
  {
    cancelListener = new cancelListener();
  }
    
}
