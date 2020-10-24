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
			//Custom game
			if(input.equals("1")) {
				System.out.println("Enter a custom board size and/or starting position in the format:\n"
						+ "Size, or\n"
						+ "Starting x, starting y, or\n"
						+ "Size, starting x, starting y\n"
						+ "x and y must be in range (0, size)");
				input = keyboard.nextLine();
				String[] options = input.split(", ");
				System.out.println(options[0]);
				if(options.length == 1) {
					try {
						Board board = new Board(Integer.parseInt(options[0]));
						boards.add(board);
					} catch(Exception e) {
						System.out.println(e);
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
			//Standard game
			else {
				Board board = new Board();
				boards.add(board);
			}
			Board currentBoard = boards.get(games-1);
			String temperature = boards.get(games-1).getTemperature();
			System.out.println("Win: " + boards.get(games-1).checkWin());
			System.out.println("Colder: " + (temperature.equalsIgnoreCase("colder")? "true" : "false"));
			keyboard.nextLine();
			
			//Slightly Less Naive Bot
			//----------------------Find Warmer----------------------\\
			boolean warmer = false;
			boolean boardIsEven = currentBoard.getBoardSize() % 2 == 0;
			if(boardIsEven) {	//Even board size
				//Check quadrants II and I
				for(int j=0; j<(currentBoard.getBoardSize()+1)/2;j++) {
					currentBoard.move(1, 0);
					if(currentBoard.getTemperature().equals("warmer")) {
						warmer = true;
						break;
					}
				}
				//Check Quadrant IV
				for(int j=0; j<currentBoard.getBoardSize()/2+1;j++) {
					currentBoard.move(0, 1);
					if(currentBoard.getTemperature().equals("warmer")) {
						warmer = true;
						break;
					}
				}
			}
			else {	//Odd board size
				//Check quadrants II and I
				for(int j=0; j<currentBoard.getBoardSize()/2+1;j++) {
					currentBoard.move(1, 0);
					if(currentBoard.getTemperature().equals("warmer")) {
						warmer = true;
						break;
					}
				}
				currentBoard.move(-1, 1);
				//Check quadrant IV
				for(int j=0; j<currentBoard.getBoardSize()/2;j++) {
					currentBoard.move(0, 1);
					if(currentBoard.getTemperature().equals("warmer")) {
						warmer = true;
						break;
					}
				}
			}
			//Check Quadrant IV
//			if(!warmer) {
//				if(boardIsEven) {	//Even board size
//					for(int j=0; j<currentBoard.getBoardSize()/2+1;j++) {
//						currentBoard.move(0, 1);
//						if(currentBoard.getTemperature().equals("warmer")) {
//							warmer = true;
//							break;
//						}
//					}
//				}
//				else {	//Odd board size
//					for(int j=0; j<currentBoard.getBoardSize()/2+1;j++) {
//						currentBoard.move(0, 1);
//						if(currentBoard.getTemperature().equals("warmer")) {
//							warmer = true;
//							break;
//						}
//					}
//				}
//			}
			//Found middle Y
			if(!warmer) {	//Quadrant III
				currentBoard.move(-1, 0);
			}
			if(!warmer) {	//Quadrant III
				currentBoard.move(1, 0);
				currentBoard.move(1, 0);
			}
			//----------------------Found Warmer----------------------\\
			
			
			//System.out.println("Win");
			quit = true;
		}
		keyboard.close();
	}
	

}
