Coin Change Problem:

Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are 
five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

1) Optimal Substructure
2) Overlapping Subproblems
Both are the properties of Dynamic Programming

							  C({1,2,3}, 5)                     
                           /                 \    
                         /                    \                  
             C({1,2,3}, 2)                      C({1,2}, 5)
            /       \                        /               \         
           /         \                      /                 \   
C({1,2,3}, -1)  C({1,2}, 2)           C({1,2}, 3)             C({1}, 5)
               /    \                  /        \              /       \
             /       \                /          \            /         \
    C({1,2},0)  C({1},2)          C({1,2},1)     C({1},3)    C({1}, 4)  C({}, 5)
                   /   \               / \            /\         /     \         
                  /     \             /   \          /  \       /       \  
          C({1},1)   C({},2) C({1,2},-1) C({1},1)    C({1}, 3) C({}, 4)
            /  \                         /   \ 
           /    \                       /     \   
     C({1},0)  C({},1)             C({1},0) C({},1)       
     
     
      //	ANALYSE THIS TO GET SOLUTION
//	0 1 2 3 4 5 6 7 8 9 10 11 12
//	1 0 0 0 0 0 0 0 0 0 0  0  0
//	1 0 0 0 0 1 0 0 0 0 1  0  0
//	1 0 0 0 0 1 0 0 0 0 2  0  0
//	1 1 1 1 1 2 2 2 2 2 4  4  4  (10,5,1)
//	1 0 1 0 1 1 1 1 1 1 3  1  3  (10,5,2)
//	1 0 0 1 0 1 1 0 1 1 2  1  1  (10,5,3)
//	1 0 0 0 1 1 0 0 1 1 2  0  1  (10,5,4)                 .      .