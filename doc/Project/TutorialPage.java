import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialPage extends Actor
{private static int currentPage = 1; // Static to remember the page across worlds/resets (or use a World variable)
    private final int MAX_PAGES = 3;

    public TutorialPage() {
        // Draw the current page content when the actor is created
        drawPageContent(currentPage);
    }

    public void drawPageContent(int pageNumber) {
        GreenfootImage img = new GreenfootImage(400, 250);
        img.setColor(new Color(200, 200, 200));
        img.fillRect(0, 0, 400, 250);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", 11));

        // Use a switch statement to decide what text to display
        switch (pageNumber) {
            case 1:
                img.drawString("Hello Future CEO! This is a how to guide on how to play Corprate Climber!...", 20, 40);
                img.drawString("Click Next to continue.", 20, 60);
        
                
                break;
            case 2:
                img.drawString("The Goal is to make as much profit as possible and rise through the ranks!.", 20, 40);

                img.drawString("Manage your employees, invest wisely, and crush the competition.", 20, 60);
                img.drawString("", 20, 70);

                img.drawString("You will have 4 options to choose from with each scenrio...",20,80);
                img.drawString("Each option will either increase or decrease your progression bar!",20,100);

                break;
            case 3:
                img.drawString(" Ready to start your Corporate Climb? Good luck!", 20, 40);
                // You might change the 'Next' button to a 'Start Game' button here
                break;
            default:
                img.drawString("Tutorial Complete.", 20, 40);
        }

        img.drawRect(0, 0, 400, 250);
        setImage(img);
        
        // Update the PageDots
        if (getWorld() != null) {
             //((TutorialMenu)getWorld()).updateDots(pageNumber);
        }
    }
    
    // Method to advance the page (called by NextButton)
    public void nextPage() {
        if (currentPage < MAX_PAGES) {
            currentPage++;
            drawPageContent(currentPage); // Redraw the image with new content
        
} else {
            // Optional: Start the main game when tutorial is over
            // Greenfoot.setWorld(new MainGameWorld()); 
        }
    }
    
    public void previousPage() {
        if(currentPage > 1) {
            currentPage--;
            drawPageContent(currentPage); // Redraw the image with new content
        }
    }
    
    
    // Reset page for when the world is created (if needed)
    public static void resetPage() {
        currentPage = 1;
    }
}
