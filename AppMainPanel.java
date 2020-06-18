import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.Dimension;

import java.awt.Font;

import javax.swing.BoxLayout;



public class AppMainPanel extends JPanel{
  
  
  
  final int WIDTH = 1300;
  final int HEIGHT = 1000;
  
  static JPanel Vehicles;
  static JPanel VehiclePro;
  
  static JPanel Electronics;
  static JPanel ElectronicPro;
  
  static JPanel Clothes;
  static JPanel ClothePro;
  
  static JPanel Furniteres;
  static JPanel FurniterePro;
  
  static int id;
  //******************************************************************************** CONSTRUCTOR
  //******************************************************************************** 
  public AppMainPanel(int id)
  {
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.id = id;
    JPanel mainPanel = new JPanel();
    BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.X_AXIS); //BOX LAYOUT FOR X AXIS
    mainPanel.setLayout(boxlayout); //SET LAYOUT
    
    createMainPanel();
    
    mainPanel.add(VehiclePro) ;
    mainPanel.add(ElectronicPro) ;
    mainPanel.add(ClothePro) ;
    mainPanel.add(FurniterePro) ;
    
    add(mainPanel) ;
  
  }
  
  //******************************************************************************** MAIN 
  //******************************************************************************** PANEL
  public static void createMainPanel()
  {
    createVehicles();
    createElectronics();
    createClothes();
    createFurniteres();  
  }
  
  //******************************************************************************** CREATE 
  //******************************************************************************** VEHICLES
  public static void createVehicles()
  {
     
    Vehicles = new JPanel();
    VehiclePro = new JPanel(new BorderLayout());
    
    BoxLayout boxlayout = new BoxLayout(Vehicles, BoxLayout.Y_AXIS);
    Vehicles.setLayout(boxlayout);
    
    JLabel tag = new JLabel("Vehicles");
    tag.setFont( new Font("Verdana",Font.BOLD,20));
    
    JScrollPane vehicleScroll = new JScrollPane(Vehicles,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
    vehicleScroll.setPreferredSize(new Dimension(320,900));
     
    for(int i = 0; i < ProductContainer.productList.size(); i++) //GET ALL PRODCUT LIST
    {
      if(ProductContainer.productList.get(i).getType().equals("vehicle")) //CHECK PRODDUCT TYPE
      { 
        if(ProductContainer.productList.get(i).getOwner() == null) //IF NOT SOLDED
        {
        Vehicles.add( new ProductPanel(i,id),BorderLayout.PAGE_END); // ADD TO THE PANEL
        }
      }    
    }
    VehiclePro.add(tag,BorderLayout.PAGE_START);
    VehiclePro.add(vehicleScroll, BorderLayout.CENTER);
  }
  
  
  //******************************************************************************** CREATE 
  //******************************************************************************** ELECTRONICS
  public static void createElectronics()
  {
    Electronics = new JPanel();
    ElectronicPro = new JPanel(new BorderLayout());
    
    BoxLayout boxlayout = new BoxLayout(Electronics, BoxLayout.Y_AXIS);
    Electronics.setLayout(boxlayout);
    
    JScrollPane ElecScroll = new JScrollPane(Electronics,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
    ElecScroll.setPreferredSize(new Dimension(320,900));
    
    JLabel tag = new JLabel("Electronics");
    tag.setFont( new Font("Verdana",Font.BOLD,20));
    
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      if(ProductContainer.productList.get(i).getType().equals("electronics"))
      {
        if(ProductContainer.productList.get(i).getOwner() == null)
        {
        Electronics.add( new ProductPanel(i,id),BorderLayout.PAGE_END);
        }
      }
      
    }
    
    ElectronicPro.add(tag,BorderLayout.PAGE_START);
    ElectronicPro.add(ElecScroll, BorderLayout.CENTER);
    
    
  }
  
  
  //******************************************************************************** CREATE 
  //******************************************************************************** CLOTHES
  public static void createClothes()
  {
    Clothes = new JPanel();
    ClothePro = new JPanel(new BorderLayout());
    
    BoxLayout boxlayout = new BoxLayout(Clothes, BoxLayout.Y_AXIS);
    Clothes.setLayout(boxlayout);
    
    JScrollPane ClotheScroll = new JScrollPane(Clothes,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
    ClotheScroll.setPreferredSize(new Dimension(320,900));
    
    JLabel tag = new JLabel("Clothes");
    tag.setFont( new Font("Verdana",Font.BOLD,20));
    
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      if(ProductContainer.productList.get(i).getType().equals("clothes"))
      {
        if(ProductContainer.productList.get(i).getOwner() == null)
        {
        Clothes.add( new ProductPanel(i,id),BorderLayout.PAGE_END);
        }
      }
      
    }
    ClothePro.add(tag,BorderLayout.PAGE_START);
    ClothePro.add(ClotheScroll, BorderLayout.CENTER);
    
    
  }
  
  
  //******************************************************************************** CREATE 
  //******************************************************************************** FURNITERES
  public static void createFurniteres()
  {
    Furniteres = new JPanel();
    FurniterePro = new JPanel(new BorderLayout());
    
    
    BoxLayout boxlayout = new BoxLayout(Furniteres, BoxLayout.Y_AXIS);
    Furniteres.setLayout(boxlayout);
    
    JScrollPane FurnitureScroll = new JScrollPane(Furniteres,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
    FurnitureScroll.setPreferredSize(new Dimension(320,900));
    
    JLabel tag = new JLabel("Furniteres");
    tag.setFont( new Font("Verdana",Font.BOLD,20));
    
    
    for(int i = 0; i < ProductContainer.productList.size(); i++)
    {
      if(ProductContainer.productList.get(i).getType().equals("furnitere"))
      {
        if(ProductContainer.productList.get(i).getOwner() == null)
        {
        Furniteres.add( new ProductPanel(i,id),BorderLayout.PAGE_END);
        }
      }   
    }
    FurniterePro.add(tag,BorderLayout.PAGE_START);
    FurniterePro.add(FurnitureScroll, BorderLayout.CENTER);
  }
  
}
