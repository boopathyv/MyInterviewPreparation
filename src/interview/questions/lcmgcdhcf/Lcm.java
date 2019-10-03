package interview.questions.lcmgcdhcf;

import java.sql.Timestamp;

public class Lcm {

	public static void main(String[] args) {
		Timestamp stmp = new Timestamp(System.currentTimeMillis());
		int[] array = new int[]{2,7,5,9,3,20,40,60,80,16,8,12,4};
		System.out.println(stmp);
		
		mine(array);
	
		stmp = new Timestamp(System.currentTimeMillis());
		System.out.println(stmp);
		array = new int[]{2,7,5,9,3,20,40,60,80,16,8,12,4};
		stmp = new Timestamp(System.currentTimeMillis());
		System.out.println(stmp);
		
		System.out.println("Efficient.."+efficient(array));
		
		stmp = new Timestamp(System.currentTimeMillis());
		System.out.println(stmp);
	}
	
	// still not working
	private static long efficient(int[] array){
		
		long lcm = 1;
		int divisor = 2;
		while(true){
			int counter = 0;
			boolean divisible = false;
			for (int i = 0; i < array.length; i++) {
				if(array[i] == 0){
					return 0;
				}else if(array[i]<0){
					array[i] = array[i]*(-1);
				}
				if(array[i] == 1){
					counter++;
				}
				if(array[i] % divisor == 0){
					divisible = true;
					array[i] = array[i]/divisor;
				}
			}
			if(divisible){
				lcm = lcm * divisor;
			}else{
				divisor++;
			}
			if(counter == array.length){
				return lcm;
			}
		}
	}
	
	private static void mine(int[] array) {
		int highest = 0;
		for(int i = 0; i<array.length; i++){
			if(highest<array[i]){
				highest = array[i];
			}
		}
		
		int lcm = 1;
		for (int i = 2; i < highest/2+1; i++) {
			if(i==2 || i%2 !=0){
				boolean flag = false;
				for	(int j = 0; j < array.length; j++) {
					if((array[j]/i)>=1){
						if(array[j]%i == 0){
							array[j] = array[j]/i;
							flag = true;
						}
					}
				}
				if(flag){
					lcm *= i;
					--i;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			if(array[i]>1){
				lcm *= array[i];
			}
		}
		System.out.println("LCM is "+lcm);
	}
}
