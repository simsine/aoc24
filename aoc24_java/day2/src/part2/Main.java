package part2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static int safeReports = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(new File("input.txt"));
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			List<Integer> lineNums = List.of(line.split(" "))
				.stream()
				.map(Integer::valueOf)
				.toList();
			boolean isOneSafe = false;
			for (int i = 0; i < lineNums.size(); i++) {
				LinkedList<Integer> removedLevel = new LinkedList<Integer>(lineNums);
				removedLevel.remove(i);
				if (isSafe(removedLevel)) isOneSafe = true;
			}
			
			if (isOneSafe) safeReports++;
		}
		scanner.close();
		
		System.out.println("safeReports:" + safeReports);
	}
	
	public static boolean isSafe(List<Integer> nums) {
		ArrayList<Integer> signs = new ArrayList<>(nums.size());
		for (int i = 0; i < nums.size()-1; i++) {
			int diff = Math.abs(nums.get(i) - nums.get(i+1));
			if (diff < 1 || diff > 3) return false;
			Integer diff2 = nums.get(i) - nums.get(i+1);
			signs.add(Integer.signum(diff2));
		}
		if (signs.stream().anyMatch(t -> t == 0)) return false;
		if (signs.stream().allMatch(t -> t == -1)) return true;
		if (signs.stream().allMatch(t -> t == 1)) return true;
		return false;
	}
}
