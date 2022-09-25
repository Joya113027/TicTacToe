import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 char gameBoard [] []= {{' ','|',' ','|',' '},
		 {'-','+','-','+','-'},
		 {' ','|',' ','|',' '},
		 {'-','+','-','+','-'},
		 {' ','|',' ','|',' '}};
 printgameBoard(gameBoard);
 
 while(true)
 {
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Enter Your Placement (1-9):");
	 int playerpos = scan.nextInt();
	 while(playerPositions.contains(playerpos) || cpuPositions.contains(playerPositions))
	 {
		System.out.println("Position Taken! Please Enter a Correct Position:");
		playerpos=scan.nextInt();
	 }
	 
	 
	 placePiece(gameBoard, playerpos, "player");
	 String result = checkWnner();
	 if(result.length()>0)
		{
			System.out.println(result);
			break;
		}
	 Random rand= new Random();
	 int cpupos=rand.nextInt(9)+1;
	 while(playerPositions.contains(cpupos) || cpuPositions.contains(cpupos))
	 {
		System.out.println("Position Taken! Please Enter a Correct Position:");
		cpupos=rand.nextInt(9)+1;
	 }
	 placePiece(gameBoard, cpupos, "cpu");

	printgameBoard(gameBoard);
	 result = checkWnner();
	if(result.length()>0)
	{
		System.out.println(result);
		break;
	}
	
 }

	}
	public static void printgameBoard(char [][] gameBoard) {
		 for(char[] row: gameBoard)
		 { for(char c: row)
		 { System.out.print(c);
		 }
		 System.out.println();
			}
	}
	public static void placePiece(char [][] gameBoard, int pos, String user)
	{
		char symbol=' ';
		if(user.equals("player"))
		{
			symbol='X';
			playerPositions.add(pos);
		}else if(user.equals("cpu"))
		{
			symbol='O';
			cpuPositions.add(pos);
		}
		switch(pos)
		{
		case 1:
			gameBoard [0][0]=symbol;
			break;
		case 2:
			gameBoard [0][2]=symbol;
			break;
		case 3:
			gameBoard [0][4]=symbol;
			break;
		case 4:
			gameBoard [2][0]=symbol;
			break;
		case 5:
			gameBoard [2][2]=symbol;
			break;
		case 6:
			gameBoard [2][4]=symbol;
			break;
		case 7:
			gameBoard [4][0]=symbol;
			break;
		case 8:
			gameBoard [4][2]=symbol;
			break;
		case 9:
			gameBoard [4][4]=symbol;
			break;
			default:
				break;
		}
	}
	public static String checkWnner()
	{
		List topRow =Arrays.asList(1,2,3);
		List midRow =Arrays.asList(4,5,6);
		List botRow =Arrays.asList(7,8,9);
		List leftCol =Arrays.asList(1,4,7);
		List midCol =Arrays.asList(2,5,8);
		List rightCol =Arrays.asList(3,6,9);
		List cross1 =Arrays.asList(1,5,9);
		List cross2 =Arrays.asList(3,5,7);
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		for(List c : winning)
		{
			if(playerPositions.containsAll(c))
			{
				return "Congrats You Won!";
			}else if(cpuPositions.containsAll(c))
			{
				return "Sorry CPU Wins! :(";
			}else if(playerPositions.size() + cpuPositions.size()== 9)
			{
				return "Tie!";
			}
		}
		return"";
	}
}
