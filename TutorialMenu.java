import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class TutorialMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialMenu extends World
{
    private List<PageDot> dots;
   
    public TutorialMenu(){
        super(600, 400, 1);
        addObject(new MenuBackground(), 300, 200); // Burger BackRound


        addObject(new Title(), 300, 60); // Corprate Climber Title

        addObject(new TutorialPage(), 300, 220);//Grey Box

        addObject(new BackButton(), 55, 220); // Left Arrow Button
        addObject(new NextButton(), 550, 220);  // Right Arrow Button
        
    PageDot dot1 = new PageDot(20, Color.WHITE); // first page active
    PageDot dot2 = new PageDot(20, Color.GRAY);
    PageDot dot3 = new PageDot(20, Color.GRAY);


        addObject(dot1, 200, 370);
        addObject(dot2, 285, 370);
        addObject(dot3, 370, 370);
        
    }public void updateDots(int currentPage) {
        // Loop through the list of dots
        for (int i = 0; i < dots.size(); i++) {
            PageDot dot = dots.get(i);
            // The dot at index 'i' corresponds to page number 'i + 1'
            if (i + 1 == currentPage) {
                dot.setColor(Color.WHITE); // Active page is WHITE
            } else {
                dot.setColor(Color.GRAY);
    }

}
}
}
