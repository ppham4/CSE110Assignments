import java.util.Scanner;

public class Assignment7
{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        // 16.
        System.out.println("Welcome to the String searcher!");
        String choice = mainMenu();
        // 17. 
        MyString object = new MyString(); 
        // 18. 
        while(!choice.equals("d"))
        {
            // 19. 
            if(choice.equals("a"))
            {
                System.out.println("Please enter the searchable String:");
                String searchableString = scan.nextLine();
                System.out.println("Set \"" + searchableString + "\" as the searchable String.");
                object = new MyString(searchableString);
            }
            // 20. 
            else if(choice.equals("b"))
            {
                System.out.println(object.toString());
            }
            // 21. 
            else if(choice.equals("c"))
            {
                searchString(object);
            }
            else
            {
                break;
            }
            choice = mainMenu();
        }
        System.out.println("See you next time!"); 
    }

    // 12.
    private static String mainMenu()
    {
        System.out.println(
            "What would you like to do?\n" + 
            "a. Create a Searchable String\n" +
            "b. Print the current Searchable String\n" + 
            "c. Search within the String\n" +
            "d. Quit");
        String choice = scan.nextLine();
        while(!choice.equals("a") && !choice.equals("b") && !choice.equals("c") && !choice.equals("d"))
        {
            System.out.println("Invalid choice.");
            choice = scan.nextLine();
        }
        return choice; 
    }

    // 13.
    private static void searchString(MyString object)
    {
        // 14. 
        System.out.println("What String do you want to search for?");
        String searchString = scan.nextLine();
        // 15(a-e);
        if(object.equals1(searchString) == true)
        {
            System.out.println("Your search is identical to the String.");
        }
        else if(object.contains1(searchString) == true)
        {
            if(object.startsWith1(searchString) == true)
            {
                System.out.println("Your search was found at the beginning of the String.");
            }
            else if(object.endsWith1(searchString) == true)
            {
                System.out.println("Your search was found at the end of the String."); 
            }
            else
            {
                System.out.println("Your search was found starting at index " + object.indexOf1(searchString) + " in the String.");
            }
        }
        else
        {
            System.out.println("Your search was not found in the String."); 
        }
    }
}