import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockOut extends Actor
{
    GreenfootImage image = new GreenfootImage("ClockOut.png");
    
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        image.scale(150,50);
        setImage(image);
         if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
        }
    }
}
