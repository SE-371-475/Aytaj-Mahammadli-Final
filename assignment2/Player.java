public class Player {
    // numPlayers vairable refers to number of players
    public int numPlayers;

    // constructor method 
    public Player(int teamPlayersCnt){
        this.numPlayers = teamPlayersCnt;
    }

    public static void main(String[] args) {
        // creating an object from the Player class
        Player teamPlayers = new Player(11);

        // printing the number of players in the team
        System.out.println("Number of players in the team: " + teamPlayers.numPlayers);
    }
}