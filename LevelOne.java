import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    public ProgressBar progress;

    public LevelOne()
    {
        super(600, 400, 1);

        progress = new ProgressBar(800, 20, 100);
        addObject(progress, getWidth()/2, getHeight() - 20);
    }
}
