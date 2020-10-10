/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
public class DonaldsPapers {
	
	public static final double[] A = {90, 100};
	public static final double[] B = {80, 90};
	public static final double[] C = {70, 80};
	public static final double[] D = {60, 70};
	public static final double[] F = {0, 60};
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int quantity = keyboard.nextInt();
		keyboard.nextLine();
		String input = keyboard.nextLine();
		String[] strGrades =  input.split(" ");
		int[] intGrades = new int[strGrades.length];
		double sum = 0;
		double avg;
		for(int i=0;i<strGrades.length;i++) {			
			intGrades[i] = Integer.parseInt(strGrades[i]);
			sum += intGrades[i];
		}
		avg = sum/intGrades.length;
		//Bubble Sort
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i<intGrades.length-1; i++) {
				if(intGrades[i] > intGrades[i+1]) {
					//Swap
					int temp = intGrades[i];
					intGrades[i] = intGrades[i+1];
					intGrades[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//Find median
		double median;
		int half = intGrades.length/2;
		if((intGrades.length % 2) == 0) {
			median = (intGrades[half] + intGrades[half+1]) / 2;
		}
		else {
			median = intGrades[half];
		}
		
		String avgOutput = "";
		if(avg >= A[0] && avg <= A[1]) {
			avgOutput = "A";
		}
		if(avg >= B[0] && avg < B[1]) {
			avgOutput = "B";
		}
		if(avg >= C[0] && avg < C[1]) {
			avgOutput = "C";
		}
		if(avg >= D[0] && avg < D[1]) {
			avgOutput = "D";
		}
		if(avg >= F[0] && avg < F[1]) {
			avgOutput = "F";
		}
		String medianOutput = "";
		if(median >= A[0] && median < A[1]) {
			medianOutput = "A";
		}
		if(median >= B[0] && median < B[1]) {
			medianOutput = "B";
		}
		if(median >= C[0] && median < C[1]) {
			medianOutput = "C";
		}
		if(median >= D[0] && median < D[1]) {
			medianOutput = "D";
		}
		if(median >= F[0] && median < F[1]) {
			medianOutput = "F";
		}
		System.out.println(avgOutput + " " + medianOutput);
	}

}
