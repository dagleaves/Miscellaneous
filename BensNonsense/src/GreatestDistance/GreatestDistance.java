package GreatestDistance;

import java.util.Random;
public class GreatestDistance {

	public static void main(String[] args) {
		//Fill array
		int[] array = new int[10];
		Random r = new Random();
		for(int i=0;i<10;i++) {
			array[i] = r.nextInt();
		}
		
		//Find smallest and biggest index
		int biggestX1= -1;
		int biggestY1 = -1;
		int biggestX2 = -1;
		int biggestY2 = -1;
		double biggestDistance = -1;
		for(int x1=0; x1<array.length; x1++) {
			for(int y1=0; y1<array.length;y1++) {
				if(x1 == y1)
					continue;
				for(int x2=0; x2<array.length;x2++) {
					if(x2 == x1)
						continue;
					for(int y2=0; y2<array.length;y2++) {
						if(x2 == y2)
							continue;
						//System.out.println("(" + array[x1] + ", " + array[y1] + "), (" + array[x2] + ", " + array[y2] + ")");
						double distance = calcDistance(array[x1], array[y1], array[x2], array[y2]);
						if(distance > biggestDistance) {
							biggestDistance = distance;
							biggestX1 = array[x1];
							biggestY1 = array[y1];
							biggestX2 = array[x2];
							biggestY2 = array[y2];
						}
					}
				}
			}
		}
		
		System.out.println("The points with the greatest distance are: (" + biggestX2 + ", " + biggestY2 + "), (" + biggestX1 + ", " + biggestY1 + ")");

	}
	
	public static double calcDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
	}

}
