import java.util.Date;

/*************
 * Example*************** CLASS: LinkedList.java CSC212 Data structures -
 * Project phase I Fall 2023 EDIT DATE: 12-10-2023 TEAM: IT PhoneBook AUTHORS:
 * meshari al-harbi , (443102229) saud al-dossaari (441102913) Omar al-juwayr
 * (443101385)
 * 
 ***********************************/
public class BST {
	public BSTNode root;
	public BSTNode current;

	public BST() {
		root = current = null; // 1
	}

	public void findRoot() {
		current = root;
	}

	public BSTNode getRoot() {
		return root;
	}

	public boolean empty() {
		return root == null; // 1
	}

	public boolean full() {
		return false; // 1
	}

	public Contact retrieve() {
		return (Contact) current.data; // 1
	}


	public boolean findkey(String tkey) {
		BSTNode p = root,q = root; //1
		if(empty())//1
		return false;//1
		while(p != null) {//n+1
		q = p;//n
		if(p.key.compareTo(tkey) == 0) {//n
		current = p;//n
		return true;//n
		}
		else if(tkey.compareTo(p.key) < 0)//n
		p = p.left;//n
		else//n
		p = p.right;//n
		}
		current = q;//1
		return false;//1
		}
	// 8n + 6 O(n)
	public Contact searchbyName(String tkey) {
		BSTNode p = root, q = root;
		if (empty())
			return null;
		while (p != null) {
			q = p;
			if (p.key.compareTo(tkey) == 0) {
				current = p;
				return (Contact) current.data;
			} else if (tkey.compareTo(p.key) < 0)
				p = p.left;
			else
				p = p.right;
		}
		current = q;
		return null;
	}

	public boolean insert(String k, Contact val) {
		BSTNode p;//1
		BSTNode q = current;//1
		if (findkey(k)) {//logn
			current = q;//1
			return false;//1
		}
		p = new BSTNode(k, val);//logn
		if (empty()) {//1
			root = current = p;//1
			return true;//1
		} else {//1
			if (k.compareTo(current.key) < 0)//1
				current.left = p;//1
			else//1
				current.right = p;//1
			current = p;//1
			return true;//1
		}

	}
	// 2logn + 14 O(logn)
	
	public boolean remove(String tkey) {// remove node
		Boolean removed = new Boolean(false); //1
		BSTNode p;//1
		p = remove_aux(tkey, root, removed);
		current = root = p;//1
		return removed;//1
	}

	private BSTNode remove_aux(String key, BSTNode p, Boolean flag) {
		BSTNode q, child = null;
		if (p == null)
			return null;
		if (key.compareTo(p.key) < 0)
			p.left = remove_aux(key, p.left, flag); // go left
		else if (key.compareTo(p.key) > 0)
			p.right = remove_aux(key, p.right, flag); // go right
		else {
			flag = true;
			if (p.left != null && p.right != null) { // two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			} else {
				if (p.right == null) // one child
					child = p.left;
				else if (p.left == null) // one child
					child = p.right;
				return child;
			}
		}
		return p;
	}

	private BSTNode find_min(BSTNode p) {
		if (p == null)
			return null;

		while (p.left != null) {
			p = p.left;
		}

		return p;
	}

	
	
	 public boolean Searchnumber(String num)  
	    {  
	        return Searchnumberrec (root, num);  //O(n)
	    }  
	    private boolean Searchnumberrec (BSTNode p, String num)  
	    {  
	        if (p == null)  //O(1)
	            return false;  //O(1)
	        else if (((Contact)p.data).compareToPhone(num) == 0)  //O(1)
	        {  
	            current = p;  //O(1)
	              
	            return true;  //O(1)
	        }  
	          
	        return (Searchnumberrec(p.left , num) || Searchnumberrec(p.right, num));  //O(n)
	    }  //Time Complexity n+5

	    public boolean SearchEmail(String email)  
	    {  
	        return SearchEmail_rec (root, email);  //O(n)
	    }  
	    private boolean SearchEmail_rec (BSTNode p, String email)  
	    {  
	        if (p == null)  //O(1)
	            return false ;   //O(1)
	          
	        else if (((Contact)p.data).compareToEmail(email) == 0) { //O(1)
	        	current = p ; //O(1)
	        	return true; //O(1)
	        }
	        	
	          
	        return (SearchEmail_rec(p.left , email)||SearchEmail_rec(p.right, email));   //O(n)  
	    }   //Time Complexity n+5
	    public boolean SearchAddress(String address)  
	    {  
	        return SearchAddress_rec (root, address);//O(n)  
	    }  
	    private boolean SearchAddress_rec (BSTNode p, String address)  
	    {  
	        if (p == null)  //1
	            return false ; //1 
	        else    if (((Contact)p.data).compareToAddress(address) == 0) {//1
	            current = p; //1
	            return true;//1
	        }
	          
	        return (SearchAddress_rec(p.left , address)||SearchAddress_rec(p.right, address));  //O(n)
	    }  
	  //Time Complexity n+5
	    public boolean SearchBirthday(Date birthday)  
	    {  
	        return SearchBirthday_rec (root, birthday);//O(n)  
	    }  
	    private boolean SearchBirthday_rec (BSTNode  p, Date birthday)  
	    {  
	        if (p == null)  //1
	            return false ; //1 
	        else    if (((Contact)p.data).compareToBirthday(birthday) == 0) {//1
	        	current = p;//1
	        	return true;//1
	        }
	          
	        return (SearchBirthday_rec(p.left , birthday)||SearchBirthday_rec(p.right, birthday));  //O(n)
	      //Time Complexity n+5
	    }   
	  
	}  
