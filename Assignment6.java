import java.util.Scanner;

public class Assignment6
{
    // 23. Created static Scanner/PatronList object 
    public static Scanner scan = new Scanner(System.in);
    public static PatronList patronList = new PatronList(); 

    // 34. Main method
    public static void main(String[] args)
    {
        System.out.println("Welcome to the CSE 110 Bank!");
        System.out.println(displayMenu());
        String choice = scan.nextLine(); 
        while(!choice.equals("e"))
        {
            if(choice.equals("a"))
            {
                System.out.println("Patrons currently at the bank:");
                System.out.println(patronList.displayInfo());
                System.out.println(displayMenu());
            }
            else if(choice.equals("b"))
            {
                System.out.println("What is the first name of the new patron?");
                String firstName = scan.nextLine();
                System.out.println("What is " + firstName + "'s last name?");
                String lastName = scan.nextLine(); 
                System.out.println("What is their yearly salary?");
                double salary = scan.nextDouble();
                System.out.println("How much cash do they have on hand?");
                double cashOnHand = scan.nextDouble();
                scan.nextLine();
                if(patronList.returnPatron(4) == null)
                {
                    System.out.println("Welcome to the bank, " + firstName + " " + lastName + "!");
                }
                patronList.addPatron(firstName, lastName, salary, cashOnHand);
                System.out.println(displayMenu());
            }
            // 37. Removing patron from PatronList
            else if(choice.equals("c"))
            {
                System.out.println("Type the full name of the patron you want.");
                String fullName = scan.nextLine();
                patronList.removePatron(fullName);
                System.out.println(displayMenu());
            }
            else if(choice.equals("d"))
            {
                System.out.println("Type the full name of the patron you want.");
                String fullName = scan.nextLine();
                if(patronList.getPatron(fullName) == null) 
                {
                    System.out.println("There is no patron by that name.");
                    System.out.println(displayMenu());
                }
                else
                {   
                    System.out.println("What do you want to do with " + fullName + "?");
                    patronMenuActions(patronList.getPatron(fullName));
                }
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }
            choice = scan.nextLine();
        }
        System.out.println("Thanks for coming. See you next time!\n\\(^o^)/");
    }
    // 24. Main menu method, accepts input, validates input, returns choice
    public static String displayMenu()
    {
        String menu =
            "a. List Patrons\n" +
            "b. Add New Patron\n" + 
            "c. Remove Patron\n" +
            "d. Patron Specific Actions\n" + 
            "e. Quit";
        return menu;
    }
    // 25. Patron menu 
    public static String patronMenu()
    {
        String menu =
            "a. Add New Account\n" + 
            "b. Close Account\n" + 
            "c. Get Paid\n" +
            "d. Apply Interest to Accounts\n" + 
            "e. Make Deposit\n" + 
            "f. Make Withdrawal\n" + 
            "g. Return to Main Menu";
        return menu; 
    }
    // 26. 3rd menu method for account type
    public static String accountTypeMenu()
    {
        String accountMenu = 
            "a. Checking\n" +
            "b. Savings\n" + 
            "c. CD\n" + 
            "d. Money Market\n" +
            "e. IRA";
        return accountMenu;
    }

