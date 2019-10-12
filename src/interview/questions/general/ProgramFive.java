package interview.questions.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

// Sort even-placed elements in increasing and odd-placed in decreasing order
//Input:  arr[] = {0, 1, 2, 3, 4, 5, 6, 7}
//Output: arr[] = {0, 2, 4, 6, 7, 5, 3, 1}
//Even-place elements : 0, 2, 4, 6
//Odd-place elements : 1, 3, 5, 7
//Even-place elements in increasing order : 
//0, 2, 4, 6
//Odd-Place elements in decreasing order : 
//7, 5, 3, 1
	
public class ProgramFive {
	
	// Driver code 
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 }; 
        int n = arr.length; 
//        effOne(arr, n);
        effTwo(arr, n);
        for (int i = 0; i < n; i++) { 
//            System.out.print(arr[i] + " "); 
        } 
    } 

	 private static void effTwo(int[] arr, int n) {
		 // first odd index 
	        int i = 1; 
	  
	        // last index 
	        int j = n - 1; 
	  
	        // if last index is odd 
	        if (j % 2 != 0) 
	            // decrement j to even index 
	            j--; 
	  
	        // swapping till half of array 
	        while (i < j) { 
	            arr = swap(arr, i, j); 
	            i += 2; 
	            j -= 2; 
	        } 
	  
	        // Sort first half in increasing 
	        Arrays.sort(arr, 0, (n + 1) / 2); 
	  
	        // Sort second half in decreasing 
	        Arrays.sort(arr, (n + 1) / 2, n); 
	        int low = (n + 1) / 2, high = n - 1; 
	        // Reverse the second half 
	        while (low < high) { 
	            Integer temp = arr[low]; 
	            arr[low] = arr[high]; 
	            arr[high] = temp; 
	            low++; 
	            high--; 
	        } 
	        
	        int even = 0;
	        int odd = arr.length/2; 
	        for (int k = 0; k <= (arr.length-1)/2; k++) {
	        	System.out.print(arr[even]);
				System.out.print(" ");
				System.out.print(arr[odd]);
				System.out.print(" ");
				odd++;
				even++;
			}
//	        1 9 2 7 3 5 6 4 8 0
	    } 
	    static int[] swap(int[] arr, int i, int j) 
	    { 
	        int temp = arr[i]; 
	        arr[i] = arr[j]; 
	        arr[j] = temp; 
	        return arr; 
	    } 

	static void effOne(int arr[], int n) 
	    { 
	        // create evenArr[] and oddArr[] 
	        Vector<Integer> evenArr = new Vector<Integer>(); 
	        Vector<Integer> oddArr = new Vector<Integer>(); 
	  
	        // Put elements in oddArr[] and evenArr[] as 
	        // per their position 
	        for (int i = 0; i < n; i++) { 
	            if (i % 2 != 1) { 
	                evenArr.add(arr[i]); 
	            } 
	            else { 
	                oddArr.add(arr[i]); 
	            } 
	        } 
	  
	        // sort evenArr[] in ascending order 
	        // sort oddArr[] in descending order 
	        Collections.sort(evenArr); 
	        Collections.sort(oddArr, Collections.reverseOrder()); 
	  
	        int i = 0; 
	        for (int j = 0; j < evenArr.size(); j++) { 
	            arr[i++] = evenArr.get(j); 
	        } 
	        for (int j = 0; j < oddArr.size(); j++) { 
	            arr[i++] = oddArr.get(j); 
	        } 
	    } 
	  
	    

}
