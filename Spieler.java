import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Spieler extends Einheiten
{
    SpieleKonsole sk;
    Steuerungen keyH;

    public BufferedImage walking_up3, walking_down3;
    public BufferedImage idle_up3, idle_up4, idle_left3, idle_left4, idle_right3, idle_right4, idle_down3, idle_down4;

    BufferedImage imageToRender;

    public Spieler(SpieleKonsole sk, Steuerungen keyH) {

        this.sk = sk;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x= 100;
        y = 100;
        speed = 4;
        direction = "down";
        state = "idle";
        imageToRender = null;
    }

    public void getPlayerImage(){
        try {

            walking_up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_1.png"));
            walking_up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_2.png"));
            walking_down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_1.png"));
            walking_down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_2.png"));
            walking_left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_1.png"));
            walking_left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_2.png"));
            walking_right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_1.png"));
            walking_right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_2.png"));
            
            walking_up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_3.png"));
            walking_down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_3.png"));

            idle_up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_up_1.png"));
            idle_up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_up_2.png"));
            idle_down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_down_1.png"));
            idle_down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_down_2.png"));
            idle_left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_left_1.png"));
            idle_left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_left_2.png"));
            idle_right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_right_1.png"));
            idle_right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_right_2.png"));

            idle_up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_up_3.png"));
            idle_up4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_up_4.png"));
            idle_down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_down_3.png"));
            idle_down4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_down_4.png"));
            idle_left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_left_3.png"));
            idle_left4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_left_4.png"));
            idle_right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_right_3.png"));
            idle_right4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/idle/boy_right_4.png"));
            
                
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        {
            if(keyH.upPressed == true){
                direction = "up";
                y -= speed;
            }
            else if(keyH.downPressed == true){

                direction = "down";
                y += speed;
            }

            if(keyH.leftPressed == true){

                direction = "left";
                x -= speed;
            }
            else if(keyH.rightPressed == true){

                direction = "right";
                x += speed;
            }
            state = "walking";
        }
        else{
            state = "idle";
        }

        spriteCounter++;

        if(spriteCounter > 10){
            if(spriteNumber == 1)
            {
                spriteNumber = 2;
            }
            else if(spriteNumber == 2){
                spriteNumber = 3;
            }
            else if(spriteNumber == 3){
                spriteNumber = 4;
            }
            else if(spriteNumber ==4){
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
        
    }
    public void draw(Graphics2D g2){
        setImage();
        g2.drawImage(imageToRender, x, y, sk.tileSize, sk.tileSize, null);
    }

    public void setImage(){
        if(state == "walking"){
            switch(direction){
                case "up":
                    if(spriteNumber == 1){
                        imageToRender = walking_up1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = walking_up2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = walking_up3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = walking_up2;
                    }
                    break;
                case "down":
                    if(spriteNumber == 1){
                        imageToRender = walking_down1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = walking_down2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = walking_down3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = walking_down2;
                    }
                    break;
                case "left":
                    if(spriteNumber == 1){
                        imageToRender = walking_left1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = walking_left2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = walking_left1;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = walking_left2;
                    }
                    break;
                case "right":
                    if(spriteNumber == 1){
                        imageToRender = walking_right1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = walking_right2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = walking_right1;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = walking_right2;
                    }
                    break;

            }
        }
        else if(state == "idle"){
            switch(direction){
                case "up":
                    if(spriteNumber == 1){
                        imageToRender = idle_up1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = idle_up2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = idle_up3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = idle_up4;
                    }
                    break;
                case "down":
                    if(spriteNumber == 1){
                        imageToRender = idle_down1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = idle_down2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = idle_down3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = idle_down4;
                    }
                    break;
                case "left":
                    if(spriteNumber == 1){
                        imageToRender = idle_left1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = idle_left2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = idle_left3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = idle_left4;
                    }
                    break;
                case "right":
                    if(spriteNumber == 1){
                        imageToRender = idle_right1;
                    }
                    else if(spriteNumber == 2){
                        imageToRender = idle_right2;
                    }
                    else if(spriteNumber == 3){
                        imageToRender = idle_right3;
                    }
                    else if(spriteNumber == 4){
                        imageToRender = idle_right4;
                    }
                    break;

            }
               

                
                
        } 
    }
}
