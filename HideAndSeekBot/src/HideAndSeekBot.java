/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
import java.util.Random;
public class HideAndSeekBot {
	
	public static final int BOARD_SIZE = 10;
	public static final int COLD_DIST = (BOARD_SIZE/2)*(BOARD_SIZE/2);
	public static final int WARM_DIST = (BOARD_SIZE/4)*(BOARD_SIZE/4);
	
	public static final char EMPTY = '_';
	public static final char PLAYER = 'X';
	public static final char PATH = '#';
	public static final char GOAL = '_';
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		
		int pX = 0;
		int pY = 0;
		//Goal
		int gX = r.nextInt(BOARD_SIZE);
		int gY = r.nextInt(BOARD_SIZE);
		
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = EMPTY;
			}
			
		}
		
		board[pY][pX] = PLAYER;
		board[gY][gX] = GOAL;
		
		System.out.println("Welcome to Hide and Seek!");
		boolean gameOver = false;
		while(!gameOver) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[i].length;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			int distance = (pX-gX)*(pX-gX)+(pY-gY)*(pY-gY);
			if(distance > COLD_DIST) {
				System.out.println("You are getting colder");
			}
			else if(distance > WARM_DIST) {
				System.out.println("You are getting warmer");
			}
			else {
				System.out.println("You are getting hotter!");
			}
			//Change this --------------------
			System.out.println("Enter either -1, 0, or 1 to move in the x");
			int dX = keyboard.nextInt();
			System.out.println("Enter either -1, 0, or 1 to move in the y");
			int dY = keyboard.nextInt();
			if(dX < -1 || dX > 1) {
				System.out.println("That is invalid");
				dX = 0;
			}
			if(dY < -1 || dY > 1) {
				System.out.println("That is invalid!");
				dY = 0;
			}
			//To here ---------------------------
			board[pY][pX] = PATH;
			pX += dX;
			pY += dY;
			
			if(pX < 0) {
				pX = 0;
			}
			else if(pX > BOARD_SIZE-1) {
				pX = BOARD_SIZE-1;
			}
			if(pY < 0) {
				pY = 0;
			}
			else if(pY > BOARD_SIZE-1) {
				pY = BOARD_SIZE-1;
			}
			board[pY][pX] = PLAYER;
			if(pX == gX && pY == gX) {
				System.out.println("You win!");
				gameOver = true;
			}
		}
	}

}
