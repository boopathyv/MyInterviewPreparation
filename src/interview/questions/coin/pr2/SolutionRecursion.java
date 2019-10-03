package interview.questions.coin.pr2;

public class SolutionRecursion {
	
	 public static void main(String args[]) 
	    { 
	       int coins[] =  {2,4,6,8,10,12,14,16,18,20}; 
	       int m = coins.length; 
	       int V = 20; 
	       System.out.println("Minimum coins required is "+ minCoins(coins, m, V) ); 
	    } 
	 
	 // m is size of coins array (number of different coins) 
    static int minCoins(int coins[], int m, int V) 
    { 
       // base case 
       if (V == 0) return 0; 
       
       // Initialize result 
       int res = Integer.MAX_VALUE; 
       
       // Try every coin that has smaller value than V 
       for (int i=0; i<m; i++) 
       { 
         if (coins[i] <= V) 
         { 
             int sub_res = minCoins(coins, m, V-coins[i]); 
       
             // Check for INT_MAX to avoid overflow and see if 
             // result can minimized 
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
                res = sub_res + 1; 
         } 
       } 
       return res; 
    } 
   
}
