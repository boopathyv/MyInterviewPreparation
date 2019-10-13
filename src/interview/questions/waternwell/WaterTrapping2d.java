package interview.questions.waternwell;

import java.util.PriorityQueue;

public class WaterTrapping2d {
	
	public static void main(String[] args) {
//		int[][] inputArray = new int[][] {
//		  {12,13,1,12},
//		  {13,4,13,12},
//		  {11,8,10,12},
//		  {12,13,12,12},
//		  {13,13,13,13}
//		}; // 14
		
		int[][] inputArray = new int[][] {
			  {0,1,1,1,0},
			  {1,0,1,0,1},
			  {1,0,0,0,1},
			  {1,1,1,1,1}
			}; // 14
		System.out.println("unit.."+trapRainWater(inputArray));
	}

	
	public static int trapRainWater(int[][] heightMap) {
        int row=heightMap.length;
        if(row==0)
                return 0;
        int col=heightMap[0].length;
        
        boolean[][] visited=new boolean[row][col];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
/*
a[0]-b[0] for asc order of priority and 0 is bcz I'll be storing height in index 0
and i in index1 and j in index 2
input all border cells first
*/
        for(int i=0;i<row;i++)
        {
            minHeap.add(new int[] {heightMap[i][0],i,0});
            minHeap.add(new int[] {heightMap[i][col-1],i,col-1});
            visited[i][0]=true;
            visited[i][col-1]=true;
        }
        
        for(int j=1;j<col-1;j++)
        {
            minHeap.add(new int[] { heightMap[0][j],0,j});
            minHeap.add(new int[] { heightMap[row-1][j],row-1,j});
            visited[0][j]=true;
            visited[row-1][j]=true;
        }
        
		// while(!minHeap.isEmpty())
		// {
		//    int[] curCell=minHeap.poll();
		//    System.out.print(curCell[0]);
		//    System.out.print(" ");
		// }

        /*
		now visiting all the non-visited cells
		starting with the minimum boundary
		why minimum?  Because cell1 depends on its adjacent cells
		for min boundary
		and those adjacent cells further depend on their adjacent
		cells for min boundary..         
		and hence starting with min boundary and covering all possible adjcaent cells
		to the min boundary and keep increasing the value of min
		boundary 
		make sure all the adjacent (L,R,T,B) cells are visited
		*/        
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        int curMax=0,res=0;
        while(!minHeap.isEmpty())
        {
            int[] curCell=minHeap.poll();
            System.out.print(curCell[0]);
            System.out.print(" ");
            curMax=Math.max(curMax,curCell[0]); 
//height is stored in 0 index
            for(int[] dir: dirs)
            {
                int i=curCell[1]+dir[0];
                int j=curCell[2]+dir[1];
                if(i>=0 && i<row && j>=0 && j<col &&
                visited[i][j]==false)
                {
                    if(curMax> heightMap[i][j])
                        res+=curMax-heightMap[i][j];
                    minHeap.add(new int[] {heightMap[i][j],i,j});
                    visited[i][j]=true;
                }
                
            }
        }
        return res;
        
    }
}
