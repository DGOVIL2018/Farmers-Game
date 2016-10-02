import java.util.Scanner;

public class FarmersGame
{

/* This "Farmers Game" helps you play a complex game in which you try to get your wolf,

   cabbage, and sheep to the other side of the bank ... with them all alive!

   Created By: Dhruv Govil

   Version#: 1

**/	
	
	public static boolean cabbage = true ;  //declare and initialize four global-scope boolean variables which represent the four characters 

	public static boolean sheep = true; //True implies they are on the origin bank

	public static boolean wolf = true;

	public static boolean human = true;

	public static String move = "";

	public static String bankOrigin = "HWSC";

	public static String bankDest = "----";

	
public static void main (String[] args)  //display game instructions and call other well-defined functions

	{

		System.out.println("Welcome to the Farmer's Game. Pay attention to the rules of the game. When left alone, the wolf eats the sheep, and the sheep eats the cabbage. The human always goes on the boat to the other side with only ONE other object. Get all four of them to the other side of the bank, in order to win the game. Good luck!");
		
		
		printBoard();
		while (true)
		{
			UserMove();
			updateBoard();
			printBoard();
			checkWinOrLoss();
		}
		

		

	}

	
	public static void UserMove() //inputs the object to move, if valid move then takes action, else prompts for another move
	{
		
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to move to the other bank{H,W,S,or C}?: ");
		move = input.nextLine();

		if (move.contains("H"))
		{
			human = !(human);
		}

		else if ((move.contains("W")) && (human == wolf))
		{
			wolf = !(wolf);
			human = !(human);
		}

		else if ((move.contains("S")) && (human == sheep))
		{
			sheep = !(sheep);
			human = !(human);
		}

		else if ((move.contains("C")) && (human == cabbage))
		{
			cabbage = !(cabbage);
			human = !(human);
		}
		
		else
		{
			System.out.println("Invalid move. Please try again.");
		}
	
	}


	public static void updateBoard() //this function creates two four-letter strings based on the status of the four objects
	{
		bankOrigin = "";
		bankDest = "";

		if (human)
		{
			bankOrigin += "H";
			bankDest += "-"; 
		}

		else
		{
			bankOrigin += "-";
			bankDest += "H"; 
		}

		if (wolf)
		{
			bankOrigin += "W";
			bankDest += "-"; 
		}

		else
		{
			bankOrigin += "-";
			bankDest += "W"; 
		}
 
		if (sheep)
		{
			bankOrigin += "S";
			bankDest += "-"; 
		}

		else
		{
			bankOrigin += "-";
			bankDest += "S"; 
		}
		
		if (cabbage)
		{
			bankOrigin += "C";
			bankDest += "-"; 
		}

		else
		{
			bankOrigin += "-";
			bankDest += "C"; 
		}



	}



	public static void printBoard() //this function prints the board's current status
	{
		System.out.print("-----" + bankOrigin + "-----\n\n");
		
		System.out.print("-----" + bankDest + "-----\n\n"); 

	}

	public static void checkWinOrLoss() //checks for win or loss, and exits with message if conditions are met
	{
		if (!(human) && !(wolf) && !(sheep) && !(cabbage))
		{
			System.out.print("Smart farmer, you succeeded in your task!");
			System.exit(0);
		}

		if ((sheep == cabbage) && (human != sheep))
		{
			System.out.print("Sorry farmer, you failed. The sheep ate the cabbage.");
			
		}
		 
		if ((wolf == sheep) && (human != wolf))
		{
			System.out.print("Sorry farmer, you failed. The wolf ate the sheep.");
		}


	}
	

}