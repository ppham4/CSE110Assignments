import java.util.Scanner;

public class Assignment4
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please type in the height of the pyramid.");
        System.out.println("It must be at least 1 high and no more than 25 high.");
        int height = scan.nextInt(); 
        while(height < 1 || height > 25)
        {
            System.out.println("Invalid height. Please try again.");
            height = scan.nextInt();
        }
        System.out.println("Would you like a diamond instead of a pyramid?");
        System.out.println("Type Yes or No.");
        String yesNo;
        boolean yN = true;
        while(yN)
        {
            yesNo = scan.next();
            if(yesNo.equals("Yes"))
            {
                System.out.println("Printing a diamond instead with a height of " + (height + (height - 1)) + ".");
                for(int i = 0; i < height; i++)
                {
                    for(int k = height - 1; k > i; k--)
                    {
                        System.out.print(" ");
                    }
                    for(int j = 0; j <= 2*i; j++)
                    {
                        System.out.print("*");    
                    }
                    System.out.println();
                }
                for(int i = 0; i < height; i++)
                {
                    for(int k = 0; k <= i; k++)
                    {
                        System.out.print(" ");
                    }
                    for(int j = 2 * (height - 1); j / 2 > i; j--)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            }
            else if(yesNo.equals("No"))
            {
                System.out.println("Printing a pyramid with height " + height + ".");
                for(int i = 0; i < height; i++)
                {
                    for(int k = height - 1; k > i; k--)
                    {
                        System.out.print(" ");
                    }
                    for(int j = 0; j <= 2*i; j++)
                    {
                        System.out.print("*");    
                    }
                    System.out.println();
                }   
                break;
            }
            else
            {
                System.out.println("Invalid input. Please try again.");
                yesNo = scan.nextLine(); 
            }
        }             
    }
}