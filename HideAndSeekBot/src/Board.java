/*
 * Written by Daniel Gleaves
 */
import java.util.Random;
public class Board {
	private int board_size;
	private String temperature;
	private int cold_dist = (board_size/2)*(board_size/2);
	private int warm_dist = (board_size/4)*(board_size/4);
	private int pX;
	private int pY;
	private int gX;
	private int gY;
	private boolean won = false;
	
	private char[][] board;
	
	private static final char EMPTY = '_';
	private static final char PLAYER = 'X';
	private static final char PATH = '#';
	private static final char GOAL = '_';
	
	public Board() {
		this.board_size = 10;
		this.cold_dist = (this.board_size/2)*(this.board_size/2);
		this.warm_dist = (this.board_size/4)*(this.board_size/4);
		this.pX = 0;
		this.pY = 0;
		this.setGoal();
		this.board = new char[this.board_size][this.board_size];
		this.initBoard();
		
	}
	
	public Board(int size) {
		this.board_size = size;
		this.cold_dist = (this.board_size/2)*(this.board_size/2);
		this.warm_dist = (this.board_size/4)*(this.board_size/4);
		this.pX = 0;
		this.pY = 0;
		this.setGoal();
		this.initBoard();
	}
	
	public Board(int startX, int startY) {
		this.board_size = 10;
		this.cold_dist = (this.board_size/2)*(this.board_size/2);
		this.warm_dist = (this.board_size/4)*(this.board_size/4);
		this.pX = startX;
		this.pY = startY;
		this.setGoal();
		this.initBoard();
	}
	
	public Board(int size, int startX, int startY) {
		this.board_size = size;
		this.cold_dist = (this.board_size/2)*(this.board_size/2);
		this.warm_dist = (this.board_size/4)*(this.board_size/4);
		this.pX = startX;
		this.pY = startY;
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
				this.board[j][i] = Board.EMPTY;
			}
		}
		this.board[this.pX][this.pY] = Board.PLAYER;
		this.board[this.gX][this.gY] = Board.GOAL;
		this.updateTemperature();
		System.out.println("Game Start");
		System.out.println(this);
	}
	
	public void move(int x, int y) {
		if(x < -1 || x > 1 || y < -1 || y > 1) {
			System.out.println("Invalid value");
			this.updateBoard(0, 0);
		}
		else {
			this.updateBoard(x, y);
		}
		System.out.println("Win: " + this.checkWin());
		System.out.println("Temperature: " + this.getTemperature());
	}
	
	private void updateBoard(int x, int y) {
		this.board[pX][pY] = Board.PATH;
		//Update player location
		this.pX += x;
		this.pY += y;
		this.checkBounds();			//Verify player is within bounds of board
		this.updateTemperature();	//Update temperature
		System.out.println(this);	//Print new board
	}
	
	private void checkBounds() {
		if(this.pX < 0) {	//Too far left
			this.pX = 0;
		}
		else if(this.pX > this.board.length-1) {	//Too far right
			this.pX = this.board.length-1;
		}
		if(this.pY < 0) {	//Too far up
			this.pY = 0;
		}
		else if(this.pY > this.board.length-1) {	//Too far down
			this.pY = this.board.length-1;
		}
		this.board[this.pX][this.pY] = Board.PLAYER;	//Update board's player location
	}
	
	public boolean checkWin() {
		return(this.pX == this.gX && this.pY == this.gY);
	}
	
	public int getBoardSize() {
		return this.board.length;
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
	
	public String getTemperature() {
		return this.temperature;
	}
	
	private void updateTemperature() {
		int distance = (this.pX-this.gX)*(this.pX-this.gX) + (this.pY-this.gY)*(this.pY-this.gY);
		System.out.println("Colder: " + this.cold_dist);
		System.out.println("Warmer: " + this.warm_dist);
		System.out.println("Distance = " + distance);
		if(distance > this.cold_dist) {
			this.temperature = "colder";
		}
		else if(distance > this.warm_dist) {
			this.temperature = "warmer";
		}
		else {
			this.temperature = "hotter";
		}
	}
	
	public String toString() {
		String boardString = "";
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board[i].length;j++) {
				boardString += this.board[j][i];
			}
			boardString += "\n";
		}
		return boardString;
	}
}
