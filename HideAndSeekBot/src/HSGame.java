/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
import java.util.ArrayList;
public class HSGame {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Board> boards = new ArrayList<Board>();
		int games = 0;
		System.out.println("Welcome to the Hide and Seek bot! Press any key to begin.");
		keyboard.nextLine();
		boolean quit = false;
		while(!quit) {
			//User interaction
			games += 1;
			System.out.println("Game " + games + " has begun!\nPress 1 to start a custom game or press [ENTER] to begin");
			String input = keyboard.nextLine();
			if(input.equals("1")) {
				System.out.println("Enter a custom board size and/or starting position in the format:\n"
						+ "Size, or\n"
						+ "Starting x, starting y, or\n"
						+ "Size, starting x, starting y\n"
						+ "x and y must be in range (0, size)");
				input = keyboard.nextLine();
				String[] options = input.split(", ");
				if(options.length == 1) {
					try {
						Board board = new Board(Integer.parseInt(options[0]));
						boards.add(board);
					} catch(Exception e) {
						System.out.println("Invalid options. Starting game with default parameters...");
						Board board = new Board();
						boards.add(board);
					}
				}
				else if(options.length == 2) {
					try {
						Board board = new Board(Integer.parseInt(options[0]), Integer.parseInt(options[1]));
						boards.add(board);
					} catch(Exception e) {
						System.out.println("Invalid options. Starting game with default parameters...");
						Board board = new Board();
						boards.add(board);
					}
				}
				else if(options.length == 3) {
					try {
						Board board = new Board(Integer.parseInt(options[0]), Integer.parseInt(options[1]), Integer.parseInt(options[2]));
						boards.add(board);
					} catch(Exception e) {
						System.out.println("Invalid options. Starting game with default parameters...");
						Board board = new Board();
						boards.add(board);
					}
				}
				else {
					System.out.println("Invalid options. Starting game with default parameters...");
					Board board = new Board();
					boards.add(board);
				}
				
			}
			else {
				Board board = new Board();
				boards.add(board);
			}
			Board currentBoard = boards.get(games-1);
			String temperature = boards.get(games-1).getTemperature();
			System.out.println("Win: " + boards.get(games-1).checkWin());
			System.out.println("Colder: " + (temperature.equalsIgnoreCase("colder")? "true" : "false"));
			keyboard.nextLine();
			
			//Bot
			boolean win = false;
			while(true) {
				for(int j=0; j<currentBoard.getBoardSize();j++) {
					currentBoard.move(1, 0);
					if(currentBoard.checkWin())
						break;
				}
				if(currentBoard.checkWin())
					break;
				currentBoard.move(0, 1);
				if(currentBoard.checkWin())
					break;
				for(int j=0; j<currentBoard.getBoardSize();j++) {
					currentBoard.move(-1, 0);
					if(currentBoard.checkWin())
						break;
				}
				if(currentBoard.checkWin())
					break;
				currentBoard.move(0, 1);
				if(currentBoard.checkWin())
					break;
			}
			System.out.println("Win");
			quit = true;
		}
		keyboard.close();
	}
	

}
