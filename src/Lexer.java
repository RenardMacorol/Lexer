import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class Lexer {
	BufferedReader reader;
	List<Token> tokens;
	int currentChar;

	Lexer(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		reader = new BufferedReader(fileReader);
		tokens = new ArrayList<>();
		lexer();
	}

	public List<Token> getTokens() {
		return tokens;
	}

	private void nextChar() throws IOException {
		currentChar = reader.read();
	}

	private String digitChecker() throws IOException {
		StringBuilder int_Token = new StringBuilder();
		while (Character.isDigit(currentChar)) {
			int_Token.append((char) currentChar);
			nextChar();
		}
		return int_Token.toString();
	}

	private String letterChecker() throws IOException {
		StringBuilder letter_Token = new StringBuilder();
		while (Character.isAlphabetic((char) currentChar)) {
			letter_Token.append((char) currentChar);
			nextChar();
		}
		return letter_Token.toString();

	}

	private void lexer() throws IOException {
		nextChar();

		while (currentChar != -1) {
			System.out.print((char) currentChar);
			if (Character.isDigit((char) currentChar)) {
				String digit_Token = digitChecker();
				tokens.add(new Token(TokenType.INT_LITERAL, digit_Token));
				continue;
			} else if (Character.isLetter(currentChar)) {
				String identifier_Token = letterChecker();
				tokens.add(new Token(TokenType.IDENTIFIER_VARIABLE, identifier_Token));
				continue;
			}

			switch (currentChar) {
				case '=':
					tokens.add(new Token(TokenType.ASSIGN_OP, "="));
					break;

				case '+':
					tokens.add(new Token(TokenType.ADD, "+"));
					break;
				case '-':
					tokens.add(new Token(TokenType.SUB, "-"));
					break;
				case '*':
					tokens.add(new Token(TokenType.MUL, "*"));
					break;
				case '/':
					tokens.add(new Token(TokenType.DIV, "/"));
					break;
				case '(':
					tokens.add(new Token(TokenType.LEFT_PAREN, "("));
					break;
				case ')':
					tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
					break;
				default:
					break;
			}

			nextChar();

		}
		System.out.println();
		tokens.add(new Token(TokenType.EOF, "EOF"));
	}

}
