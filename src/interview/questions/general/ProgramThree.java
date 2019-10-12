package interview.questions.general;

// reverse a string using recursion
public class ProgramThree {

	public static void main(String[] args) {
		String input = "HI BABY HOW ARE YOU";
		System.out.println("using recursion......  "+usingRecursion(input));
		System.out.println("using StringBuilder..  "+usingStringBuilder(input));
		
		System.out.println("reversing integer..  "+reverseAnInteger(145679));
	}

	private static int reverseAnInteger(int input) {
		int output = 0;
		while(input > 0) {
			int number = input % 10;
			output = (output*10)+number;
			input = input/10;
		}
		return output;
	}

	private static String usingRecursion(String input) {
		if(input.isEmpty()) {
			return input;
		}
		return usingRecursion(input.substring(1))+input.charAt(0);
	}
	
	private static String usingStringBuilder(String input) {
		StringBuilder str = new StringBuilder(input);
		return str.reverse().toString();
	}
}
