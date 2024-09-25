public class Player {
    // numPlayers variable refers to the number of players
    public int numPlayers;

    // head points to the initial node 
    private SeLinkList head;
    private int currentIndex; // Track the current index for nodes

    // constructor method - modified
    public Player(int teamPlayersCnt) {
        this.numPlayers = teamPlayersCnt;
        this.head = null; // we set our initial node as null
        this.currentIndex = 0; // Initialize index
    }

    // addPlayer() method to add 
    public void addPlayer(int a, int b, int c) {
        // defining our next node with the current index
        SeLinkList nextNode = new SeLinkList(a, b, c, currentIndex);
        nextNode.next = head;
        nextNode.prev = null;
        if(head != null){ // it means it is not a starting point and its prev is not null
            head.prev = nextNode;
        }
        // updating head by assigning nextNode's value to the initial node
        head = nextNode;
        currentIndex++; 
    }

    // initializeList() method which takes array of players and pass each player's data to addPlayer() method as an argument
    public void initializeList(PlayerData[] playersArr) {
        for (int i = 0; i < playersArr.length; i++) {
            addPlayer(playersArr[i].a, playersArr[i].b, playersArr[i].c);
        }

        System.out.println("Total number of participants in the list is " + playersArr.length);
    }

    // Method to find the node with the maximum weight
    public void findMaxWeight() {
        SeLinkList presentNode = head;
        SeLinkList nodeWithMaxWeight = null; // node with the highest weight
        int indOfMaxNode = -1; // index of the node with the highest weight
        int maxWeight = Integer.MIN_VALUE; // we define maxWeight in which we can compare and store the max weight value later
        
    
        while (presentNode != null) {
            int totalWeight = presentNode.a + presentNode.b + presentNode.c;
            if (totalWeight > maxWeight) { // if total weight is higher than our max weight, we update our max weight, node and its index
                maxWeight = totalWeight;
                nodeWithMaxWeight = presentNode;
                indOfMaxNode = presentNode.ind; 
            }
            presentNode = presentNode.next; 
        }

        if (nodeWithMaxWeight != null) {
           // printing max weight after looping whole array and finding the heighest weight
            System.out.println("Max weight player >> Node (index: " + indOfMaxNode + ", its values: " + nodeWithMaxWeight.a + ", " + nodeWithMaxWeight.b + ", " + nodeWithMaxWeight.c + ") and its weight: " + maxWeight);
        }
    }

    // removeNode() method to remove nodes based on index
    public void removeNode(int ind) {
        if (head == null) {
            System.out.println("Uppps, we can't remove, because node doesn't exist");
            return; // return the program
        }

        SeLinkList presentNode = head;

        if (ind == 0) { // it refers to head, meaning we re standing in head now
            head = head.next; // assigning the next one to head
            if (head != null) {
                head.prev = null; 
            }
            System.out.println("Congratsss, the first node was deleted!");
            return; // return the program
        }

        // looping to see if there are potential nodes to be deleted
        for (int i = 0; presentNode != null && i < ind; i++) {
            presentNode = presentNode.next;
        }

        // after looping if there is no presentNode, print that 'nothing remains to be deleted'
        if (presentNode == null) {
            System.out.println("Sorry, nothing remains to be releted...");
            return; // return the program
        }

        // If previous node before presentNode is not null, it means it is not the last node in the queue
        if (presentNode.prev != null) {
            presentNode.prev.next = presentNode.next; // skipping the the present node
        }
        if (presentNode.next != null) { 
            presentNode.next.prev = presentNode.prev; // skipping the the present node
        }

        System.out.println("Deleted values of the node: " + presentNode.a + ", " + presentNode.b + ", " + presentNode.c);
    }

    // findMinWeight() method to identify the lowest weight
    public void findMinWeight() {
        SeLinkList presentNode = head;
        SeLinkList nodeWithMinWeight = null; // node with the lowest weight
        int indOfMinNode = -1; // index of the node with the lowest weight
        int minWeight = Integer.MAX_VALUE; // we define minWeight in which we can compare and store the min weight value later

        while (presentNode != null) {
            int totalWeight = presentNode.a + presentNode.b + presentNode.c;
            if (totalWeight < minWeight) { // if total weight is lower than our min weight, we update our min weight, node and its index
                minWeight = totalWeight;
                nodeWithMinWeight = presentNode;
                indOfMinNode = presentNode.ind;
            }
            presentNode = presentNode.next; 
        }

        if (nodeWithMinWeight != null) {
            System.out.println("Min weight player >> Node (index: " + indOfMinNode + ", its values: " + nodeWithMinWeight.a + ", " + nodeWithMinWeight.b + ", " + nodeWithMinWeight.c + ")");
        }
    }

    // findMinMaxWeight() method to find both MIN and MAX weights together
    public void findMinMaxWeight() {
        SeLinkList presentNode = head;
        SeLinkList nodeWithMinWeight = null; // node with the lowest weight
        SeLinkList nodeWithMaxWeight = null; // node with the highest weight
        int indOfMinNode = -1; // index of the node with the lowest weight
        int indOfMaxNode = -1; // index of the node with the highest weight
        int minWeight = Integer.MAX_VALUE; // we define minWeight in which we can compare and store the min weight value later
        int maxWeight = Integer.MIN_VALUE; // we define maxWeight in which we can compare and store the max weight value later

        // filtering the list and comparing values with each other to find MIN and MAX
        while (presentNode != null) {
            int totalWeight = presentNode.a + presentNode.b + presentNode.c;

            // if total weight is lower than our min weight, we update our min weight, node and its index
            if (totalWeight < minWeight) {
                minWeight = totalWeight;
                nodeWithMinWeight = presentNode;
                indOfMinNode = presentNode.ind;
            }

            // if total weight is higher than our max weight, we update our max weight, node and its index
            if (totalWeight > maxWeight) {
                maxWeight = totalWeight;
                nodeWithMaxWeight = presentNode;
                indOfMaxNode = presentNode.ind;
            }

            presentNode = presentNode.next; 
        }

        if (nodeWithMinWeight != null && nodeWithMaxWeight != null) {
            System.out.println("<<<<<<< Finding MIN and MAX values in one method >>>>>>>");
            System.out.println("Min weight player >> Node (index: " + indOfMinNode + ", its values: " + nodeWithMinWeight.a + ", " + nodeWithMinWeight.b + ", " + nodeWithMinWeight.c + ") and its weight: " + minWeight);
            System.out.println("Max weight player >> Node (index: " + indOfMaxNode + ", its values: " + nodeWithMaxWeight.a + ", " + nodeWithMaxWeight.b + ", " + nodeWithMaxWeight.c + ") and its weight: " + maxWeight);
        }
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

        // Task 9 - added part
        teamPlayers.findMaxWeight();


        // Task 12 - added part
        teamPlayers.removeNode(0); // deleting the first node

        // Task 13 - added part
        teamPlayers.findMinWeight();

        // Task 14 - added part
        teamPlayers.findMinMaxWeight();
    }
}
