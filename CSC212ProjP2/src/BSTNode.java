/*************Example***************
CLASS: Node.java
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
28-11-2023
TEAM:
IT PhoneBook
AUTHORS:
meshari al-harbi , (443102229)
saud al-dossaari (441102913)
Omar al-juwayr (443101385)

***********************************/
public class BSTNode<T> {
    public T data;
    public String key;
    public BSTNode<T> left,right;

    public BSTNode(String k, T data) {
        this.data = data;
        key = k;
        left = right = null;
    }
    public BSTNode(String k, T data, BSTNode<T> l, BSTNode<T> r) {
        this.data = data;
        key = k;
        left = l;
        right = r;
    }



}