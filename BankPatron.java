public class BankPatron
{
    private String firstName;
    private String lastName;
    private double salary; 
    private double cashOnHand;
    private BankAccount one;
    private BankAccount two;

    // 5. Create a default and regular constructor
    public BankPatron()
    {
        firstName = ""; 
        lastName = "";
        salary = 0.0;
        cashOnHand = 0.0;
        one = null;
        two = null;
    }

    public BankPatron(String firstName, String lastName, double salary, double cashOnHand)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cashOnHand = cashOnHand;
        one = null;
        two = null;
    }

    // 6. Method that returns the full name of the patron
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    // 7. Get for salary and cash on hand
    public double getSalary()
    {
        return salary; 
    }

    public double getCashOnHand()
    {
        return cashOnHand;
    }

    // 8. Void method that gives the patron a pay check
    public void getPaycheck()
    {
        cashOnHand += (salary / 26); 
    }

    // 9. Method that gets the specified BankAccount
    public BankAccount getBankAccount(int accountNum)
    {
        if(accountNum == 1)
        {
            return one;
        }
        else if(accountNum == 2)
        {
            return two;
        }
        else
        {
            System.out.println("Invalid account choice."); 
            return null;
        }
    }

    // 10. boolean deposit method  
    public boolean makeDeposit(int accountNumber, double depositAmount)
    {
        if(accountNumber == 1 && one != null)
        {
            if(depositAmount <= cashOnHand)
            {
                one.deposit(depositAmount);
                cashOnHand -= depositAmount;
                return true; 
            }
            else
            {
                return false;
            }
        }
        if(accountNumber == 2 && two != null)
        {
            if(depositAmount <= cashOnHand)
            {
                two.deposit(depositAmount);
                cashOnHand -= depositAmount;
                return true;
            }
            else
            {
                return false;
            }
        }
        return false; 
    }

    // 11. boolean withdrawal method
    public boolean makeWithdrawal(int accountNumber, double withdrawAmount)
    {
        if(accountNumber == 1 && one != null)
        {
            if(one.withdraw(withdrawAmount) == true)
            {
                cashOnHand += withdrawAmount;
                return true;
            }
        }
        if(accountNumber == 2 && two != null)
        {
            if(two.withdraw(withdrawAmount) == true)
            {
                cashOnHand += withdrawAmount;
                return true;
            }
        }
        System.out.println("Invalid account number.");
        return false;
    }  

    // 12. Boolean method that adds account to the patron 
    public boolean addAccount(double rate, AccountType type)
    {
        if(one == null)
        {
            one = new BankAccount(this.firstName, this.lastName, rate, type);
            return true;
        }
        else if(two == null)
        {
            two = new BankAccount(this.firstName, this.lastName, rate, type); 
            return true; 
        }
        else 
        {
            return false;
        }
    }

    // 13. Boolean method to remove bank account
    public boolean removeAccount(int accountNum)
    {
        if(accountNum == 1 && one != null)
        {
            one = null;
            return true;
        }
        else if(accountNum == 1 && one == null)
        {
            System.out.println("You don't have an account to remove.");
            return false;
        }
        if(accountNum == 2 && two != null) 
        {
            two = null; 
            return true;
        }
        else if(accountNum == 2 && two == null)
        {
            System.out.println("You don't have an account to remove.");
            return false;
        }
        System.out.println("You can only delete account 1 or 2.");
        return false;
    }

    public String displayBankInfo()
    {
        String patronInfo = getFullName() + " ";
        if(one != null)
        {
            patronInfo += one.getType() + " " + one.getAccountNum() + " Balance: $" + one.checkBalance() + " Interest Rate: " + one.getRate() + "\n";
        }
        if(two != null)
        {
            patronInfo += two.getType() + " " + two.getAccountNum() + " Balance: $" + two.checkBalance() + " Interest Rate: " + two.getRate();
        }
        return patronInfo;
    }
}