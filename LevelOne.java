import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World 
{
    public ProgressBar progress;
    private CustomerDialogue1 tutorialBox;
    private boolean customerHasSpawned = false;
    public int TargetBurgers = 0;
    public int TargetFries = 0;
    public int TargetDrink = 0;
    public Clipboard clipboard; // world-level clipboard variable
    private int[] targetOrder = { 1, 2, 1 }; // example target: 1 burger, 2 fries, 1 drink

    public LevelOne()
    {
        super(600, 400, 1);
        setBackground("JobBackground.png");

        progress = new ProgressBar(400, 20, 100);
        addObject(new Cashier(), 400, 200);
        addObject(progress, getWidth()/2, getHeight() - 20);

        // Assign to the world variable (not a local one!)
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
        addObject(tutorialBox, getWidth()/2, 100); // moved higher
    }

    public void act()
    {
        // Spawn customer after tutorial step 2
        if (!customerHasSpawned && tutorialBox.getWorld() != null && tutorialBox.getIndex() == 2)
        {
            spawnCustomer();
            customerHasSpawned = true;
        }

        // Make sure clipboard exists before using it
        if (clipboard != null) {
            int[] orders = clipboard.getOrder();
            System.out.println("Burger: " + orders[0] + ", Fries: " + orders[1] + ", Drink: " + orders[2]);

            // Compare to target order
            boolean correct = true;
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] != targetOrder[i]) {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                System.out.println("Order matches the target! ✅");
            } else {
                System.out.println("Order does NOT match the target. ❌");
            }
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
