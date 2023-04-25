
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args){
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("RPG");
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}