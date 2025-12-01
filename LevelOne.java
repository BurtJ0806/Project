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
    private CustomerDialogue1 tutorialBox;
    private boolean customerHasSpawned = false;

    public LevelOne()
    {
        super(600, 400, 1);
        setBackground("JobBackground.png");

        progress = new ProgressBar(400, 20, 100);
        addObject(progress, getWidth()/2, getHeight() - 20);
        
        // 1. Create an array of Strings for your tutorial dialogue
        String[] tutorialLines = {
            "Tutorial: 'Welcome to your first day on the job.'",//index one
            "Tutorial: 'You will be in charge of handling the customers.'",//index two
            "Tutorial: 'Let's get this started.'",
            "Tutorial: 'Here's your first customer approaching...'"
        };

        
        tutorialBox = new CustomerDialogue1(tutorialLines);
        addObject(tutorialBox, getWidth()/2, getHeight()-50);    
        
        
    }
    
    public void act()
    {
        //this will check 3 things
        //has the customer already spawned? (no.) 
        //does the tut box exist? (yes.)
        //is the tut on index 2?
        if (!customerHasSpawned && tutorialBox.getWorld() != null && tutorialBox.getIndex() ==2)
        {
            spawnCustomer();
            customerHasSpawned = true;
            
        }
        
    }
    
    private void spawnCustomer()
    {
        int customerWaitX = getWidth() / 2;
        int customerWaitY = getHeight() / 2;
        
        Customer customer1 = new Customer(customerWaitX);
        
        addObject(customer1, -50, customerWaitY);
    }
}
    




 