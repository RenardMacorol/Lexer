import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		String filePath = "../input.txt";
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			String input = String.join(" ", lines);
			System.out.println("Initializing the Lexer");
			Lexer lexer = new Lexer(input);
			List<Token> tokens = lexer.tokenize();
			for (Token token : tokens) {
				System.out.println(token);
			}
		} catch (IOException e) {
			System.out.println("Error Reading Files: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
