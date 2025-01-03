package part1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import common.RuleMap;

public class Main {
	
	private static int pageNumberSum = 0;
	
	private static RuleMap rules = new RuleMap();
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		
		while (scanner.hasNextInt()) {
			Integer key = scanner.nextInt();
			Integer value = scanner.nextInt();
			rules.put(key, value);
		}
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line == "") continue;
			List<Integer> lineNums = List.of(line.split(",")).stream()
				.map(Integer::parseInt)
				.toList();
			pageNumberSum += getNumberForLine(lineNums);
		}
		
		scanner.close();
		
		System.out.println(pageNumberSum);
	}
	
	
	/**
	 * @return 0 for an invalid line
	 * 		  or middle number of line if valid
	 */
	public static int getNumberForLine(List<Integer> lineNums) {
		for (int i = 1; i < lineNums.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (rules.get(lineNums.get(i)).contains(lineNums.get(j)))
					return 0;
			}
		}
		return lineNums.get(lineNums.size()/2);
	}
}

