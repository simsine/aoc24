package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
	
	private static int mulRes = 0;
	
	private static boolean doMul = true;
	
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("input.txt"));
		
		Pattern instructionPattern = Pattern.compile("mul\\(\\d+\\,\\d+\\)|do\\(\\)|don't\\(\\)");
		Pattern numPattern = Pattern.compile("\\d+");
		
		List<String> matchedInstructions = instructionPattern.matcher(lines.toString())
			.results()
			.map(MatchResult::group)
			.toList();
		
		for (String instruction : matchedInstructions) {
			if (instruction.contains("do()")) {
				doMul = true;
				continue;
			}
			
			if (instruction.contains("don't()")) {
				doMul = false;
				continue;
			}
			
			if (doMul) {
				mulRes += numPattern.matcher(instruction)
					.results()
					.map(MatchResult::group)
					.mapToInt(Integer::parseInt)
					.reduce((left, right) -> left * right)
					.getAsInt();
			}
		}
		
		System.out.println("mulRes:" + mulRes);
	}
	
}
