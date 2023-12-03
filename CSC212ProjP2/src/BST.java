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


	/*
	 * 
	 * 
	 */
	public boolean findkey(String tkey) {
		BSTNode p = root,q = root;
		if(empty())
		return false;
		while(p != null) {
		q = p;
		if(p.key.compareTo(tkey) == 0) {
		current = p;
		return true;
		}
		else if(tkey.compareTo(p.key) < 0)
		p = p.left;
		else
		p = p.right;
		}
		current = q;
		return false;
		}

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
		BSTNode p;
		BSTNode q = current;
		if (findkey(k)) {
			current = q;
			return false;
		}
		p = new BSTNode(k, val);
		if (empty()) {
			root = current = p;
			return true;
		} else {
			if (k.compareTo(current.key) < 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}

	}

	public boolean remove(String tkey) {// remove node
		Boolean removed = new Boolean(false);
		BSTNode p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		return removed;
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

	public boolean update(String key, Contact data) {
		String key1 = key;
		removeKey(key1);
		return insert(key1, data);
	}

	// Method removeKey: iterative
	public boolean removeKey(String k) {
		// Search
		String k1 = k;
		BSTNode p = root;
		BSTNode q = null; // Parent of p

		while (p != null) {
			if (k1.compareTo(p.key) < 0) {
				q = p;
				p = p.left;
			} else if (k1.compareTo(p.key) > 0) {
				q = p;
				p = p.right;
			} else {
				// Found the key
				// Check the three cases
				if ((p.left != null) && (p.right != null)) {
					// Case 3: two children
					// Search for the min in the right subtree
					BSTNode min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}
				// The subtree rooted at p will change here
				if (p.left != null) {
					// One child
					p = p.left;
				} else {
					// One or no children
					p = p.right;
				}
				if (q == null) {
					// No parent for p, root must change
					root = p;
				} else {
					if (k1.compareTo(q.key) < 0) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				current = root;
				return true;
			}
		}
		return false; // Not found
	}

	 public boolean Searchnumber(String num)  
	    {  
	        return Searchnumberrec (root, num);  
	    }  
	    private boolean Searchnumberrec (BSTNode p, String num)  
	    {  
	        if (p == null)  
	            return false;  
	        else if (((Contact)p.data).compareToPhone(num) == 0)  
	        {  
	            current = p;  
	              
	            return true;  
	        }  
	          
	        return (Searchnumberrec(p.left , num) || Searchnumberrec(p.right, num));  
	    }  
 
	    public boolean SearchEmail(String email)  
	    {  
	        return SearchEmail_rec (root, email);  
	    }  
	    private boolean SearchEmail_rec (BSTNode p, String email)  
	    {  
	        if (p == null)  
	            return false ;  
	          
	        else if (((Contact)p.data).compareToEmail(email) == 0) {
	        	current = p ;
	        	return true;
	        }
	        	
	          
	        return (SearchEmail_rec(p.left , email)||SearchEmail_rec(p.right, email));    
	    }   
	    public boolean SearchAddress(String address)  
	    {  
	        return SearchAddress_rec (root, address);  
	    }  
	    private boolean SearchAddress_rec (BSTNode p, String address)  
	    {  
	        if (p == null)  
	            return false ;  
	        else    if (((Contact)p.data).compareToAddress(address) == 0) {
	            current = p; 
	            return true;
	        }
	          
	        return (SearchAddress_rec(p.left , address)||SearchAddress_rec(p.right, address));  
	    }  
 
	    public boolean SearchBirthday(Date birthday)  
	    {  
	        return SearchBirthday_rec (root, birthday);  
	    }  
	    private boolean SearchBirthday_rec (BSTNode  p, Date birthday)  
	    {  
	        if (p == null)  
	            return false ;  
	        else    if (((Contact)p.data).compareToBirthday(birthday) == 0) {
	        	current = p;
	        	return true;
	        }
	          
	        return (SearchBirthday_rec(p.left , birthday)||SearchBirthday_rec(p.right, birthday));  
	    }   
	  
	}  
