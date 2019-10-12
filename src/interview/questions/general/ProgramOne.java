package interview.questions.general;

import java.util.Arrays;

// QUESTION : Program to give the following output
// a1b10 : abbbbbbbbbb
// abbbbbbbbbb : a1b10 (Vice Versa)
public class ProgramOne {

	public static void main(String[] args) {
		ProgramOne programOne = new ProgramOne();
		String input = "a14c16b20";
		String output = programOne.mySolution(input);
		programOne.mySolutionReverse(output);
	}

	private void mySolutionReverse(String input) {
		char[] inputArr = input.toCharArray();
		String output = "";
		int n = inputArr.length;
		int start = 0;
		int mover = 0;
		int count = 0;
		while(start < n) {
			if(mover < n && inputArr[start] == inputArr[mover]) {
				count++;
				mover++;
			}else {
				output += Character.toString(inputArr[start]).concat(String.valueOf(count));
				start = mover;
				count = 0;
			}
		}
		System.out.println(output);
	}

	private String mySolution(String input) {
		String current = "";
		int count = 0;
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			if(Character.isAlphabetic(in)) {
				current = Character.toString(in);
			}else if(Character.isDigit(in)) {
				String times = Character.toString(in);
				if(input.length() > i+1 && Character.isDigit(input.charAt(i+1))) {
					times += Character.toString(input.charAt(i+1));
					i++;
				}
				count = Integer.parseInt(times);
				for (int j = 0; j < count; j++) {
					output += current;
				}
			}
		}
		System.out.println(output);
		return output;
	}
}
