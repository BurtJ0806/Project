import greenfoot.*;  

public class Clipboard extends Actor
{
    private GreenfootImage originalImage;
    private boolean toggled = false;
    private boolean animating = false;

    private int startX;
    private int targetX;

    private int currentWidth;
    private int targetWidth;

    private int moveSpeed = 2;
    private int scaleSpeed = 4;
    
    public int Burger = 0;
    public int Fries = 0;
    public int Drink = 0;

    private String[] options = {"Big Burger", "Big Fries", "Big Drink"};  // Options to display
    private int selectedOption = -1; 
    



    public Clipboard() {
        originalImage = new GreenfootImage("Clipboard.png");
        currentWidth = 1;
        int startHeight = (originalImage.getHeight() * currentWidth) / originalImage.getWidth();

        GreenfootImage image = new GreenfootImage(originalImage);
        image.scale(currentWidth, startHeight);
        setImage(image);
    }

    protected void addedToWorld(World world) {
        startX = getX();
        targetX = startX + 200;
    }

    public void act() {
        if (Greenfoot.isKeyDown("space") && !animating) {
            animating = true;

            if (!toggled) {
                targetWidth = 200;
                targetX = startX + 200;
            } else {
                targetWidth = 1;
                targetX = startX;
            }

            toggled = !toggled;
        }

        if (animating) {
            updateMovement();
            updateImage();
        }

        
        checkClicks();
    }

    private void updateMovement() {
        if (getX() < targetX) {
            setLocation(Math.min(getX() + moveSpeed, targetX), getY());
        } else if (getX() > targetX) {
            setLocation(Math.max(getX() - moveSpeed, targetX), getY());
        }

        if (currentWidth < targetWidth) {
            currentWidth = Math.min(currentWidth + scaleSpeed, targetWidth);
        } else if (currentWidth > targetWidth) {
            currentWidth = Math.max(currentWidth - scaleSpeed, targetWidth);
        }

        if (getX() == targetX && currentWidth == targetWidth) {
            animating = false;
        }
    }

    private void updateImage() {
        int newHeight = (originalImage.getHeight() * currentWidth) / originalImage.getWidth();
        GreenfootImage image = new GreenfootImage(originalImage);
        image.scale(currentWidth, newHeight);

        // --- DRAW OPTIONS ---
        image.setFont(new Font("Arial", true, false, 18)); 

        int y = 80; // Starting Y-coordinate
        for (int i = 0; i < options.length; i++) {
            if (i == selectedOption) {
                image.setColor(Color.RED); // Highlight selected option
            } else {
                image.setColor(Color.BLACK);
            }
            image.drawString(options[i], 60, y); // X = 60
            y += 30; // Space between options
        }

        setImage(image);
    }

    private void checkClicks() {
        if (Greenfoot.mouseClicked(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null) return; // Safety check

            int relativeY = mouse.getY() - (getY() - getImage().getHeight() / 2);

            int yStart = 80; // Same as updateImage()
            int optionHeight = 30;

            for (int i = 0; i < options.length; i++) {
                int optionTop = yStart + i * optionHeight - 18;
                int optionBottom = yStart + i * optionHeight + 5;

                if (relativeY >= optionTop && relativeY <= optionBottom) {
                    selectedOption = i;
                    System.out.println("Clicked: " + options[i]);
                    handleSelection(); // <-- CALL SWITCH METHOD HERE
                }
            }
            updateImage();
        }
    }

    // --- SWITCH HANDLER FOR OPTIONS ---
    private void handleSelection() {
        String option = getSelectedOptionText();
        if (option == null) return;

        switch (option) {
            case "Big Burger":
                Burger = Burger + 1;
                break;

            case "Big Fries":
                Fries = Fries + 1;
                break;

            case "Big Drink":
                Drink = Drink + 1;
                break;

            default:
                break;
        }
    }

    // Change the displayed options
    public void setTextOptions(String[] newOptions) {
        options = newOptions;
        updateImage();
    }

    // Get the index of the selected option
    public int getSelectedOption() {
        return selectedOption;
    }

    // Get the text of the selected option
    public String getSelectedOptionText() {
        if (selectedOption >= 0 && selectedOption < options.length)
            return options[selectedOption];
        return null;
    }
    public int[] getOrder() {
        return new int[] { Burger, Fries, Drink };
    }

}
