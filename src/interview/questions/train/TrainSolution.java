package interview.questions.train;


public class TrainSolution {

	public static void main(String[] args) {
		int arrival[]   = { 900, 1000,1015, 1100, 1130, 1300, 1525};
		int departure[] = { 930, 1200,1135, 1145, 1215, 1425, 1600};
		
		// after sorting
		arrival   = new int[]{900,1000,1015,1100,1130,1300,1525};
		departure = new int[]{930,1135,1145,1200,1215,1425,1600};
		int arrivalIndex = 0;
		int departureIndex = 0;
		int count = 0;
		int minPlatforms = 0;
		for (int i = 0; i < arrival.length; i++) {
			if(arrival[arrivalIndex]<departure[departureIndex]){
				count += 1;
				arrivalIndex++;
			}else{
				count -= 1;
				departureIndex++;
			}
			if(minPlatforms<count){
				minPlatforms = count;
			}
		}
		System.out.println(minPlatforms);
	}
}
