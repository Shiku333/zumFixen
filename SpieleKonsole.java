import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class SpieleKonsole extends JPanel implements Runnable
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


    Steuerungen keyH = new Steuerungen();
    Thread gameThread;

    Spieler player;


    public SpieleKonsole() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //better rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);

        player = new Spieler(this, keyH);
    }

    
    
    public void startGameThread(){
        gameThread = new Thread();
        new Thread(this).start();
        
    }

    public boolean running = true;
    @Override 

    public void run(){

        
        long timestamp;
        long oldTimestamp;
        while(running){
            oldTimestamp = System.currentTimeMillis(); //in oldTimestamp wird die Zeit gespeichert in der die Schleife begonnen wurde 
            update();// Berchnung der spielmechanik
            repaint();
            timestamp = System.currentTimeMillis(); //die vergangene Zeit nach dem Update, die aktuelle
            if(timestamp-oldTimestamp > maxLoopTime) //wird überprüft ob die maxLoopTime überschritten wurde
            {
                System.out.println("Tesst");
                continue;
            }
            render(); //anzeige des Spielfeldes mit allen darauf befindenen Objekten 
            timestamp = System.currentTimeMillis(); // die verganene Zeit nach dem render
            System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp)); 
            if(timestamp-oldTimestamp <= maxLoopTime) { // Wenn zu viel Zeit nehmen wir dies in kauf, wenn aber 
                // die maxLoopTime noch nicht erreicht wurde legen wird das Spiel bis das erreicht ist schlafen
                
                try {
                    Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
       
    }
    
    void render() {} //anzeige des spielofeldes und alles was darauf ist (Objekte)
     
    public void update(){
        player.update();
    }
    
    /**static void update()
    {
        try {
            Thread.sleep(15);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        };
    
    }*/

     
    
   

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        player.draw(g2);
        
        g2.dispose();
    }
}

