public class Player {
    private int score = 0;
    private String name;

    //DO NOT CHANGE
    public Player(String name){

        this.name = name;
        System.out.println("-----------------------------");
    }

    //TO DO
    //returns player's score
    public int getScore(){ 
     return score;
    }
    //TO DO
    //returns player's name
    public String getName(){
        return name;
      
    }
    //adds to player's score
    public void adjustScore(int x){
        score +=x;
    }
}
