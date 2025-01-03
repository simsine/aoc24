package part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
	
	private static int xmasAppaearances = 0;
	
	private static Pattern xmasPattern = Pattern.compile("XMAS");
	
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("input.txt"));
		
		String[][] grid = lines.stream()
			.map(line -> line.split(""))
			.toArray(String[][]::new);
		
		ArrayList<String> selection = new ArrayList(grid.length);
		
		for (int i = 0; i < grid.length; i++) {
			selection.add(grid[i][0]);
		}
		
		String selectionString = selection.stream()
			.reduce(String::concat).get();
	}
	
}
