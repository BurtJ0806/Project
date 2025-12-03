import greenfoot.*; 


/**
 * A dialogue box that displays lines of text one by one.
 * The user can click the box to advance to the next line.
 * * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerDialogue1 extends Actor
{
    
    private String[] dialogue;
    private int index;

    //This is the Constructor
    public CustomerDialogue1(String[] dialogue)
    {
        this.dialogue = dialogue;
        index = 0;
        setText(); // Show the first line of text immediately
    }

    /**
     * Act - This method is called repeatedly.
     * I've added code here to check for a mouse click.
     */
    public void act() 
    {
        // When the user clicks on this dialogue box...
        if (Greenfoot.mouseClicked(this))
        {
            // ...show the next piece of text.
            nextText();
        }
    }    

    /**
     * --- This is the setText method from your suggested code ---
     * It creates the image with the current line of text.
     */
    private void setText()
    {
        // Creates a new image with the text
        setImage(new GreenfootImage(dialogue[index], 28, Color.BLACK, Color.WHITE));
    }
    
    /**
     * --- This is the nextText method from your suggested code ---
     * It moves to the next line of dialogue or removes the box if finished.
     */
    public void nextText()
    {
        // Move to the next index
        index++; 
        
        if (index < dialogue.length) 
        {
            // If there are more lines, show the next one
            setText();
        }
        else 
        {
            // If that was the last line, remove the dialogue box from the world
            getWorld().removeObject(this);
        }
    }
    public int getIndex()
    {
        return this.index;
    }
}
