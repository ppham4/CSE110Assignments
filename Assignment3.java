import java.util.Scanner;

public class Assignment3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number. Type 0 to quit.");
        double number = scan.nextDouble();
        int counter = 0;
        double sum = 0;
        double max = number;
        double min = number;
        while(number != 0)
        {
            System.out.println("Please enter a number. Type 0 to quit.");
            counter++;
            sum += number;
            if(number > max)
            {
                max = number;
            }
            if(number < min)
            {
                min = number;
            }
            number = scan.nextDouble();
        } 
        if(counter > 1)
        {
            System.out.println("Sum of inputs: " + sum);
            System.out.println("Total number of inputs: " + counter);
            System.out.println("Input average: " + (sum / counter));
            System.out.println("Highest input: " + max);
            System.out.println("Lowest input: " + min);
        }
        else
        {
            System.out.println("You didn't type anything in.");
        }
    }
}
