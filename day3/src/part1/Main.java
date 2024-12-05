package part1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	private static int mulRes = 0;
	
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		
		Scanner scanner = new Scanner(new File("input.txt"));
		
		scanner
			.findAll(Pattern.compile("mul\\(\\d+,\\d+\\)", Pattern.MULTILINE))
			.map(t -> new Scanner(t.group()).findAll("\\d+").map(s-> s.group()).mapToInt(Integer::parseInt).toArray()) // wtfffff
			.forEach(s-> {
				mulRes += s[0] * s[1];
			});;
		
		scanner.close();
		
		System.out.println("mulRes:" + mulRes);
	}
	
}
