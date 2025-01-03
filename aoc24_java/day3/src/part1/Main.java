package part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
	
	private static int mulRes = 0;
	
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("input.txt"));
		
		Pattern mulPattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
		Pattern numPattern = Pattern.compile("\\d+");
		
		List<String> mulStrings = mulPattern.matcher(lines.toString())
			.results()
			.map(MatchResult::group)
			.toList();
		
		for (String mulString : mulStrings) {
			mulRes += numPattern.matcher(mulString)
				.results()
				.map(MatchResult::group)
				.mapToInt(Integer::parseInt)
				.reduce((left, right) -> left * right)
				.getAsInt();
		}
		
		System.out.println("mulRes:" + mulRes);
	}
	
}
