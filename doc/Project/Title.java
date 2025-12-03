import greenfoot.*;  

public class Title extends Actor
{
    private GreenfootImage originalImage;
    private double scaleFactor = 1.0;
    private double scaleDirection = 0.002;
    private int baseWidth = 450;
    private int baseHeight = 50;

    public Title() {
        originalImage = new GreenfootImage("ClimberTitle.png");
        originalImage.scale(baseWidth, baseHeight);
        setImage(originalImage);
    }

    public void act()
    {
        scaleFactor += scaleDirection;

        if (scaleFactor > 1.2 || scaleFactor < 0.8) {
            scaleDirection *= -1;
        }

        int newWidth = (int)(baseWidth * scaleFactor);
        int newHeight = (int)(baseHeight * scaleFactor);

        GreenfootImage scaledImage = new GreenfootImage(originalImage);
        scaledImage.scale(newWidth, newHeight);
        setImage(scaledImage);
    }
}
