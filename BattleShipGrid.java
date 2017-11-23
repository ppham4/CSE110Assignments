public class BattleShipGrid
{
    /*
     * Both players have two arrays, one called grid and one called fire.
     * The one called grid holds their ship and is where the other player
     * fires on. The fire array is the one that player sees during the game
     * and it shows where their shots land and where they've hit the enemy
     * ship.
     */
    private int[][] p1Grid; // Player 1's board which contains their ship
    private int[][] p1Fire; // This is what Player 1 sees and where their shots appear
    
    private int[][] p2Grid; // This would be the bottom grid in actual Battleship for Player 2
    private int[][] p2Fire; // And this would be their top grid

    // Constants for what each int represents in the arrays
    private final int EMPTY = 0;
    private final int MISS = 1;
    private final int SHIP = 2;
    private final int HIT = 3;

    public BattleShipGrid() // Don't change this
    {
        p1Grid = new int[5][5];
        p1Fire = new int[5][5];
        p2Grid = new int[5][5];
        p2Fire = new int[5][5];

        p1Grid[1][0] = SHIP;
        p1Grid[2][0] = SHIP;
        p1Grid[3][0] = SHIP;

        p2Grid[4][2] = SHIP;
        p2Grid[4][3] = SHIP;
        p2Grid[4][4] = SHIP;
    }

    public String printP1Fire() // This is the method to fix for Step 3
    {
        String out = "";
        for(int i = 0; i < p1Fire[0].length; i++)
        {
            for(int j = 0; j < p1Fire.length; j++)
            {
                // 3. Changed p2Grid[j][i] to p1Fire[j][i] array 
                out += p1Fire[j][i];
            }
            if(i != p1Fire[0].length - 1)
            {
                out += "\n";
            }
        }
        return out;
    }

    public String printP2Fire() // STUB, write this for step 4
    {
        String out = "";
        for(int i = 0; i < p2Fire[0].length; i++)
        {
            for(int j = 0; j < p2Fire.length; j++)
            {
                out += p2Fire[j][i];
            }
            if(i != p2Fire[0].length - 1)
            {
                out += "\n";
            }
        }
        return out;
    }

    // If there are any ship spots in the array, the game can't be over yet.
    private boolean gameOver(int[][] grid)
    {
        boolean over = true;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[j][i] == SHIP)
                {
                    over = false;
                }
            }
        }
        return over;
    }

    public boolean playerOneWon()
    {
        return gameOver(p2Grid);
    }

    public boolean playerTwoWon()
    {
        return gameOver(p1Grid);
    }

    // Should be called when Player 2 fires at Player 1
    public int fireAtPlayerOne(int x, int y)
    {
        int result = p1Grid[x][y];
        if(result == EMPTY)
        {
            p1Grid[x][y] = MISS;
            p2Fire[x][y] = MISS;
        }
        else if(result == SHIP)
        {
            p1Grid[x][y] = HIT;
            p2Fire[x][y] = HIT;
        }        
        return result;
    }

    public int fireAtPlayerTwo(int x, int y) // Fix this method for Step 5
    {
        int result = p2Grid[x][y];
        if(result == EMPTY)
        {
            // 5. Changed HIT and HIT to MISS and MISS
            p2Grid[x][y] = MISS;
            p1Fire[x][y] = MISS;
        }
        else if(result == SHIP)
        {
            // 5. Changed MISS and MISS to HIT and HIT
            p2Grid[x][y] = HIT;
            p1Fire[x][y] = HIT;
        }        
        return result;
    }
}