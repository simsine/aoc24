package part2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static int similarityScore = 0;
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(new File("input.txt"));
		while (scanner.hasNextInt()) {
			left.add(scanner.nextInt());
			right.add(scanner.nextInt());
		}
		scanner.close();
		
		for (Integer leftNum : left) {
			Long inRight = right.stream().filter(t -> t.equals(leftNum)).count();
			similarityScore += leftNum * inRight;
		}
		
		System.out.println(similarityScore);
	}
}
