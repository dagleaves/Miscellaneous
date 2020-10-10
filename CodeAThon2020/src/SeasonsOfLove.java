/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
public class SeasonsOfLove {
	
	public static final int MIN2SEC = 60;
	public static final int HOUR2SEC = 60 * MIN2SEC;
	public static final int DAY2SEC= 24 * HOUR2SEC;
	public static final int WEEK2SEC = 7 * DAY2SEC;
	public static final int MONTH2SEC = 30 * DAY2SEC;
	public static final int YEAR2SEC = 365 * DAY2SEC;
		
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int tests = keyboard.nextInt();
		keyboard.nextLine();
		int[] output = new int[tests];
		
		String input;
		int value;
		
		for(int i=0;i<tests;i++) {
			input = keyboard.nextLine();
			
			if(input.substring(input.length()-1).equalsIgnoreCase("s"))
			{
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value;
			}
			else if(input.substring(input.length()-1).equalsIgnoreCase("m")) {
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value * MIN2SEC;
			}
			else if(input.substring(input.length()-1).equalsIgnoreCase("h")) {
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value * HOUR2SEC;
			}
			else if(input.substring(input.length()-1).equalsIgnoreCase("d")) {
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value * DAY2SEC;
			}
			else if(input.substring(input.length()-1).equalsIgnoreCase("w")) {
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value * WEEK2SEC;
			}
			else if(input.substring(input.length()-2).equalsIgnoreCase("mo")) {
				System.out.println("MONTH");
				value = Integer.parseInt(input.substring(0, input.length()-3));
				output[i] = value * MONTH2SEC;
			}
			else if(input.substring(input.length()-1).equalsIgnoreCase("y")) {
				value = Integer.parseInt(input.substring(0, input.length()-2));
				output[i] = value * YEAR2SEC;
			}
		}
		
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i]);
		}
		
	}

}
