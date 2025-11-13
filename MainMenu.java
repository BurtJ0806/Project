import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        super(600, 400, 1); 
        addObject(new MenuBackground(), 300, 200);
        addObject(new Title(), 300, 100);
        addObject(new StartButton(), 300, 200);
        addObject(new TutorialButton(), 300, 270);
        addObject(new ClockOut(), 300, 340);
        
    }
}
