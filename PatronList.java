// 14. Create a new PatronList class which has 5 private instance variables
public class PatronList
{
    private BankPatron one;
    private BankPatron two;
    private BankPatron three;
    private BankPatron four;
    private BankPatron five;

    // 15. Create a default constructor, setting all patrons to null
    public PatronList()
    {
        one = null;
        two = null;
        three = null;
        four = null;
        five = null; 
    }

    // 16. Create an int method that returns an int representing the first null patron
    public int returnSlot()
    {
        if(one == null)
        {
            return 0;
        }
        if(two == null)
        {
            return 1;
        }
        if(three == null)
        {
            return 2;
        }
        if(four == null)
        {
            return 3;
        }
        if(five == null)
        {
            return 4;
        }
        return -1;
    }

    // 17. Boolean method to add new patron
    public boolean addPatron(BankPatron patron)
    {
        if(one == null)
        {
            one = patron;
            return true;
        }
        else if(one != null && two == null)
        {
            two = patron;
            return true;
        }
        else if(two != null && three == null)
        {
            three = patron;
            return true;
        }
        else if(three != null && four == null)
        {
            four = patron;
            return true; 
        }
        else if(four != null && five == null)
        {
            five = patron;
            return true;
        }
        else
        {
            System.out.println("Sorry, the line at the bank is full!");
            return false; 
        }
    }
    
    // 18. Overload method 
    public boolean addPatron(String firstName, String lastName, double salary, double cashOnHand)
    {
        return addPatron(new BankPatron(firstName, lastName, salary, cashOnHand));
    }
    
    // 19. Method that returns patron specified
    public BankPatron returnPatron(int param) 
    {
        if(param == 0)
        {
            return one; 
        }
        if(param == 1)
        {
            return two; 
        }
        if(param == 2)
        {
            return three;
        }
        if(param == 3) 
        {
            return four;
        }
        if(param == 4)
        {
            return five; 
        }
        return null; 
    }

    // 20. Method accepting patron's full name 
    public BankPatron getPatron(String fullName)
    {
        if(one != null && one.getFullName().equals(fullName))
        {
            return one;
        }
        if(two != null && (fullName).equals(two.getFullName()))
        {
            return two;
        }
        if(three != null && (fullName).equals(three.getFullName()))
        {
            return three;
        }
        if(four != null && (fullName).equals(four.getFullName()))
        {
            return four;
        }
        if(five != null && (fullName).equals(five.getFullName()))
        {
            return five;
        }
        return null;
    }

    // 21. Boolean method that removes patron from bank
    public boolean removePatron(String fullName)
    {
        if(one != null && fullName.equals(one.getFullName()))
        {
            System.out.println(fullName + " was violently kicked out of the bank.");
            one = null;
            return true;
        }
        if(two != null && fullName.equals(two.getFullName()))
        {
            System.out.println(fullName + " was violently kicked out of the bank.");
            two = null;
            return true;
        }
        if(three != null && fullName.equals(three.getFullName()))
        {
            System.out.println(fullName + " was violently kicked out of the bank.");
            three = null;
            return true;
        }
        if(four != null && fullName.equals(four.getFullName()))
        {
            System.out.println(fullName + " was violently kicked out of the bank.");
            four = null; 
            return true;
        }
        if(five != null && fullName.equals(five.getFullName()))
        {
            System.out.println(fullName + " was violently kicked out of the bank.");
            five = null; 
            return true;
        }
        else 
        {
            System.out.println("There is no patron by that name.");
            return false; 
        }
    }
    
    public String displayInfo()
    {
        String info = "";
        if(one == null && two == null && three == null && four == null && five == null)
        {
            info += "None";
        }
        if(one != null && two != null)
        {
            info += one.displayBankInfo() + "\n";
        }
        else if(one != null && two == null && three == null && four == null)
        {
            info += one.displayBankInfo();
        }
        if(two != null && three != null)
        {
            info += two.displayBankInfo() + "\n";
        }
        else if(two != null && three == null && four == null && five == null)
        {
            info += two.displayBankInfo();
        }
        if(three != null && four != null)
        {
            info += three.displayBankInfo() + "\n";
        }
        else if(three != null && four == null && five == null)
        {
            info += three.displayBankInfo();
        }
        if(four != null && five != null) 
        {
            info += four.displayBankInfo() + "\n";
        }
        else if(four != null && five == null)
        {
            info += four.displayBankInfo();
        }
        if(five != null)
        {
            info += five.displayBankInfo();
        }
        return info;
    }
}