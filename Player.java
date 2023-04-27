import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x= 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_2.png"));
            
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_3.png"));
            
                
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

            if(keyH.shiftPressed == true){
                speed = 6;
            }
            else{
                speed = 4;
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
        
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNumber == 1){
                    image = up1;
                }
                else if(spriteNumber == 2){
                    image = up2;
                }
                else if(spriteNumber == 3){
                    image = up3;
                }
                else if(spriteNumber == 4){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNumber == 1){
                    image = down1;
                }
                else if(spriteNumber == 2){
                    image = down2;
                }
                else if(spriteNumber == 3){
                    image = down3;
                }
                else if(spriteNumber == 4){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber == 1){
                    image = left1;
                }
                else if(spriteNumber == 2){
                    image = left2;
                }
                else if(spriteNumber == 3){
                    image = left1;
                }
                else if(spriteNumber == 4){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1){
                    image = right1;
                }
                else if(spriteNumber == 2){
                    image = right2;
                }
                else if(spriteNumber == 3){
                    image = right1;
                }
                else if(spriteNumber == 4){
                    image = right2;
                }
                break;

        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
