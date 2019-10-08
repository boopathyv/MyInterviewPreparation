package interview.questions.general;

public class DayOfTheWeek {
	static int dayofweek(int d, int m, int y) 
	{ // https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
	    int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
	    y -= (m < 3) ? 1 : 0; 
	    return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; 
	} 
	  
	// Driver Program to test above function 
	public static void main(String arg[]) 
	{ 
	    int day = dayofweek(4, 3, 2020); 
	    String result = "";
	    switch(day){
	    case 0:result="SUNDAY";break;
	    case 1:result="MONDAY";break;
	    case 2:result="TUESDAY";break;
	    case 3:result="WEDNESDAY";break;
	    case 4:result="THURSDAY";break;
	    case 5:result="FRIDAY";break;
	    case 6:result="SATURDAY";break;
	    }
	    System.out.print(result); 
	} 
}
