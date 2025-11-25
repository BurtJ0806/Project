import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialLevel extends World
{
    public ProgressBar progress;
    /**
     * Constructor for objects of class TutorialLevel.
     * 
     */
    public TutorialLevel()
    {    
        super(600, 400, 1); 
        setBackground("JobBackground.png");
        addObject(new Register(), 300, 200);
        progress = new ProgressBar(400, 20, 100);
        progress.setRotation(270);
        progress.setLocation(200,200);
        addObject(progress, getWidth() / 2, getHeight() - 20);

    }
}
