import java.util.*;

public class passwordStrengthTester {

	public String passwordStrength(String input) {
		int n = input.length();
		boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;
		Set<Character> set = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

		for (char i : input.toCharArray()) {
			if (Character.isLowerCase(i))
				hasLower = true;
			if (Character.isUpperCase(i))
				hasUpper = true;
			if (Character.isDigit(i))
				hasDigit = true;
			if (set.contains(i))
				specialChar = true;
		}

		// Strength of password
		if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8))
			return "Strong ! - Excellent! ";
		else if ((hasLower || hasUpper || specialChar) && (n >= 6))
			return "Moderate ! - Not bad, but there's still room for improvement!" ;
		else
			return "Weak !! - Might be a little too easy to guess! Use more LowerCase, UpperCase, and Special characters! ";
	}

	public static void main(String[] args) {

		testing();
		reRun();

	}

	public static void testing() {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your password to check: ");
		String password = input.nextLine();

		passwordStrengthTester testing = new passwordStrengthTester();
		String passwordStrength = testing.passwordStrength(password);

		System.out.println("Your password strength is: " + passwordStrength);


	}


    public static void reRun() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to try again? Please enter [y] or [n]");
            String next = input.nextLine();

            if (next.equalsIgnoreCase("y")) {
                // Call testing method again if 'y' is entered
                testing();
            } else if (next.equalsIgnoreCase("n")) {
                System.out.println("Thanks for trying my password strength tester! Have a great day!");
                // Break out of the loop if 'n' is entered
                break;
            } else {
                System.out.println("Invalid input, please enter either [y] or [n]");
            }
        }
    }
}