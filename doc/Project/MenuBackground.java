import greenfoot.*;

public class MenuBackground extends Actor
{
    private int centerX = 300;
    private int centerY = 200;
    private double offset = 0;       
    private double speed = 0.3;        
    private boolean movingRight = true;
    private double maxOffset = 50;   
    GreenfootImage image = new GreenfootImage("MenuBackground.jpg");
    

    public void act()
    {
        image.scale(800, 800);
        setImage(image);
        if (movingRight)
        {
            offset += speed;
            if (offset >= maxOffset)
            {
                movingRight = false;
            }
        }
        else
        {
            offset -= speed;
            if (offset <= -maxOffset)
            {
                movingRight = true; 
            }
        }

        setLocation((int)(centerX + offset), centerY);
    }
}
