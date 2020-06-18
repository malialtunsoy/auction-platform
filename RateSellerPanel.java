
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;


public class RateSellerPanel extends JPanel {
  
 
  final int WIDTH = 150;
  final int HEIGHT = 70;
  
  
  JLabel[] stars = new JLabel[5];
  
  int clickedRate = 0;
  
  JPanel starsPanel;

static int rate = 0;
  
  public RateSellerPanel(int i) 
  { 
    super();
//    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
    starsPanel = new JPanel();
    starsPanel = createStarPanel(0);

    createButtonPanel();
    add(starsPanel); 
   
  }
  

  public JPanel createStarPanel(double rate)
  {
      int n = (int) Math.round(rate);
      JPanel tempStar = new JPanel();
//      tempStar.setPreferredSize(new Dimension(150,50));
      
     BufferedImage star = null;
    try{ star = ImageIO.read(new File("star.png"));
    }catch(IOException ex){System.out.println("failed");}
     
     BufferedImage darkStar = null;
    try{darkStar = ImageIO.read(new File("darkstar.png"));
       }catch(IOException ex){System.out.println("failed");}
     
     for(int i = 0; i < n ; i++)
     {
       stars[i] = new JLabel( new ImageIcon(star));
       stars[i].setPreferredSize(new Dimension(25,25));
       stars[i].setIcon(new ImageIcon(star.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
       tempStar.add(stars[i]);
     }
     for(int i = n; i < 5 ; i++)
     {
       stars[i] = new JLabel( new ImageIcon(darkStar));
       stars[i].setPreferredSize(new Dimension(25,25));
       stars[i].setIcon(new ImageIcon(darkStar.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
       tempStar.add(stars[i]);
     }
     
     createButtonPanel();
     repaint();
     return tempStar;
  }
  
  
  
  public static void main(String[] args) 
  { 
    JFrame frame = new JFrame();
      frame.setSize(new Dimension(1000,1000));
//      frame.add(createStarPanel(0));
      frame.setVisible(true);
  }
  
   public void createButtonPanel()
   {
     stars[0].addMouseListener(new Mouse1());
     stars[1].addMouseListener(new Mouse2());
     stars[2].addMouseListener(new Mouse3());
     stars[3].addMouseListener(new Mouse4());
     stars[4].addMouseListener(new Mouse5());
     }
   
   
    class Mouse1 extends MouseInputAdapter{
      public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        System.out.println("1");
        rate = 1;
        starsPanel.removeAll();
        starsPanel.add(createStarPanel(1));
        starsPanel.revalidate();
        starsPanel.repaint();
      
      }}
    
     class Mouse2 extends MouseInputAdapter{
      public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        System.out.println("2");
        rate = 2;
        starsPanel.removeAll();
        starsPanel.add(createStarPanel(2));
        starsPanel.revalidate();
        starsPanel.repaint();
      }}
     
      class Mouse3 extends MouseInputAdapter{
      public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        System.out.println("3");
        rate = 3;
        starsPanel.removeAll();
        starsPanel.add(createStarPanel(3));
        starsPanel.revalidate();
        starsPanel.repaint();
      }}
      
       class Mouse4 extends MouseInputAdapter{
      public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        System.out.println("4");
        rate = 4;
        starsPanel.removeAll();
        starsPanel.add(createStarPanel(4));
        starsPanel.revalidate();
        starsPanel.repaint();
      }}
       
        class Mouse5 extends MouseInputAdapter{
      public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        System.out.println("5");
        rate = 5;
        starsPanel.removeAll();
        starsPanel.add(createStarPanel(5));
        starsPanel.revalidate();
        starsPanel.repaint();     
      }}
    
        
       static  public int getRate()
        {
          return rate;
        }
   
  
}
