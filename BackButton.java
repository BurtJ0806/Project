import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButton(){
        GreenfootImage image = new GreenfootImage("button_previous.png");
        image.scale(75, 50); // Scale to match NextButton
        setImage(image);
        //setImage("back-arrow.png");
    
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(this)) {
            // 1. Get the current World
            World currentWorld = getWorld();
            
            // 2. Find the existing TutorialPage object
            // Use getObjects to find the single TutorialPage instance
            TutorialPage page = currentWorld.getObjects(TutorialPage.class).get(0);
            
            // 3. Tell the page object to move back one page
            page.previousPage();
            Greenfoot.setWorld(new TutorialMenu());
        }
    }
}
