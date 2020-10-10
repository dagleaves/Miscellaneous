/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
public class ScrollWager {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int width = keyboard.nextInt();
		keyboard.nextLine();
		int line = keyboard.nextInt();
		
		int[][] scroll = new int[line][width];
		
		//First line
		for(int i=0;i<width;i++) {
			scroll[0][i] =  i % 10;
		}
		//Find desired line
		for(int i=1;i<line;i++) {
			scroll[i][0] = 0;
			for(int j=1;j<width;j++) {
				scroll[i][j] = (scroll[i][j-1] + scroll[i-1][j] + scroll[i-1][j-1]) % 10;
			}
		}
		//Print that sweet, sweet line
		for(int i=0;i<width;i++) {
			System.out.print(scroll[line-1][i] + " ");
		}
	}

}
