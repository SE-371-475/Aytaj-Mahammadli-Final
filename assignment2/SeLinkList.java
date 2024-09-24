public class SeLinkList{
    public SeLinkList next; //reference to next node
    public int a, b, c;


    // Constructor method
    public SeLinkList(int val1, int val2, int val3) {
        this.a = val1;
        this.b = val2;
        this.c = val3;
        this.next = null; // by default it is assigned to null
    }

    public static void main(String[] args){
        //  n1 and n2 refer to nodes, fist node and second node
        // creating n1 and n2 objects from the SeLinkList class
        SeLinkList n1 = new SeLinkList(7, 8, 9);
        SeLinkList n2 = new SeLinkList(10, 11, 12);

        // connecting initial node with the next node by using 'next'
        n1.next = n2;

        // printing the values of the first and second nodes 
        System.out.println("Printing n1 values:\n" + n1.a + "\n" + n1.b + "\n" + n1.c);
        System.out.println("Printing n2 values:\n" + n2.a + "\n" + n2.b + "\n" + n2.c);
    }
}