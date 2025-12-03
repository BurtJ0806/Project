import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButtonTut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButtonTut extends Actor
{
    /**
     * Act - do whatever the BackButtonTut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButtonTut(){
        GreenfootImage image = new GreenfootImage("ExitButton.png");
        image.scale(30, 30); // Scale to match NextButton
        setImage(image);
    }
    public void act()
    {
    if (Greenfoot.mouseClicked(this)) {
        MainMenu mainMenu1 = new MainMenu();
        Greenfoot.setWorld(mainMenu1);
    }
}
}

