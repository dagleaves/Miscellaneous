import java.util.Scanner;
import java.util.StringTokenizer;

public class LinesOfLamb {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		int testCases = keyboard.nextInt();
		keyboard.nextLine();
		
		
		String[] input = new String[testCases*3];
		
		for(int i=0;i<input.length;i++) {
			input[i] = keyboard.nextLine();
		}
		
		for(int i=0;i<testCases;i++) {
			System.out.println(LineThoseLamb(i*3, input));
		}
		
	}
	
	public static int LineThoseLamb(int index, String[] array) {
		String lineOne = array[index];
		String lineTwo = array[index+1];
		String lineThree = array[index+2];
		
		StringTokenizer stLineOne = new StringTokenizer(lineOne);
		int lines = Integer.parseInt(stLineOne.nextToken());
		int operations = Integer.parseInt(stLineOne.nextToken());
		
		int[] sheep = new int[lines];
		StringTokenizer stLineTwo = new StringTokenizer(lineTwo);
		StringTokenizer stLineThree = new StringTokenizer(lineThree);
		int sum = 0;
		
		for(int i=0;i<operations;i++) {
			sum += Integer.parseInt(stLineThree.nextToken());
		}
		
		for(int i=0;i<lines;i++) {
			sheep[i] = Integer.parseInt(stLineTwo.nextToken());
			sheep[i] += sum;
		}
		
		int newTotal = 0;
		for(int i=0;i<lines;i++) {
			newTotal += sheep[i];
		}
		
		return newTotal;
	}

}
