package betaben.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("-----------------------------------");
		System.out.println("  Create a New Bright Light Board");
		System.out.println("-----------------------------------");
		System.out.println();
		
		Scanner newRowBoard = new Scanner(System.in);
		System.out.println("Enter how many rows you want the board to be: ");
		int numRows = newRowBoard.nextInt();
		
		Scanner newColBoard = new Scanner(System.in);
		System.out.println("Enter how many columns you want the board to be: ");
		int colRows = newRowBoard.nextInt();
		
		Board b = new Board(numRows, colRows);
		
		for(int r = 0; r < b.getNumRows(); r++){
			for(int c = 0; c < b.getNumCols(); c++){
				System.out.print("[" + b.getValue(r, c) + "]" + " ");	
			}
			System.out.println();
		}
		System.out.println();
		
		while(true){
			
			System.out.println("  ---------------------");
			System.out.println("  Change Board Values");
			System.out.println("  ---------------------");
			System.out.println();
			
			Scanner rowReader = new Scanner(System.in);
			System.out.println("Enter row: ");
			int row = rowReader.nextInt();
		
			Scanner colReader = new Scanner(System.in);
			System.out.println("Enter column: ");
			int col = colReader.nextInt();
			
			Scanner colorReader = new Scanner(System.in);
			System.out.println("Enter color: ");
			String color = colorReader.next();
			
			b.setValue(row-1, col-1, color);
			
			for(int r = 0; r < b.getNumRows(); r++){
				for(int c = 0; c < b.getNumCols(); c++){
					System.out.print("[" + b.getValue(r, c) + "]" + " ");	
				}
				System.out.println();
			}
			System.out.println();
		}
        
	}

}
