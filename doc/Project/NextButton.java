import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextButton extends Actor
{
    GreenfootImage image = new GreenfootImage("button_next.png");

    public void act()
    {
        image.scale(75,50);
        setImage(image);

        if (Greenfoot.mouseClicked(this)) {
            // 1. Get the current World
            World currentWorld = getWorld();

            // 2. Find the existing TutorialPage object
            // The getObjects method returns a list, so we take the first element (index 0)
            TutorialPage page = currentWorld.getObjects(TutorialPage.class).get(0);

            // Tell the page object to advance to the next page and redraw its image            
            page.nextPage();

        }
    }
}   
