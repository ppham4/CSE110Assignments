import java.util.Scanner;

// This is the main class for Assignment 5
public class Assignment5
{
    /*
     * This goes here because it is used by multiple methods.
     * Main MUST be static, and because you can only reference
     * static methods and variables from static context, all of
     * the methods and class wide variables must be static as well.
     * Scan cannot be an instance variable.
     */
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        /*
         * Because these are within main, they do not
         * need to be static. However, they cannot be
         * seen by other methods when created here.
         */
        Pet petOne = new Pet("Fido", 3);
        Pet petTwo = new Pet("Furball", 1);
        Pet petThree = null; // Remember what null means and does
        
        System.out.println("Welcome to the pet store!");
        String input = mainMenu();
        while(!input.equals("E")) // Main loop
        {
            switch(input)
            {
                case "A":
                    printPet(petOne);
                    printPet(petTwo);
                    if(petThree != null) // You will have to check this whenever you use petThree to avoid a NullPointerException
                    {
                        printPet(petThree);
                    }
                    break;
                case "B":
                    petOne.ageUp();
                    petTwo.ageUp();
                    if(petThree != null)
                    {
                        petThree.ageUp();
                    }
                    System.out.println("Everyone just got a little older.");
                    break;
                case "C":
                    if(petThree != null)
                    {
                        System.out.println("Sorry, the store is full.");
                    }
                    else
                    {
                        System.out.println("Please type in a name.");
                        input = scan.nextLine(); // Recycle your variables
                        System.out.println("Type in an age");
                        int petAge = scan.nextInt();
                        scan.nextLine(); // Flush
                        petThree = new Pet(input, petAge);
                        System.out.println(input + " has arrived in the store.");
                    }
                    break;
                case "D":
                    adopt(petOne, petTwo, petThree); // Because the pets are local variables, we need to pass them in order to use them in another method
                    break;
                default: // This SHOULD never trigger, but you never know.
                    break;
            }
            input = mainMenu(); // Fresh input
        }
        System.out.println("Have a good day!");
    }
    
    // Prints out the main menu and returns the user's validated input
    private static String mainMenu()
    {
        System.out.println("Type the letter to make your selection.");
        System.out.println("A. List the pets in the store.");
        System.out.println("B. Age up the pets.");
        System.out.println("C. Add a new pet.");
        System.out.println("D. Adopt a pet.");
        System.out.println("E. Quit");
        String choice = scan.nextLine();
        // Sorry this while condition ends up being ugly
        while(!choice.equals("A") && !choice.equals("B") && !choice.equals("C")
            && !choice.equals("D") && !choice.equals("E"))
        {
            System.out.println("Invalid choice");
            choice = scan.nextLine();
        }
        return choice; // Because this method is of type String, we MUST return a String value
    }
    
    private static void printPet(Pet pet)
    {
        String adopted = "";
        if(!pet.isAdopted())
        {
            adopted = " not";
        }
        String years = " years";
        if(pet.getAge() == 1)
        {
            years = " year";
        }
        System.out.println(pet.getName() + " is " + pet.getAge() + years + " old and is" + adopted + " adopted.");
        // This method is of type void, like main, so it CANNOT return any value
    }
    
    private static void adopt(Pet petOne, Pet petTwo, Pet petThree)
    {
        System.out.println("Type the number of the pet you would like to adopt.\nThe number is the order they appear in the list.");
        int pet = scan.nextInt();
        scan.nextLine(); // Flush
        switch(pet)
        {
            case 1: // You could convert these into method calls
                if(petOne.isAdopted())
                {
                    System.out.println("Sorry, " + petOne.getName() + " already has a furever home.");
                }
                else
                {
                    petOne.adopt();
                    System.out.println(petOne.getName() + " was adopted!");
                }
                break;
            case 2:
                if(petTwo.isAdopted())
                {
                    System.out.println("Sorry, " + petTwo.getName() + " already has a furever home.");
                }
                else
                {
                    petTwo.adopt();
                    System.out.println(petTwo.getName() + " was adopted!");
                }
                break;
            case 3:
                if(petThree != null)
                {
                    if(petThree.isAdopted())
                    {
                        System.out.println("Sorry, " + petThree.getName() + " already has a furever home.");
                    }
                    else
                    {
                        petThree.adopt();
                        System.out.println(petThree.getName() + " was adopted!");
                    }
                    break; // Note that this is inside the if!
                }
                // Here is a place where fall through can work for you.
            default:
                System.out.println("That is not a valid pet.");
                break;
        }   
    }
}