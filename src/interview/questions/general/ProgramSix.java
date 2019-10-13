package interview.questions.general;

public class ProgramSix {

	public static void main(String[] args) {
		String input = "geeksforgeeg";
		// output : abummool
		char current = input.charAt(0);
		int count = 0;
		String output = "";
		for (int i = 1; i < input.length(); i++) {
			char inCar = input.charAt(i);
			if(inCar == current) {
				count++;
			}else if(inCar != current && count == 0){
				output += Character.toString(current);
				current = inCar;
			}else {
				current = inCar;
				count = 0;
			}
			if(i == input.length()-1 && count == 0) {
				output += Character.toString(current);
			}
		}
		System.out.println(output);
	}
}
