package interview.questions.general;

import java.util.Arrays;

// we have two sorted arrays;
// input : arr1 = {10}, arr2 = {2,3}
// output : arr1 = {2}, arr2 = {3,10}
public class ProgramFour {
	static int arr1[] = new int[]{1, 5, 9, 14, 15, 20}; 

    static int arr2[] = new int[]{2, 3, 8, 13}; 

      
 // Driver method to test the above function 

    public static void main(String[] args) { 
//        merge(arr1.length,arr2.length); 
    	mySolution(arr1.length,arr2.length); 
        
        System.out.print("After Merging nFirst Array: "); 

        System.out.println(Arrays.toString(arr1)); 

        System.out.print("Second Array:  "); 

        System.out.println(Arrays.toString(arr2)); 
    } 

    private static void mySolution(int length1, int length2) {
		for (int i = length2-1; i >= 0 ; i--) {
			int j, last = arr1[length1-1];
			for (j = length1-2; j >= 0; j--) {
				if(arr1[j] > arr2[i]) {
					arr1[j+1] = arr1[j];
				}else {
					break;
				}
			}
			if(j != length1-2 || last > arr2[i]) {
				arr1[j+1] = arr2[i];
				arr2[i] = last;
			}
		}
	}

	static void merge(int m, int n) 

    { 

        // Iterate through all elements of ar2[] starting from 

        // the last element 

        for (int i=n-1; i>=0; i--) 

        { 

            /* Find the smallest element greater than ar2[i]. Move all 

               elements one position ahead till the smallest greater 

               element is not found */

            int j, last = arr1[m-1]; 

            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--) 

                arr1[j+1] = arr1[j]; 

       

            // If there was a greater element 

            if (j != m-2 || last > arr2[i]) 

            { 

                arr1[j+1] = arr2[i]; 

                arr2[i] = last; 

            } 

        } 

    } 

}
