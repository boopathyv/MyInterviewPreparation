package interview.codinground.striim;

import java.util.Scanner;

public class ProgramTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array length");
		int length = sc.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the nos.");
		
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			if(Math.abs(arr[i])>0 && Math.abs(arr[i])<arr.length) {
				arr[Math.abs(arr[i])] = -1*Math.abs(arr[Math.abs(arr[i])]);
			}
		}
		int value = 0;
		int highest = 0;
		for (int j = 1; j < arr.length; j++) {
			if(highest < Math.abs(arr[j])) {
				highest = Math.abs(arr[j]);
			}
			if(arr[j]>0) {
				value = j;
				break;
			}
		}
		if(value == 0) {
			value = highest+1;
		}
		System.out.println("Missing Number...."+value);
	}
}
