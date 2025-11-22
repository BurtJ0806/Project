import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {    
        super(600, 400, 1);
        setBackground("JobBackground.png");
        addObject(new Cashier(), 300, 200);
    }
}
