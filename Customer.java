import greenfoot.*;  

public class Customer extends Actor
{
    private int waitingX;       
    private int slideSpeed = 2; 
    String[] person = { "Customer.png", "Customer2.png", "Customer3.png", "Customer4.png","Customer5.png","Customer6.png","Customer7.png","Customer8.png","Customer9.png","Customer10.png" };
    
    private String state = "SLIDING_IN"; 
    /**
     * Constructor for a new Customer.
     * 'waitingX' is the X-position where they will stop.
     */
    public Customer(int waitingX)
    {
        this.waitingX = waitingX;
        
        
        
        int randomIndex = Greenfoot.getRandomNumber(person.length);
        String randomChoice = person[randomIndex];
        GreenfootImage img = new GreenfootImage(randomChoice);
        
        int newWidth = 200;
        
      
        int originalWidth = img.getWidth();
        int originalHeight = img.getHeight();
        int newHeight = (int)((double)originalHeight / originalWidth * newWidth);
        
 
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
            if (Greenfoot.mouseClicked(this))
            {
                leave(); 
            }
        }
        else if (state.equals("SLIDING_OUT"))
        {
            slideOut();
            shrinkToOnePixel();
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
            setLocation(getX() + slideSpeed, getY());
        }
        else
        {
            
            setLocation(waitingX, getY());
            state = "WAITING";
            String[] bubbleText = { "Yo, yo, yo! Big burger. No fries, please." };
            CustomerDialogue1 speechBubble = new CustomerDialogue1(bubbleText);
            int bubbleX = getX() + 40; 
            int bubbleY = getY() - 120; 
            getWorld().addObject(speechBubble, bubbleX, bubbleY);
        }
    }
    
    /**
     * Called when the state is "SLIDING_OUT".
     * Moves the customer to the right until it's off the screen.
     */
    private void slideOut()
    {
        
        int endX = getWorld().getWidth() + 400; 
        
        if (getX() < endX)
        {
            setLocation(getX() + slideSpeed, getY());
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    
    /**
     * This is a public method that other objects (like the World)
     * can call to tell the customer to leave.
     */
    public void leave()
    {
        state = "SLIDING_OUT";
        
    }
    
    public void shrinkToOnePixel() {
        GreenfootImage img = getImage();
        img.scale(1, 1); 
        setImage(img);
    }
}  






