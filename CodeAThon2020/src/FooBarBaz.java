/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
import java.util.StringTokenizer;
public class FooBarBaz {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		
		StringTokenizer st = new StringTokenizer(input);
		int[] numbers = new int[4];
		for(int i=0;i<4;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = numbers[0];
		int m = numbers[1];
		int x = numbers[2];
		int y = numbers[3];
		
		for(int i=n;i<m+1;i++) {
			if((i % x) == 0 && (i % y) == 0) {
				System.out.println("baz");
			}
			else if((i % x) == 0) {
				System.out.println("foo");
			}
			else if((i % y) == 0) {
				System.out.println("bar");
			}
			else {
				System.out.println(i);
			}
		}
		
		
		
	}

}
