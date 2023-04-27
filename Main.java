
import javax.swing.JFrame;

public class Main {
    

    private static String title = "RPG";
    
    public static void main(String[] args){
        
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(title);
        
        SpieleKonsole spielekonsole = new SpieleKonsole();
        window.add(spielekonsole);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        spielekonsole.startGameThread();
    }
    

}