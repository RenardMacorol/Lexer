enum TokenType {
	NUMBER,
	IDENTIFIER,
	ASSIGN_OP,
	PLUS,
	MINUS,
	MULTIPLY,
	DIVIDE,
	LEFT_PAREN,
	RIGHT_PAREN,
	EOF
}

public class Token {
	private TokenType type;
	private String value;

	Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	public String toString() {
		return "Token: " + type + ", " + "Value: " + value;
	}

}
