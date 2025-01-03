package part1;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	private static int totalDistance = 0;
	
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(100);
		PriorityQueue<Integer> right = new PriorityQueue<Integer>(100);
		
		Scanner scanner = new Scanner(new File("input.txt"));
		while (scanner.hasNextInt()) {
			left.add(scanner.nextInt());
			right.add(scanner.nextInt());
		}
		scanner.close();
		
		while (!left.isEmpty()) {
			totalDistance += Math.abs(left.remove()-right.remove());
		}
		System.out.println(totalDistance);
	}
}
