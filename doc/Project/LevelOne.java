import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World 
{
    public ProgressBar progress;
    private CustomerDialogue1 tutorialBox;
    private boolean customerHasSpawned = false;

    public int TargetBurgers = 0;
    public int TargetFries = 0;
    public int TargetDrink = 0;

    public Clipboard clipboard;  

    // Expected order (burgers, fries, drinks)
    private int[] targetOrder = { 1, 0, 0 };

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


    }

    public void act()
    {
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
        if (clipboard == null) return;

        int[] orders = clipboard.getOrder();
        if (orders == null || orders.length != targetOrder.length) return;

        correct = true;

        for (int i = 0; i < orders.length; i++)
        {
            if (orders[i] != targetOrder[i])
            {
                correct = false;
                break;
            }
        }

        // Only print when the state changes
        if (correct != lastCorrectState)
        {
            lastCorrectState = correct;

            if (correct)
                System.out.println("Order Is Good!");
            else
                System.out.println("Order Is WRONG!");
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
