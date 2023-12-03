/*************Example***************
CLASS: LinkedList.java
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
25-11-2023
TEAM:
IT PhoneBook
AUTHORS:
meshari al-harbi , (443102229)
saud al-dossaari (441102913)
Omar al-juwayr (443101385)

***********************************/
public class LinkedList{
    private Node head;
    private Node current;
	public Node previous;

    public LinkedList() {
        head = current = null; //1
    }

    public boolean empty() {
        return head == null; //1
    }

    public boolean full() {
        return false; //1
    }

    public boolean last() {
        return current.next == null;//1
    }

    public void findFirst() {
        current = head; //1
    }
	public boolean findlast() {
		return current == null;
	}

  
    public void findNext() {
        current = current.next;//1
    }
    public void findPrevious() {
        current = current.previous;//1
    }
    public Event retrieve() {
        return (Event) current.data; //1
    }



 /*
  * 
  * 
  */

	public boolean insert(Event val) {// add to the list
		Node tmp = new Node(val);// O(1)
		if (empty()) //1
			head = current = new Node(val);// O(1)
		else {//1
			if (head.data.compareTo(val) > 0) {//(1) that conditon to save the alphabet if 
				tmp.next = head;        //1           // if > 0 become before the node 
				head = tmp;           //1               //if == that his place
				                                     // if < become after the node
			} else {//1
				current = head;//1
				while ((current != null) && (current.data.compareTo(val) <= 0)) {// O(n)
					previous = current; //n
					current = current.next;//n
				}
				if (current != null) {//1
					tmp.next = current;//1
					previous.next = tmp;//1
					current = tmp;//1
				} else {//1
					current = previous.next = tmp;//1
				}
			}
		}
		return true;//1
	}
	// 3n + 15 O(n)
	public boolean search(Event val) {
		if (empty()) {//1
			return false;//1
		}
		Node object = head;//1
		while ((object != null) && (object.data.compareTo(val) != 0)) //2n
			object = object.next; //n
		if ((object != null) && (object.data.compareTo(val) == 0)) { //2
			current = object;//1
			return true;//1
		}
		return false;//1
	}
	// 3n + 7
	public Event remove(Event val) {// remove node
		if (search(val) == false) { //n
			return null;//1
		}
		Event data = current.data;//1
		if (current == head)//1
			head = head.next;//1
		else {//1
			Node tmp = head;//1
			while (tmp.next != current)//n
				tmp = tmp.next;//n
			tmp.next = current.next;//n
		}
		if (current.next == null) //1
			current = head;//1
		else//1
			current = current.next;//1
		return data;//1

	}
    //4n + 11 O(n)
    
    
}