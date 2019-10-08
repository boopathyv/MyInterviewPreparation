package interview.codinground.striim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProgramOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solve(new int[]{4,5,1,2,3});
	}

	static List<List<Integer>> Solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int checkFor = arr.length;
        Set<Integer> inputSet = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++){
            List<Integer> innerresult = new ArrayList<Integer>();
            inputSet.add(arr[i]);
            if(arr[i] == checkFor){
                int size = inputSet.size();
                for(int j=0; j< size; j++,checkFor--){
                    if(inputSet.contains(checkFor)){
                        innerresult.add(checkFor);
                        inputSet.remove(checkFor);
                    }else{
                        break;
                    }
                }
            }
            result.add(innerresult);
        }
        return result;
    }
}
