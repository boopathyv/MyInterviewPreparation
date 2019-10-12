package interview.questions.zoho.calltaxibookingapp;

public class Taxi {
    char initialPoint;
    int departureTime;
    int earnings;
    public Taxi()
    {
        initialPoint='A';
    }
    public void departureTime(int pickTime,char pick,char drop)
    {
        this.departureTime=(pickTime+(Math.abs(pick-drop)));
    }
    public void calculateEarnings(char pick,char drop)
    {
        int dist=(Math.abs(pick-drop)*15);
        int amount=((dist-5)*10)+100;
        this.earnings=earnings+amount;
    }
       
  
}
