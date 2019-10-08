package interview.codinground.pickyourtrail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramThree {

	public static void main(String[] args) {
		System.out.println((int)'a');
		System.out.println((char)97);
	}
	
	 public static char slowestKey(List<List<Integer>> keyTimes) {
	        Map<Integer,Character> map = new HashMap();
	        List<Integer> inputList = new ArrayList();
	        for(int i=0; i< keyTimes.size(); i++){
	            List<Integer> list= keyTimes.get(i);
	            map.put(list.get(0),(char)(list.get(0)+97));
	            inputList.add(list.get(1));
	        }
	        if(!inputList.isEmpty()){
	            int previous = inputList.get(0);
	            int current = 0;
	            for(int i=1; i< inputList.size(); i++){
	                current = inputList.get(i);
	                inputList.set(i, current - previous);
	            }
	            int highest = 0;
	            int resultIndex = 0;
	            for(int i=0; i< inputList.size(); i++){
	                if(inputList.get(i)>highest){
	                    highest = inputList.get(i);
	                    resultIndex = i;
	                }
	            }
	            return map.get(resultIndex);
	        }
	        return 'a';
	    }
}
