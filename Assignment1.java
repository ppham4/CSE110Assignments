import java.util.Scanner;
/** 
 * Purpose of assignment:
 * Write a program that will compute whether a cannonball will hit its target or not
 */
public class Assignment1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the velocity of the cannonball:");
        double velocity = scan.nextDouble();
        if(velocity > 0)
        {
            System.out.println("Enter the angle that the cannonball will be shot at:");
            double angle = scan.nextDouble();
            System.out.println("Enter the distance from the cannon to the target:");
            double distance = scan.nextDouble();
            System.out.println("Enter how high the bottom of the target is from the ground:");
            double elevation = scan.nextDouble();
            System.out.println("Enter the size of the target:");
            double size = scan.nextDouble();
            double time = distance / (velocity * (Math.cos(Math.toRadians(angle))));
            double timesquared = time * time;
            double timesintheta = time * (Math.sin(Math.toRadians(angle)));
            double gravity = 32.17;
            double height = ((velocity * timesintheta) - ((1.0 / 2.0) * (gravity * timesquared)));
            System.out.println("Generating results...Please wait.\nCalculations complete."); 
            if(height >= elevation && height <= (elevation + size))
            {
                System.out.println("HIT!");
                System.out.println("The target height was from " + (elevation) + " feet to " + (elevation + size) + " feet. You hit the target at " + (height) + " feet.");
            }
            if(height > (elevation + size))
            {
                System.out.println("Too far! The cannonball went " + (height - (elevation+size)) + " feet over the target.");
            }
            if(height > 0 && height < elevation)
            {
                System.out.println("Darn! Almost there.");
                System.out.println("You were " + (elevation - height) + " feet short of the target.");
            }
            if(height < 0)
            {
                System.out.println("Not quite there yet. The cannonball did not make it to the target - try to increase your velocity.");
            }
            if(velocity == 0)
            {
                System.out.println("You cannot hit the target if you don't launch the cannonball.\nTry again with a velocity greater than 0.");
            }
        }
        else
        {
            System.out.println("The target cannot be hit if the cannonball's velocity is less than or equal to 0.");
        }
        if(velocity == 0)
        {
            System.out.println("How do you expect to hit the target if your velocity is 0?");
        } 
    }
}