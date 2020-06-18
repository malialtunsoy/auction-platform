import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Dimension;



import java.awt.*;

import javax.swing.BoxLayout;

/**
 * Auto Generated Java Class.
 */
public class TheMainPanel extends JPanel {
  
  final int WIDTH = 1600;
  final int HEIGHT = 1080;
  
  static JPanel mainPanel;
  
  static JPanel tabButtonsPanel;
  JButton homeButton;
  JButton searchButton;
  JButton inventoryButton;
  JButton profileButton;
  
  JPanel tempPanel;
  
   ActionListener HomeListener;
   ActionListener SearchListener;
   ActionListener InventoryListener;
   ActionListener ProfileListener;
   
   AppMainPanel homePanel;
   Inventory invPanel;
   Search searchPanel;
   Profile profilePanel;
  
  
  FlowLayout flowLayout = new FlowLayout();
  static int id;
  
  //********************************************************************************CONSTRUCTOR
  //******************************************************************************** 
  public TheMainPanel(int id)
  {
    super(new BorderLayout());
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.id = id;
    mainPanel = new JPanel();
    BoxLayout mainBoxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
   
    
    mainPanel.setLayout(mainBoxlayout);
   
    
    
//    new Menu();
    homePanel = new AppMainPanel(id);
    invPanel = new Inventory(id);
    searchPanel = new Search(id);
    profilePanel = new Profile(id);
      
    createActionListeners();
    createTabButtonsPanel();
    createTempPanel();
    
    mainPanel.add(tabButtonsPanel);
    mainPanel.add(tempPanel);
    
    add(mainPanel);
    
//    JPanel mainPanel = new JPanel();
//    BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
//    mainPanel.setLayout(boxlayout);
    
    
  }
  
  //******************************************************************************** TAB BUTTONS
  //******************************************************************************** PANEL
  public void createTabButtonsPanel()
  {
    tabButtonsPanel = new JPanel();
    tabButtonsPanel.setLayout(flowLayout);
    
    
    homeButton = new JButton("Home");
    searchButton = new JButton("Search");
    inventoryButton = new JButton("Inventory");
    profileButton = new JButton("Profile");
    
    homeButton.setPreferredSize(new Dimension(320, 50));
    searchButton.setPreferredSize(new Dimension(320, 50));
    inventoryButton.setPreferredSize(new Dimension(320, 50));
    profileButton.setPreferredSize(new Dimension(320, 50));
    
    homeButton.addActionListener(HomeListener);
    searchButton.addActionListener(SearchListener);
    inventoryButton.addActionListener(InventoryListener); 
    profileButton.addActionListener(ProfileListener);
    
 
    
    
    
    tabButtonsPanel.add(homeButton);
    tabButtonsPanel.add(searchButton);
    tabButtonsPanel.add(inventoryButton);
    tabButtonsPanel.add(profileButton);
    
  }
  
  //******************************************************************************** TEMP
  //******************************************************************************** PANEL
  public void createTempPanel()
  {
    tempPanel = new JPanel();
    tempPanel.setPreferredSize( new Dimension( 1300, 1080 ) );
//    tempPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
   
    tempPanel.add(homePanel);
  }
  
  //******************************************************************************** FRAME
  //******************************************************************************** 
  public static void createAndShowGUI() {
    //Create and set up the window.
    new TheMainPanel(0);
    JFrame frame = new JFrame("deneme");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Set up the content pane.
    frame.add(mainPanel);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
  
  public void createActionListeners()
  {
   HomeListener = new  HomeListener();
    SearchListener = new  SearchListener();
   InventoryListener = new  InventoryListener();
    ProfileListener = new  ProfileListener();
  }
     
   
  
  public static void main(String[] args) 
  {  
    createAndShowGUI();
  }
  
  class HomeListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      tempPanel.removeAll();
      
      tempPanel.add( new AppMainPanel(id));
      tempPanel.revalidate();
       tempPanel.repaint();
      mainPanel.repaint();
      System.out.println("Home");
    }
  }
  
  class SearchListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
    
      tempPanel.removeAll();
      
      tempPanel.add(new Search(id));
     tempPanel.repaint();
     mainPanel.repaint();
      tempPanel.revalidate();
      System.out.println("Search");
    }
  }
  
  class InventoryListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
     tempPanel.removeAll();
      
      tempPanel.add(new Inventory(id));
      tempPanel.revalidate();
      tempPanel.repaint();
      mainPanel.repaint();
     
      System.out.println("Inventory");
    }
  }
  
  class ProfileListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    { 
  tempPanel.removeAll();
      
      tempPanel.add(new Profile(id));
  tempPanel.revalidate();
       tempPanel.repaint();
      mainPanel.repaint();
      
     
      System.out.println("Profile");
      
    }
  }
  
  
  
  
  
  
  
  
  
}
