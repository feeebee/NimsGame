import java.util.Scanner;
public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);
    private int number = 0;

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        pieces = (int) (Math.random()*41)+10;//To Do: Grab a random value between 10 and 50
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        int take = 0;
        System.out.println("There are "+ pieces+" pieces remaining!");
        number +=1;
        if (number%2 != 0){
            System.out.println(p1.getName()+ ", how many pieces do you want to remove?");
        }
        if (number%2 ==0){
            System.out.println(p2.getName()+ ", how many pieces would you like to remove?");
        }
        take = sc.nextInt();
       //TO DO: Grab the user amount of pieces and repeat if it not allowed.
        while (!isLegal(take)){
            System.out.println("you can not take "+ take +" pieces. Choose again");
            take = sc.nextInt();
        }
        if(isLegal(take)){
            pieces = pieces-take;
        }
        //TO DO: Adjust the pieces
        if (number%2 != 0){
            p1.adjustScore(take); 
        }
        else if (number%2 == 0){
            p2.adjustScore(take);
        }
        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        return take;
    }

    
    //**TO DO**//
    public Player getNextPlayer(){
    if (currentPlayer.equals(p1)){
        currentPlayer = p2;
    }
    else{
        currentPlayer = p1;
    } 
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        if (x<=0){
            return false;
        }
        if (pieces ==1){
            if (x == 1){
                return true;
            }
        }
        else if (pieces/2 >= x){
            return true;
        }
        if (pieces/2<= x){
            return false;
        }
        if (x<=0){
            return false;
        }
        return false;
    }


    //DO NOT CHANGE
    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }

}
