import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
	private StringReader reader;
	private int currentChar;

	public Lexer(String input) {
		reader = new StringReader(input);
		advance();
	}

	public void advance() {
		try {
			currentChar = reader.read(); // reader.read read a single character of the file/input
		} catch (IOException e) {
			currentChar = -1; // indicates end of file input
		}
	}

	// Each input should pass in this method to tokenize them for lexical analysis/
	// this method
	// Labels all input make it the program an ease to read each input
	public List<Token> tokenize() {
		List<Token> tokens = new ArrayList<>();
		while (currentChar != -1) {
			char ch = (char) currentChar; // Convert the intChar into actual CH
			if (Character.isWhitespace(ch)) {
				// Ignore WhiteSpace It it not nessesary and not useful in tokenization
				advance();
			} else if (Character.isDigit(ch)) {
				tokens.add(readNumber());
			} else if (Character.isAlphabetic(ch)) {
				tokens.add(readAlphabetic());
			} else if (ch == '+') {
				tokens.add(new Token(TokenType.PLUS, "+"));
				advance();
			} else if (ch == '-') {
				tokens.add(new Token(TokenType.MINUS, "-"));
				advance();
			} else if (ch == '*') {
				tokens.add(new Token(TokenType.MULTIPLY, "*"));
				advance();
			} else if (ch == '/') {
				tokens.add(new Token(TokenType.DIVIDE, "/"));
				advance();
			} else if (ch == '(') {
				tokens.add(new Token(TokenType.LEFT_PAREN, "("));
				advance();
			} else if (ch == ')') {
				tokens.add(new Token(TokenType.LEFT_PAREN, ")"));
				advance();
			} else if (ch == '=') {
				tokens.add(new Token(TokenType.ASSIGN_OP, "="));
				advance();

			} else {
				throw new IllegalArgumentException("Unexpecterd character: " + ch + "Error Code 0001");
			}

		}

		tokens.add(new Token(TokenType.EOF, "EOF"));

		return tokens;
	}

	private Token readNumber() {
		StringBuilder sb = new StringBuilder();
		while (currentChar != -1 && Character.isDigit((char) currentChar)) {
			sb.append((char) currentChar);
			advance();
		}

		return new Token(TokenType.NUMBER, sb.toString());
	}

	private Token readAlphabetic() {
		StringBuilder sb = new StringBuilder();
		while (currentChar != -1 && Character.isAlphabetic((char) currentChar)
				&& !Character.isWhitespace((char) currentChar)) {
			sb.append((char) currentChar);
			advance();
		}

		return new Token(TokenType.IDENTIFIER, sb.toString());
	}
}
