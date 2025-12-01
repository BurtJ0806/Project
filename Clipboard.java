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
        if (Greenfoot.isKeyDown("left") && !animating) {
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

            int newHeight = (originalImage.getHeight() * currentWidth) / originalImage.getWidth();
            GreenfootImage image = new GreenfootImage(originalImage);
            image.scale(currentWidth, newHeight);
            setImage(image);

            if (getX() == targetX && currentWidth == targetWidth) {
                animating = false;
            }
        }
    }
}
