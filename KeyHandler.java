import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Write a description of class KeyInputHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KeyHandler implements KeyListener
{
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    public void keyTyped(KeyEvent e){
        
    }
    
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }
    
    //
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
