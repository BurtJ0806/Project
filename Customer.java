import greenfoot.*;  

public class Customer extends Actor
{
    private int waitingX;       // The X-coordinate where the customer will stop
    private int slideSpeed = 2; // How many pixels to move per act cycle
    
    
    private String state = "SLIDING_IN"; // "SLIDING_IN", "WAITING", "SLIDING_OUT"

    /**
     * Constructor for a new Customer.
     * 'waitingX' is the X-position where they will stop.
     */
    public Customer(int waitingX)
    {
        this.waitingX = waitingX;
        
        // --- This code loads and scales your image ---
        
        // 1. Manually load your image
        GreenfootImage img = new GreenfootImage("Customer.png");
        
        int newWidth = 80;
        
        // 3. Automatically calculate the height to keep the shape
        int originalWidth = img.getWidth();
        int originalHeight = img.getHeight();
        int newHeight = (int)((double)originalHeight / originalWidth * newWidth);
        
        // 4. Scale the image to the new, smaller size
        img.scale(newWidth, newHeight); 
        
        setImage(img); 
    }

    /**
     * The main act() loop. This runs every frame.
     * It just checks the 'state' and calls the right method.
     */
    public void act() 
    {
        if (state.equals("SLIDING_IN"))
        {
            slideIn();
        }
        else if (state.equals("WAITING"))
        {
            // When waiting, check if the user clicks on us
            if (Greenfoot.mouseClicked(this))
            {
                leave(); // If clicked, start leaving
            }
        }
        else if (state.equals("SLIDING_OUT"))
        {
            slideOut();
        }
    }    
    
    /**
     * Called when the state is "SLIDING_IN".
     * Moves the customer to the right until it hits the 'waitingX' position.
     */
    /**
     * Called when the state is "SLIDING_IN".
     * Moves the customer to the right until it hits the 'waitingX' position.
     */
    private void slideIn()
    {
        if (getX() < waitingX)
        {
            // Keep moving right
            setLocation(getX() + slideSpeed, getY());
        }
        else
        {
            // We've arrived. Stop at the exact spot and change state.
            setLocation(waitingX, getY());
            state = "WAITING";
            
            
            // 1. Define the text for the bubble
            String[] bubbleText = { "Yo, yo, yo! Big burger. No fries, please." };

            // 2. Create a new dialogue object for the bubble
            CustomerDialogue1 speechBubble = new CustomerDialogue1(bubbleText);

            // 3. Calculate position: above and to the right of the customer
            //    (getX(), getY()) is the customer's center.
            int bubbleX = getX() + 40; // To the right
            int bubbleY = getY() - 60; // "Above" the customer's head

            // 4. Add the bubble to the world
            getWorld().addObject(speechBubble, bubbleX, bubbleY);
        }
    }
    
    /**
     * Called when the state is "SLIDING_OUT".
     * Moves the customer to the right until it's off the screen.
     */
    private void slideOut()
    {
        
        int endX = getWorld().getWidth() + 100; // 100 pixels off-screen
        
        if (getX() < endX)
        {
            // Keep moving right
            setLocation(getX() + slideSpeed, getY());
        }
        else
     
            getWorld().removeObject(this);
        }
    
    
    /**
     * This is a public method that other objects (like the World)
     * can call to tell the customer to leave.
     */
    public void leave()
    {
        state = "SLIDING_OUT";
    }
}  


