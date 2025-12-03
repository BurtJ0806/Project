import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgressBar extends Actor
{
    private int width;
    private int height;
    private int maxValue;
    private int currentValue;

    public ProgressBar(int width, int height, int maxValue) {
        this.width = width;
        this.height = height;
        this.maxValue = 100;
        this.currentValue = 30;
        updateImage();
    }

    public void addValue(int amount) {
        currentValue += amount;
        currentValue = Math.max(0, Math.min(currentValue, maxValue));
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);

        img.setColor(Color.DARK_GRAY);
        img.fillRect(0, 0, width, height);

        img.setColor(Color.GREEN);
        int fillWidth = (int)((double)currentValue / maxValue * width);
        img.fillRect(0, 0, fillWidth, height);

        setImage(img);
    }
    
    public void act() {
    if (Greenfoot.isKeyDown("w")) {
        addValue(1);     // gain 10
    }
    if (Greenfoot.isKeyDown("l")) {
        addValue(-1);    // lose 10
    }
    }
}
