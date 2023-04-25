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
    
    public final int tileSize = pixelPerTile * multiplier; 
    
    final int maxScreenX = 16;
    final int maxScreenY = 12;
    
    final int screenWidth = tileSize * maxScreenX;
    final int screenHeight = tileSize * maxScreenY;
    
    int FPS = 60;
    
    
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    Player player = new Player(this, keyH);
    
    int playerX = 100;
    int playerY = 100;
    
    int playerSpeed = 4; 
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); //better rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
            
            
            
            update(); //update
            repaint(); //draw and repeat
            
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                
                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }
                

                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
    
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        player.draw(g2);
        
        g2.dispose();
    }
}
