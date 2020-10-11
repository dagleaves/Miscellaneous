import java.util.Scanner;
import java.util.StringTokenizer;

public class ApplesToApples {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		
		StringTokenizer quantitySt = new StringTokenizer(input);
		int[] numbers = new int[2];
		for(int i=0;i<2;i++) {
			numbers[i] = Integer.parseInt(quantitySt.nextToken());
		}
		
		int listLength = numbers[0];
		int appleQuantity = numbers[1];
		
		String strWeights = keyboard.nextLine();
		StringTokenizer weightsSt = new StringTokenizer(strWeights);
		int[] weights = new int[listLength];
		for(int i=0;i<listLength;i++) {
			weights[i] = Integer.parseInt(weightsSt.nextToken());
		}
		
		//Smallest sort
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i<weights.length-1; i++) {
				if(weights[i] > weights[i+1]) {
					//Swap
					int temp = weights[i];
					weights[i] = weights[i+1];
					weights[i+1] = temp;
					hasSwapped = true;
				}
			}
		 }
		int andyApples = 0;
		for(int i=0;i<appleQuantity;i++) {
			andyApples += weights[i];
		}
				
		//Biggest sort
		hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i<weights.length-1; i++) {
				if(weights[i] < weights[i+1]) {
					int temp = weights[i];
					weights[i] = weights[i+1];
					weights[i+1] = temp;
					hasSwapped = true;
				}
			}
		 }				
				
		int samApples = 0;
		for(int i=0;i<appleQuantity;i++) {
			samApples += weights[i];
		}
		
		System.out.println(andyApples);
		System.out.println(samApples);
	}

}
