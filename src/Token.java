public class Token {
	private TokenType tokenType;
	private String value;

	Token(TokenType tokenType, String value) {
		this.tokenType = tokenType;
		this.value = value;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Token type: " + tokenType + " | " + " Value: " + value;
	}
}
