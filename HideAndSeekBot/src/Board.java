/*
 * Written by Daniel Gleaves
 */
import java.util.Random;
public class Board {
	private int board_size;
	private int COLD_DIST = (board_size/2)*(board_size/2);
	private int WARM_DIST = (board_size/4)*(board_size/4);
	private int pX;
	private int pY;
	private int gX;
	private int gY;
	
	private char[][] board;
	
	private static final char EMPTY = '_';
	private static final char PLAYER = 'X';
	private static final char PATH = '#';
	private static final char GOAL = '_';
	
	public Board() {
		this.board_size = 10;
		this.pX = 0;
		this.pY = 0;
		this.setGoal();
		this.board = new char[this.board_size][this.board_size];
		this.initBoard();
		
	}
	
	public Board(int size) {
		this.board_size = size;
		this.pX = 0;
		this.pY = 0;
		this.setGoal();
		this.initBoard();
	}
	
	public Board(int x, int y) {
		this.board_size = 10;
		this.pX = x;
		this.pY = y;
		this.setGoal();
		this.initBoard();
	}
	
	public Board(int size, int x, int y) {
		this.board_size = size;
		this.pX = x;
		this.pY = y;
		this.setGoal();
		this.initBoard();
	}
	
	private void setGoal() {
		Random r = new Random();
		this.gX = r.nextInt(this.board_size);
		this.gY = r.nextInt(this.board_size);
	}
	
	private void initBoard() {
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board[i].length;j++) {
				this.board[j][i] = EMPTY;
			}
		}
		this.board[this.pX][this.pY] = PLAYER;
		this.board[this.gX][this.gY] = GOAL;
	}
	
	public int getBoardSize() {
		return this.board_size;
	}
	
	public int getPlayerX() {
		return this.pX;
	}
	
	public int getPlayerY() {
		return this.pY;
	}
	
	public int getGoalX() {
		return this.gX;
	}
	
	public int getGoalY() {
		return this.gY;
	}
	
	public String toString() {
		String boardString = "";
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board[i].length;j++) {
				boardString += this.board[j][i];
			}
			boardString += "\n";
		}
		boardString = boardString.substring(0, boardString.length()-1);
		return boardString;
	}
}
