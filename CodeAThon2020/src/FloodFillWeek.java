/*
 * Written by Daniel Gleaves
 */
import java.util.Scanner;
public class FloodFillWeek {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String dimensions = keyboard.nextLine();
		int delim = dimensions.indexOf(' ');
		int rows = Integer.parseInt(dimensions.substring(0, delim));
		int columns = Integer.parseInt(dimensions.substring(delim+1));
		
		String[] heightmap = new String[rows];
		
		for(int i=0;i<rows;i++) {
			heightmap[i] = keyboard.nextLine();
		}
		
		int currentTile, comparisonTile, toNorthEdge, toEastEdge, toSouthEdge, toWestEdge;
		int floodedPaths = 0;
		int floodedTiles = 0;
		boolean drains = false;
		for(int i=1;i<heightmap.length-1;i++) {
			System.out.println("i = " +i);
			for(int j=1;j<heightmap[i].length()-1;j++) {
				System.out.println("j = " +j);
				currentTile = Integer.parseInt(heightmap[i].substring(j, j+1));
				System.out.println("Current tile: " +currentTile);
				
				//North
				for(int k=0;k<i;k++) {
					if(NorthDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(SouthDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(EastDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(WestDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
				}
				if(drains) {
					drains = false;
					break;
				}
				//South
				for(int k=i;k<heightmap.length-i-1;k++) {
					if(SouthDrain(heightmap, currentTile, j, k)) {
						drains = true;
						break;
					}
					if(NorthDrain(heightmap, currentTile, j, k)) {
						drains = true;
						break;
					}
					if(EastDrain(heightmap, currentTile, j, k)) {
						drains = true;
						break;
					}
					if(WestDrain(heightmap, currentTile, j, k)) {
						drains = true;
						break;
					}
				}
				if(drains == true) {
					drains = false;
					break;
				}
				//East
				for(int k=0;k<heightmap[i].length()-j-1;k++) {
					if(EastDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(SouthDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(WestDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
					if(NorthDrain(heightmap, currentTile, k, i)) {
						drains = true;
						break;
					}
				}
				if(drains == true) {
					drains = false;
					break;
				}
				//West
				for(int k=0;k<heightmap[i].length()-j;k++) {
					if(EastDrain(heightmap, currentTile, j, i)) {
						drains = true;
						break;
					}
					if(SouthDrain(heightmap, currentTile, j, i)) {
						drains = true;
						break;
					}
					if(WestDrain(heightmap, currentTile, j, i)) {
						drains = true;
						break;
					}
					if(NorthDrain(heightmap, currentTile, j, i)) {
						drains = true;
						break;
					}
				}
				if(drains == true) {
					drains = false;
					break;
				}
				
				if(drains == false) {
					floodedTiles += 1;
				}
			}
			
		}
		
		System.out.println("Flooded tiles: " + floodedTiles);
		
	}
	
	public static boolean NorthDrain(String[] map, int tile, int xIndex, int yIndex) {
		
		for(int i=0;i<yIndex;i++) {
			int comparisonTile = Integer.parseInt(map[yIndex-i].substring(xIndex, xIndex+1));
			if(tile <  comparisonTile) {
				System.out.println("North Flooded: " + tile + comparisonTile);
				return false;
			}
		}
		return true;
	}
	
	public static boolean SouthDrain(String[] map, int tile, int xIndex, int yIndex) {
		
		for(int i=0;i<yIndex;i++) {
			int comparisonTile = Integer.parseInt(map[yIndex+i].substring(xIndex, xIndex+1));
			if(tile <  comparisonTile) {
				System.out.println("South Flooded: " + tile + comparisonTile);
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean EastDrain(String[] map, int tile, int xIndex, int yIndex) {
		
		for(int i=0;i<map[yIndex].length()-xIndex-1;i++) {
			int comparisonTile = Integer.parseInt(map[yIndex].substring(xIndex+i, xIndex+i+1));
			if(tile <  comparisonTile) {
				System.out.println("East Flooded: " + tile + comparisonTile);
				return false;
			}
		}
		
		return true;
	}

	public static boolean WestDrain(String[] map, int tile, int xIndex, int yIndex) {
		
		for(int i=0;i<map[yIndex].length()-xIndex-1;i++) {
			int comparisonTile = Integer.parseInt(map[yIndex].substring(xIndex-i, xIndex-i+1));
			if(tile <  comparisonTile) {
				System.out.println("West Flooded: " + tile + comparisonTile);
				return false;
			}
		}
		
		return true;
	}
}


