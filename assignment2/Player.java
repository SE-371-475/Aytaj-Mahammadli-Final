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

        // creating an object from PlayerData class
        PlayerData playerRecords = new PlayerData();

        // getting players' info arry by calling getMyData() method
        PlayerData[] playerRecordsArr = playerRecords.getMyData();

        // printing each object data of the array
        for (int i = 0; i < playerRecordsArr.length; i++) {
            PlayerData eachPlayerObj = playerRecordsArr[i];
            System.out.println("Player number " + (i + 1) + ": " + eachPlayerObj.a + " "+ eachPlayerObj.b + " " + eachPlayerObj.c);
        }
    }
}