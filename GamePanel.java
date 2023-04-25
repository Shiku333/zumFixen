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
    
    public static final int FPS = 60;
    
    public static final long maxLoopTime = 1000/ FPS;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    int playerX = 100;
    int playerY = 100;
    
    int playerSpeed = 4; 
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //better rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        
        GamePanel game = new GamePanel();        
        new Thread(game).start();
        
    }
    public boolean running = true;
    @Override
    
    public void run(){
        
        long timestamp;
        long oldTimestamp;
        while(running){
            oldTimestamp = System.currentTimeMillis(); //in oldTimestamp wird die Zeit gespeichert in der die Schleife begonnen wurde 
            update();
            timestamp = System.currentTimeMillis(); //die vergangene Zeit nach dem Update, die aktuelle
            if(timestamp-oldTimestamp > maxLoopTime) //wird überprüft ob die maxLoopTime überschritten wurde
            {
                System.out.println("Tesst");
                continue;
            }
            render();
      timestamp = System.currentTimeMillis();
      System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp));
      if(timestamp-oldTimestamp <= maxLoopTime) {
        try {
          Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    }
  void update() { }
  void render() { }
  
    public void run11(){      
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
    
    
    public void update11(){
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed == true){
            playerY += playerSpeed;
        }
        //
        if(keyH.leftPressed == true){
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed == true){
            playerX += playerSpeed;
        }
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        
        g2.dispose();
    }
}
