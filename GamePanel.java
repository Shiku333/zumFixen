import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable
{

    public static final int FPS = 60;

    public static final long maxLoopTime = 1000/ FPS;

    final int pixelPerTile = 16;
    final int multiplier = 5;

    public final int tileSize = pixelPerTile * multiplier; 

    final int maxScreenX = 16;
    final int maxScreenY = 12;

    final int screenWidth = tileSize * maxScreenX;
    final int screenHeight = tileSize * maxScreenY;


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //better rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);

        player = new Player(this, keyH);
    }

    
    
    public void startGameThread(){
        gameThread = new Thread();
        new Thread(this).start();
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

