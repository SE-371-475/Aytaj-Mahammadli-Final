public class Player {
    // numPlayers variable refers to the number of players
    public int numPlayers;

    // head points to the initial node 
    private SeLinkList head;

    // constructor method - modified
    public Player(int teamPlayersCnt) {
        this.numPlayers = teamPlayersCnt;
        this.head = null; // we set our initial node as null
    }

    // addPlayer() method to add 
    public void addPlayer(int a, int b, int c) {
        // defining our next node
        SeLinkList nextNode = new SeLinkList(a, b, c);
        nextNode.next = head;
        // updating head by assigning nextNode's value to the initial node
        head = nextNode;
    }

    // initializeList() method which takes array of players and pass each player's data to addPlayer() method as an argument
    public void initializeList(PlayerData[] playersArr) {
        for (int i = 0; i < playersArr.length; i++) {
            addPlayer(playersArr[i].a, playersArr[i].b, playersArr[i].c);
        }

        System.out.println("Total number of participants in the list is " + playersArr.length);
    }


    public static void main(String[] args) {
        // creating an object from the Player class
        Player teamPlayers = new Player(11);

        // printing the number of players in the team
        System.out.println("Number of players in the team: " + teamPlayers.numPlayers);

        // creating an object from PlayerData class
        PlayerData playerRecords = new PlayerData();

        // getting players' info array by calling getMyData() method
        PlayerData[] playerRecordsArr = playerRecords.getMyData();

        // printing each object data of the array
        for (int i = 0; i < playerRecordsArr.length; i++) {
            PlayerData eachPlayerObj = playerRecordsArr[i];
            System.out.println("Player number " + (i + 1) + ": " + eachPlayerObj.a + " " + eachPlayerObj.b + " " + eachPlayerObj.c);
        }

        // -------------------------------------------------------------------------------------
        // TASK 7 - new added parts
        // in every addPlayer() call, it maintains one node which is linked to another
        teamPlayers.addPlayer(5, 15, 25);
        teamPlayers.addPlayer(7, 17, 27);

        // printing each player node in order
        SeLinkList presentNode = teamPlayers.head; // making our present node head and beginning from this point
        for (int playerOrder = 1; presentNode != null; playerOrder++) {
            System.out.println("Number " + playerOrder + " Player: " + presentNode.a + " " + presentNode.b + " " + presentNode.c);
            presentNode = presentNode.next; // updating our current position in node
        }

        // -------------------------------------------------------------------------------------
        // Task 8 - added part
        teamPlayers.initializeList(playerRecordsArr);
    }
}
