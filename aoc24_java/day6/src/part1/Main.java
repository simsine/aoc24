package part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;



public class Main {
	
	private enum Direction { UP, RIGHT, DOWN, LEFT };
	
	private static Direction direction = Direction.UP;
	
	private static int x;
	private static int y;
	
	private static int guardSquaresWalked = 0;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		List<String> lines = Files.readAllLines(Path.of("input.txt"));

		String[][] grid = lines.stream()
			.map(line -> line.split(""))
			.toArray(String[][]::new);
		
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].equals("^")) {
					x = i;
					y = j;
				}
			}
		}
		
		System.out.println("Startpos: " + x + ", "+ y);
		String squareInFront = grid[x-1][y];
		
		try {
			while (true) {
				if (squareInFront.equals("#")) {
					switch (direction) {
						case UP:
							direction = Direction.RIGHT;
							break;
						case RIGHT:
							direction = Direction.DOWN;
							break;
						case DOWN:
							direction = Direction.LEFT;
							break;
						case LEFT:
							direction = Direction.UP;
							break;
					}
				}
				
				grid[x][y] = "X";
				
				switch (direction) {
					case UP:
						x--;
						squareInFront = grid[x-1][y];
						break;
					case RIGHT:
						y++;
						squareInFront = grid[x][y+1];
						break;
					case DOWN:
						x++;
						squareInFront = grid[x+1][y];
						break;
					case LEFT:
						y--;
						squareInFront = grid[x][y-1];
						break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		} finally {
			System.out.println("outside grid! x: " + x + " y: " + y);
			grid[x][y] = "X";
		}
		
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].equals("X")) guardSquaresWalked++;
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Squares touched: " + guardSquaresWalked);
	}
}
