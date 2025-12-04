import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World 
{
    public ProgressBar progress;
    private CustomerDialogue1 tutorialBox;
    private boolean customerHasSpawned = false;
    
    public int TargetBurgers = 0;
    public int TargetFries = 0;
    public int TargetDrink = 0;
    
    private int timeRemaining = 45;
    private int frameCount = 0;
    
    public Clipboard clipboard;  
    private Customer currentCustomer; 
    
    // Expected order (burgers, fries, drinks)
    private int[] targetOrder = { 1, 0, 0 };
    private int[] lastOrder = { -1, -1, -1 };

    // Stores the last correctness state to avoid spam printing
    private boolean correct = false;  
    private boolean lastCorrectState = false;

    public LevelOne()
    {
        super(600, 400, 1);
        setBackground("JobBackground.png");

        progress = new ProgressBar(400, 20, 100);
        addObject(new Cashier(), 400, 200);
        addObject(progress, getWidth()/2, getHeight() - 20);

        clipboard = new Clipboard();
        addObject(clipboard, -250, 200);

        setPaintOrder(Clipboard.class, ProgressBar.class, CustomerDialogue1.class, Cashier.class);

        // Tutorial dialogue
        String[] tutorialLines = {
            "Tutorial: 'Welcome to your first day on the job.'",
            "Tutorial: 'You will be in charge of handling the customers.'",
            "Tutorial: 'Let's get this started.'",
            "Tutorial: 'Here's your first customer approaching...'"
        };

        tutorialBox = new CustomerDialogue1(tutorialLines);
        addObject(tutorialBox, getWidth()/2, 350);

        showText("Time: " + timeRemaining, 50, 30);

    }

    public void act()
    {
        frameCount++;
            
        if (frameCount >= 60) // Updates every 60 frames (roughly 1 second)
        {
            if (timeRemaining > 0) { // Only count down if time remains
                timeRemaining--;
            }
            frameCount = 0;
            showText("Time: " + timeRemaining, 50, 30);
        }
        
        // win if progress bar fills
        if (progress.getValue() >= 100)
        {
            showText("You Win!", 300, 200);
            Greenfoot.stop();
            return;
        }
        
        //  Check if time is up
        if (timeRemaining <= 0)
        {
            showText("Time's Up!", 300, 200);
            return;
        }
        
        // Spawn customer after tutorial step 2
        if (!customerHasSpawned && tutorialBox.getWorld() != null && tutorialBox.getIndex() == 2)
        {
            spawnCustomer();
            customerHasSpawned = true;
        }
        handleOrderChecking();
    }


    private void handleOrderChecking()
    {
        if (currentCustomer == null) return;

        int[] current = clipboard.getOrder();
        int currentCount = current[0] + current[1] + current[2];
        int targetCount = targetOrder[0] + targetOrder[1] + targetOrder[2];

        // checks selectipn
        if (currentCount >= targetCount)
        {
            boolean correct = true;
            for (int i = 0; i < 3; i++) {
                if (current[i] != targetOrder[i]) {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                showText("Order Is Good! Customer Leaving.", 300, 350);
                progress.addValue(10); // get promotion progress
            } else {    
                showText("Order Is Wrong!", 300, 350);
                progress.addValue(-10); // lose progress
            }
            nextCustomer();
        }
    }

    private void spawnCustomer(){      
        int customerWaitX = getWidth() / 2;
        int customerWaitY = getHeight() / 2;
        
        if (clipboard != null) {
            clipboard.resetOrder();
        }        
        
        lastOrder = new int[] { -1, -1, -1 };
        
        currentCustomer = new Customer(customerWaitX);
        addObject(currentCustomer, -50, customerWaitY);
    }
    
    public void nextCustomer() {
        //makes the old customer leave then spawns the next
        if (currentCustomer != null) {
            currentCustomer.leave();
        }
        spawnCustomer();
    }
    
    
}
