package interview.questions.coin.pr1;

public class DynamicProgrammingOne {
	
	// Driver Function to test above function 
    public static void main(String args[]) 
    { 
        int arr[] = {2000,500,200,100}; 
        int m = arr.length; 
        int n = 400; 
        System.out.println(countWays(arr, m, n)); 
    } 
    
	 static long countWays(int S[], int m, int n) 
	    { 
	        //Time complexity of this function: O(mn) 
	        //Space Complexity of this function: O(n) 
	  
	        // table[i] will be storing the number of solutions 
	        // for value i. We need n+1 rows as the table is 
	        // constructed in bottom up manner using the base 
	        // case (n = 0) 
	        long[] table = new long[n+1];
	  
	        // Base case (If given value is 0) 
	        table[0] = 1; 
	  
	        // Pick all coins one by one and update the table[] 
	        // values after the index greater than or equal to 
	        // the value of the picked coin 
	        for (int i=0; i<m; i++) 
	            for (int j=S[i]; j<=n; j++) 
	                table[j] += table[j-S[i]]; 
	  
	        return table[n]; 
	    } 
	  
//		ANALYSE THIS TO GET SOLUTION
//		0 1 2 3 4 5 6 7 8 9 10 11 12
//		1 0 0 0 0 0 0 0 0 0 0  0  0  (initial state)
//		1 0 0 0 0 1 0 0 0 0 1  0  0  (10)
//		1 0 0 0 0 1 0 0 0 0 2  0  0  (10,5)
//		1 1 1 1 1 2 2 2 2 2 4  4  4  (10,5,1)
//		1 0 1 0 1 1 1 1 1 1 3  1  3  (10,5,2)
//		1 0 0 1 0 1 1 0 1 1 2  1  1  (10,5,3)
//		1 0 0 0 1 1 0 0 1 1 2  0  1  (10,5,4)
}
