package interview.codinground.kaleidofin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Source {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer,Queue<Integer>> stackMap = new HashMap<>();
		int lowestNo = Integer.MAX_VALUE;
		int start = n;
		for(int i=0; i<m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(lowestNo > a) {
					lowestNo = a;
				}
				if(!stackMap.containsKey(b)) {
					stackMap.put(b, new LinkedList<>());
				}
				stackMap.get(b).add(a);
		}
		List<Integer> outputList = new ArrayList<>();
		outputList.add(start);
		Queue<Integer> queue = stackMap.get(start);
		int size = queue.size();
		if(queue != null) {
			for (int i = 0; i < size; i++) {
				int head = queue.remove();
				getOutput(outputList,stackMap,head,lowestNo);
			}
		}
		outputList.add(lowestNo);
		Collections.reverse(outputList);
		String output = outputList.toString().replace("[", "").replace("]", "").replace(",", "");
		System.out.println(output);
	}

	private static void getOutput(List<Integer> outputList, Map<Integer, Queue<Integer>> stackMap, int start,
			int lowestNo) {
		if(start != lowestNo  && !outputList.contains(start)) {
			outputList.add(start);
		}
		Queue<Integer> queue = stackMap.get(start);
		if(queue != null) {
			int size = queue.size();
			if(size > 0) {
				int head = queue.remove();
				getOutput(outputList,stackMap,head,lowestNo);
			}
		}
		
	}
}
