 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PageDot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PageDot extends Actor
{
    private int size;
    private Color color;

    public PageDot(int size, Color color) {
        this.size = size;
        this.color = color;
        drawDot();
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        drawDot();
    }

    private void drawDot() {
        GreenfootImage img = new GreenfootImage(size, size);
        img.setColor(new Color(0,0,0,0)); // transparent background
        img.fill();
        img.setColor(color);
        img.fillOval(0, 0, size, size);
        setImage(img);
    }
}
    