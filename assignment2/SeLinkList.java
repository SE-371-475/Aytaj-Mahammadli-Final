public class SeLinkList{
    public SeLinkList next; //reference to next node
    public SeLinkList prev; //reference to previous node
    // variables describe the index and values of node
    public int a, b, c;
    public int ind;

    // Constructor method
    public SeLinkList(int val1, int val2, int val3, int ind) {
        this.a = val1;
        this.b = val2;
        this.c = val3;
        this.ind = ind;
        this.next = null; // by default it is assigned to null
        this.prev = null; // by default it is assigned to null
    }

    // overloading constructor to give a default value for ind property
    public SeLinkList(int val1, int val2, int val3) {
        this(val1, val2, val3, -1); 
    }

    public static void main(String[] args){
        //  n1 and n2 refer to nodes, fist node and second node
        // creating n1 and n2 objects from the SeLinkList class
        SeLinkList n1 = new SeLinkList(7, 8, 9, 0);
        SeLinkList n2 = new SeLinkList(10, 11, 12, 1);

        // connecting initial node with the next node by using 'next'
        n1.next = n2;
        // connecting the node with the prev node by using 'prev'
        n2.prev = n1;

        // printing the values of the first and second nodes 
        System.out.println("Printing n1 values at index " + n1.ind + ":\n" + n1.a + "\n" + n1.b + "\n" + n1.c);
        System.out.println("Printing n2 values at index " + n2.ind + ":\n"  + n2.a + "\n" + n2.b + "\n" + n2.c);
    }
}