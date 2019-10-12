package interview.questions.general;

//input : PROGRAM
// print like
// P     M
//  R   A
//   O R
//    G
//   O R
//  R   A
// P     M
public class ProgramTwo {

	public static void main(String[] args) {
		String input = "PROGRAM";
		ProgramTwo programTwo = new ProgramTwo();
		programTwo.mySolution(input);
	}

	private void mySolution(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				int start = i;
				int end = input.length() -1 -i;
				if(j == start || j == end) {
					System.out.print(input.charAt(j));
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
