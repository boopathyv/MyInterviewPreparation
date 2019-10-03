package interview.questions.lcmgcdhcf;

public class Gcd {

	public static void main(String[] args) {
		int arr[] = {36,60};
		System.out.println(findGCD(arr));
	}

	private static int findGCD(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = gcd(arr[i],result);
		}
		return result;
	}

	private static int gcd(int a, int b) {
		if(a==0){
			return b;
		}
		return gcd(b % a, a);
	}
}
