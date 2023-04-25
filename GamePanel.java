import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel implements Runnable
{
    final int pixelPerTile = 16;
    final int multiplier = 3;
    
    final int tileSize = pixelPerTile * multiplier; 
    
    final int maxScreenX = 16;
    final int maxScreenY = 12;
    
    final int screenWidth = tileSize * maxScreenX;
    final int screenHeight = tileSize * maxScreenY;
    
    Thread gameThread;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //better rendering performance
        
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        while(gameThread != null){
            update(); //update
            repaint(); //draw and repeat
        }
    }
    
    public void update(){
    
    }

    public void painComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(100, 100, tileSize, tileSize);
        
        g2.dispose();
    }
}
