import java.awt.BorderLayout;





import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Dimension;


import java.awt.Color;
import java.awt.Font;



import javax.swing.BoxLayout;


public class Search extends JPanel
{
   final int WIDTH = 1300;
   final int HEIGHT = 1000;
   
   static JPanel mainSearchPanel;
   JPanel searchPanel;
   JPanel foundedPanel;
   JPanel itemsPanel;
   
   JTextField searchField;
   String productName;
   JLabel YITagLabel;
   JButton searchButton;
   static int id;
   
   public Search(int id)
   {
      super();
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      this.id = id;
//      new Menu();
      
      prepareSearchPanel();
      prepareFoundedPanel();
      
      prepareMainPanel();
      
      add(mainSearchPanel);
   }
   
   public void prepareSearchPanel()
   {
     searchPanel = new JPanel();
     searchField = new JTextField(50);
     searchButton = new JButton("Search");
     searchButton.addActionListener( new ActionListener()
                                      {
       public void actionPerformed(ActionEvent e) 
       {
         itemsPanel.removeAll();
         productName = searchField.getText();
         for(int i = 0; i < ProductContainer.productList.size(); i++)
         {
           String s = ProductContainer.productList.get(i).getName();
           s = s.toLowerCase();
           if(s.equals( productName ) || s.contains( productName.toLowerCase() ))
           {
             if(ProductContainer.productList.get(i).getOwner() == null)
             {
               itemsPanel.add( new ProductPanel(i,id),BorderLayout.LINE_END);
             }
           }
         }
         
         itemsPanel.revalidate();
         itemsPanel.repaint();
         
         
       }
     });
     
     searchPanel.setPreferredSize( new Dimension( 1200, 50 ) );
     searchPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
     
     searchPanel.add(searchField);
     searchPanel.add(searchButton);
   }
   
   public void prepareFoundedPanel()
   {
      foundedPanel = new JPanel(new BorderLayout());
      
      foundedPanel.setPreferredSize( new Dimension( 1200, 500 ) );
      foundedPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      
      YITagLabel = new JLabel("Founded Items:");
      YITagLabel.setFont( new Font("Verdana",Font.BOLD,15));
      
      itemsPanel = new JPanel();
      
      BoxLayout boxlayout = new BoxLayout(itemsPanel, BoxLayout.X_AXIS);
      itemsPanel.setLayout(boxlayout);
      
      JScrollPane itemsScroll = new JScrollPane(itemsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
      itemsScroll.setPreferredSize(new Dimension(1200,470));
      
      foundedPanel.add(YITagLabel,BorderLayout.NORTH);
      foundedPanel.add(itemsScroll, BorderLayout.CENTER);
      
   }
   
   public void prepareMainPanel()
   {
      mainSearchPanel = new JPanel();
      
      BoxLayout mainInvBoxlayout = new BoxLayout(mainSearchPanel, BoxLayout.Y_AXIS);
      mainSearchPanel.setLayout(mainInvBoxlayout);
      
      mainSearchPanel.add( searchPanel );
      mainSearchPanel.add( foundedPanel );
   }
   

}