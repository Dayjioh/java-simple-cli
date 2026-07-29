import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cli {

	// The main method is the entry point of the program. Rules regarding the main
	// method:
	// - public: so the JVM can access it from "outside"
	// - static: so it can be called without creating an object (class scoped)
	// - void: it doesn't return a value (aka procedure)
	// - main: the required method name
	// - String[] args: so it can receive command-line arguments

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String

			String[] commandParts = command.split(" ", 2);

			if (commandParts[0].equals("exit")) {
				break; // Forces exit of the while loop
			} else if (commandParts[0].equals("date")) {
				LocalDate date = LocalDate.now();

				output = date.toString();
			} else if (commandParts[0].equals("time")) {
				LocalTime time = LocalTime.now();

				output = time.toString();
			} else if (commandParts[0].equals("datetime")) {
				LocalDateTime datetime = LocalDateTime.now();

				output = datetime.toString();
			} else if (commandParts[0].equals("useraccount")) {
				String userName = System.getProperty("user.name");
				output = userName;
			} else if (commandParts[0].equals("userhome")) {
				String userHome = System.getProperty("user.home");
				output = userHome;
			} else if (commandParts[0].equals("os")) {
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				output = osName + " (" + osVersion + ")";
			} else if (commandParts[0].equals("printenv")) {
				if (commandParts.length < 2 || System.getenv(commandParts[1]) == null) {
					output = "";
				} else {
					output = System.getenv(commandParts[1]);
				}

			} else if (commandParts[0].equals("echo")) {
				if (commandParts.length < 2) {
					output = "";
				} else {
					output = commandParts[1];
				}

			} else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}

}
