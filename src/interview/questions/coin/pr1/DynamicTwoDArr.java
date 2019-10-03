package interview.questions.coin.pr1;

public class DynamicTwoDArr {

	// Driver Function to test above function 
    public static void main(String args[]) 
    { 
        int arr[] = {2,5,3,6}; 
        int m = arr.length; 
        int n = 10; 
        System.out.println(count(arr, m, n)); 
    } 
    
	//Write CPP code here 
	public static int count( int S[], int m, int n )  
	{  
	     //we need a two dimensional matrix to store the result 
	    int[][] table =new int[m+1][n+1];  
	    
	    // Base case (If given value is 0)  
	    for(int i=0;i<m;i++) {
	    	table[0][i] = 1;  
	   } 
	      
	    for(int i=1;i<=m;i++) {
	    	for(int j=1;j<=n;j++) { 
	              if(S[i-1]>j){ 
	                  table[i][j]=table[i-1][j]; 
	              } else
	              { 
	                  table[i][j]=table[i-1][j]+table[i][j-(i-1)]; 
	              } 
	                
	          } 
	      } 
	    return table[m][n];  
	} 

	// NOT WORKING PROPERLY
}
