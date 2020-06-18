
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;

import javax.swing.*;

import java.awt.Dimension;



/**
 * Auto Generated Java Class.
 */
public class StarRate extends JPanel{
  
  final int WIDTH = 5;
  final int HEIGHT = 30;
  
  JLabel star1;
  JLabel star2;
  JLabel[] stars = new JLabel[5];

  public StarRate(double rate)
  {
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    createStarPanel(rate);
 
  }
  
    public void createStarPanel(double rate)
  {
      int n = (int) Math.round(rate);
      
      
     BufferedImage star = null;
    try{ 
       
         star = ImageIO.read(new File("star.png"));
        
     }catch(IOException ex){System.out.println("failed");}
     
     BufferedImage darkStar = null;
    try{ 
       
         darkStar = ImageIO.read(new File("darkstar.png"));
        
     }catch(IOException ex){System.out.println("failed");}
     
     for(int i = 0; i < n ; i++)
     {
       stars[i] = new JLabel( new ImageIcon(star));
       stars[i].setPreferredSize(new Dimension(15,15));
       stars[i].setIcon(new ImageIcon(star.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
       add(stars[i]);
     }
     for(int i = n; i < 5 ; i++)
     {
       stars[i] = new JLabel( new ImageIcon(darkStar));
       stars[i].setPreferredSize(new Dimension(15,15));
       stars[i].setIcon(new ImageIcon(darkStar.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
       add(stars[i]);
     }
     

  }
  
  
}
