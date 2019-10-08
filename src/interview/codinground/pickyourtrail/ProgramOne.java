package interview.codinground.pickyourtrail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



class ProgramOne {
	
	public static void main(String[] args) {
		System.out.println((int)'a');
		List<String> lsit1 = new ArrayList<String>();
		lsit1.add("mo sa 45+2 Y");
		lsit1.add("a 13 G");
		List<String> lsit2 = new ArrayList<String>();
		lsit2.add("d 23 S f");
		lsit2.add("z 46 G");
		ProgramOne one = new ProgramOne();
		one.getEventsOrder("abc", "cba", lsit1, lsit2);
	}

    public List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {

        List<Game> gameList = new ArrayList<Game>();
        for(int i=0;i<events1.size();i++){
            Game gameObject = new Game();
            String event = events1.get(i);
            String playerName = "";
            for (int z = 0; z < event.length(); z++) {
                if (Character.isDigit(event.charAt(z))){
                    break;
                } else{
                    playerName += String.valueOf(event.charAt(z));
                }
            }
            event = event.substring(playerName.length());
            playerName = playerName.trim();
            String[] eventArray = event.split(" ");
            gameObject.setTeamName(team1);
            gameObject.setPlayerName(playerName);
            gameObject.setInputTime(eventArray[0]);
            Integer time = getTime(eventArray[0]);
            gameObject.setTime(time);
            gameObject.setEventName(eventArray[1]);

            String oldChar = eventArray[0]+" "+eventArray[1];
            event = event.substring(oldChar.length());
            if(event.trim().length() > 0){
                gameObject.setSecondPlayerName(event.trim());    
            }
            gameList.add(gameObject);
        }
        for(int j=0;j<events2.size();j++){
            Game gameObject = new Game();
            String event = events2.get(j);
            String playerName = "";
            for (int z = 0; z < event.length(); z++) {
                if (Character.isDigit(event.charAt(z))){
                    break;
                } else{
                    playerName += String.valueOf(event.charAt(z));
                }
            }
            event = event.substring(playerName.length());
            playerName = playerName.trim();
            String[] eventArray = event.split(" ");
            gameObject.setTeamName(team2);
            gameObject.setPlayerName(playerName);
            gameObject.setInputTime(eventArray[0]);
            Integer time = getTime(eventArray[0]);
            gameObject.setTime(time);
            gameObject.setEventName(eventArray[1]);
            
            String oldChar = eventArray[0]+" "+eventArray[1];
            event = event.substring(oldChar.length());
            if(event.trim().length() > 0){
                gameObject.setSecondPlayerName(event.trim());    
            }
            gameList.add(gameObject);
        }

        gameList = gameList.stream().sorted(Comparator.comparing(Game::getTime)
                .thenComparing(Game::getEventName).thenComparing(Game::getTeamName)
                .thenComparing(Game::getPlayerName)).collect(Collectors.toList());
        
        List<String> resultList = new ArrayList<String>();
        for(Game game : gameList){
            String result = game.getTeamName()+" "+game.getPlayerName()+" "
                + game.getInputTime()+" "+ game.getEventName();
            if(game.getSecondPlayerName() != null && 
                !game.getSecondPlayerName().isEmpty()){
                result += " "+ game.getSecondPlayerName();
            }
            resultList.add(result);
        }
        return resultList;
    }

    public Integer getTime(String time){
        int result = 0;
        if(time.indexOf("+") != -1){
           String[] timeArr =  time.split("\\+");
           result = Integer.parseInt(timeArr[0]);
        }else{
            result = Integer.parseInt(time);
        }
        return result;
    }

    class Game{
        String teamName;
        String playerName;
        String inputTime;
        Integer time;
        String eventName;
        String secondPlayerName;
        public void setTeamName(String teamName){
            this.teamName = teamName;
        }
        public void setPlayerName(String playerName){
            this.playerName = playerName;
        }
        public void setSecondPlayerName(String secondPlayerName){
            this.secondPlayerName = secondPlayerName;
        }
        public void setTime(Integer time){
            this.time = time;
        }
        public void setInputTime(String inputTime){
            this.inputTime = inputTime;
        }
        public void setEventName(String eventName){
            this.eventName = eventName;
        }
        public String getTeamName(){
            return this.teamName;
        }
        public String getPlayerName(){
            return this.playerName;
        }
        public String getSecondPlayerName(){
            return this.secondPlayerName;
        }
        public Integer getTime(){
            return this.time;
        }
        public String getInputTime(){
            return this.inputTime;
        }
        public String getEventName(){
            return this.eventName;            
        }
    }

}