    // 27. Void method that handles actions for the patron menu
    public static void patronMenuActions(BankPatron number)
    {
        System.out.println(patronMenu());
        String choice = scan.nextLine();
        while(!choice.equals("g"))
        {
            if(choice.equals("a"))
            {
                AccountType type = null; 
                double rate; 
                System.out.println("Which account type did you want?");
                System.out.println(accountTypeMenu());
                String accountTypeChoice = scan.nextLine();
                if(accountTypeChoice.equals("a"))
                {
                    type = AccountType.Checking;
                }
                else if(accountTypeChoice.equals("b"))
                {
                    type = AccountType.Savings;
                }
                else if(accountTypeChoice.equals("c"))
                {
                    type = AccountType.CD;
                }
                else if(accountTypeChoice.equals("d"))
                {
                    type = AccountType.MoneyMarket;
                }
                else if(accountTypeChoice.equals("e"))
                {
                    type = AccountType.IRA;
                }
                else
                {
                    System.out.println("Invalid choice.");
                    accountTypeChoice = scan.nextLine(); 
                }
                System.out.println("Please input the interest rate.");
                rate = scan.nextDouble();
                if(rate < 0)
                {
                    System.out.println("Why would you want a negative interest rate? Try again.");
                }
                else
                {
                    if(number.addAccount(rate, type) == true)
                    {
                        System.out.println("Account successfully added!");
                        System.out.println(patronMenu());
                    }
                    else
                    {
                        System.out.println("Sorry, you already have two accounts.");
                        System.out.println(patronMenu());
                    }
                }
                scan.nextLine();
            }
            else if(choice.equals("b"))
            {
                System.out.println("Which account (1 or 2) would you like to remove?");
                int choiceNum = scan.nextInt();
                scan.nextLine();
                if(choiceNum == 1)
                {
                    if(number.removeAccount(1) == true)
                    {
                        System.out.println("Account successfully removed!");
                    }
                }
                else if(choiceNum == 2)
                {
                    if(number.removeAccount(2) == true)
                    {
                        System.out.println("Account successfully removed!");
                    }
                }
                else
                {
                    System.out.println("Invalid account choice.");
                }
                System.out.println(patronMenu());
            }
            else if(choice.equals("c"))
            {
                number.getPaycheck();
                System.out.println("Here comes the money.");
                System.out.println(patronMenu());
            }
            else if(choice.equals("d"))
            { 
                if(number.getBankAccount(1) != null)
                {
                    number.getBankAccount(1).applyInterest();
                    System.out.println("Interest applied to account 1!");
                }
                if(number.getBankAccount(2) != null)
                {
                    number.getBankAccount(2).applyInterest();
                    System.out.println("Interest applied to account 2!");
                }
                else
                {
                    System.out.println("You have no accounts to apply interest to.");
                }
                System.out.println(patronMenu());
            }
            else if(choice.equals("e"))
            {
                System.out.println("Which account (1 or 2) would you like to deposit money in?");
                int accountNum = scan.nextInt();
                scan.nextLine();
                if(accountNum == 1)
                {
                    if(number.getBankAccount(1) != null)
                    {
                        System.out.println("How much money would you like to deposit?");
                        double depositAmount = scan.nextDouble();
                        scan.nextLine();
                        if(number.makeDeposit(1, depositAmount) == true)
                        {
                            System.out.println("Cha-ching! Money deposited successfully!");
                        }
                        else
                        {
                            System.out.println("You don't have enough cash on hand.");
                        }
                        System.out.println(patronMenu());
                    }   
                    else
                    {
                        System.out.println("Account doesn't exist.");
                        System.out.println(patronMenu());
                    }
                }
                else if(accountNum == 2)
                {
                    if(number.getBankAccount(2) != null)
                    {
                        System.out.println("How much money would you like to deposit?");
                        double depositAmount = scan.nextDouble(); 
                        scan.nextLine();
                        if(number.makeDeposit(2, depositAmount) == true)
                        {
                            System.out.println("Cha-ching! Money deposited successfully!");
                        }
                        else
                        {
                            System.out.println("You don't have enough cash on hand.");
                        }
                        System.out.println(patronMenu());
                    }
                    else
                    {
                        System.out.println("Account doesn't exist.");
                        System.out.println(patronMenu());
                    }
                }
                else
                {
                    System.out.println("Wrong account choice. Try again.");
                    accountNum = scan.nextInt();
                }
            }
            else if(choice.equals("f"))
            {
                System.out.println("Which account (1 or 2) would you like to withdraw money from?");
                int accountNum = scan.nextInt();
                scan.nextLine();
                if(accountNum == 1)
                {
                    if(number.getBankAccount(1) != null)
                    {
                        System.out.println("How much money would you like to withdraw?");
                        double withdrawAmount = scan.nextDouble();
                        scan.nextLine();
                        if(number.makeWithdrawal(1, withdrawAmount) == true)
                        {
                            System.out.println("Cha-ching! Money withdrawn successfully!");
                        }
                        else
                        {
                            System.out.println("You don't have enough cash in the bank.");
                        }
                    }   
                    else
                    {
                        System.out.println("Account doesn't exist.");
                    }
                    System.out.println(patronMenu());
                }
                else if(accountNum == 2)
                {
                    if(number.getBankAccount(2) != null)
                    {
                        System.out.println("How much money would you like to withdraw?");
                        double withdrawAmount = scan.nextDouble();
                        scan.nextLine();
                        if(number.makeWithdrawal(2, withdrawAmount) == true)
                        {
                            System.out.println("Cha-ching! Money withdrawn successfully!");
                        }
                        else
                        {
                            System.out.println("You don't have enough cash on hand.");
                        }
                    }
                    else
                    {
                        System.out.println("Account doesn't exist.");
                    }
                    System.out.println(patronMenu());
                }
                else
                {
                    System.out.println("Wrong account choice. Try again.");
                    accountNum = scan.nextInt();
                }    
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
                System.out.println(patronMenu());
            }
            choice = scan.nextLine();
        }
        System.out.println(displayMenu());
    }
}