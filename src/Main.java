import java.util.List;

public class Main {
	public static void main(String[] args) {
		String[] input = { "12 + 34 * (56 - 78 ) /90", "(sum + 47) / total" };

		Lexer lexer = new Lexer(input[0]);
		List<Token> tokens = lexer.tokenize();
		Lexer lexer1 = new Lexer(input[1]);
		List<Token> tokens1 = lexer1.tokenize();

		for (Token token : tokens) {
			System.out.println(token);
		}
		System.out.println("-------------------------");
		for (Token token : tokens1) {
			System.out.println(token);
		}

	}
}
