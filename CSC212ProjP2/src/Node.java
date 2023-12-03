/*************Example***************
CLASS: Node.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
8-10-2023
TEAM:
IT PhoneBook
AUTHORS:
meshari al-harbi , (443102229)
saud al-dossaari (441102913)
Omar al-juwayr (443101385)

***********************************/
public class Node {
    public Event data;
    public Node next;
    public Node previous;

    public Node() {
    } 

    public Node(Event data) {
        this.data = data;
    }

    public Node(Event data, Node next, Node previous) {
        this.data = data; 
        this.next = next; 
        this.next = previous; 
    }



}