import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("Main.txt");

		if (!file.exists()) {
			System.out.println("The file is not Exist " + file.getName());
			createFile(file);
		}
		System.out.println("File Is Exist starting the Compliation");

		Lexer lexer = new Lexer(file);
		List<Token> tokens = lexer.getTokens();

		for (Token token : tokens) {
			System.out.println(token.toString());
		}

	}

	public static void createFile(File file) throws IOException {
		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write("(3 + 5) 4 + 5");
			System.out.println("File has been Write named " + file.getName());
		}
	}

}
