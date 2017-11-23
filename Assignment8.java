import java.util.Scanner;

public class Assignment8
{
    public static void main(String[] args)
    {
        BattleShipGrid grid = new BattleShipGrid();
        boolean player1Turn = true;
        Scanner scan = new Scanner(System.in);
        String input;
        String[] coordinates;
        int x;
        int y;
        int fire;
        
        System.out.println("Welcome to BattleShip!");
        System.out.println("0 means unknown ocean, 1 means you shot there and missed,");
        System.out.println("2 is a ship, and 3 is a ship that's been hit.");
        System.out.println("The top left corner is 0 0, and the bottom right is 4 4");
        
        // Loop that will run until one player or the other has won
        // 1. Changed || to &&
        while(!grid.playerOneWon() && !grid.playerTwoWon())
        {
            if(player1Turn)
            {
                System.out.println("\nPlayer 1: Type in the spot to shoot at as \"X Y\"");
                System.out.println("\n" + grid.printP1Fire());
            }
            else
            {
                System.out.println("\nPlayer 2: Type in the spot to shoot at as \"X Y\"");
                System.out.println("\n" + grid.printP2Fire());
            }
            
            // Handle player input and split it from one line into two numbers
            input = scan.nextLine();
            coordinates = input.split(" ");
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);
            
            // 2. Changed grid.fireAtPlayerOne for player1Turn to grid.fireAtPlayerTwo
            if(player1Turn)
            {
                fire = grid.fireAtPlayerTwo(x, y);
            }
            else
            {
                fire = grid.fireAtPlayerOne(x, y);
            }
            
            if(fire == 0)
            {
                System.out.println("Miss!");
            }
            else if(fire == 2)
            {
                System.out.println("=====================================");
                System.out.println("Hit!");
                if(player1Turn)
                {
                    System.out.println(grid.printP1Fire());
                }
                else
                {
                    System.out.println(grid.printP2Fire());
                }
                System.out.println("=====================================");
            }
            else
            {
                System.out.println("You already shot there!");
            }
            
            player1Turn = !player1Turn;
        }
        
        if(grid.playerOneWon())
        {
            System.out.println("Player 1 is the winner!");
        }
        else
        {
            System.out.println("Player 2 is the winner!");
        }
    }
}