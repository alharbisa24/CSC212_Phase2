/*************Example***************
CLASS: PhoneBook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
17-10-2023
TEAM:
IT PhoneBook
AUTHORS:
meshari al-harbi , (443102229)
saud al-dossaari (441102913)
Omar al-juwayr (443101385)

***********************************/
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook {
	static BST conts = new BST();
	static LinkedList events = new LinkedList();
	static Scanner input = new Scanner(System.in);


	//method for search contact in list
	public static void Searchcontact() {
		System.out.println("Enter search criteria:"); //1
		System.out.println("1.Name"); //1
		System.out.println("2.Phone Number");//1
		System.out.println("3.Email Address");//1
		System.out.println("4.Address");//1
		System.out.println("5.Birthday");//1
		System.out.print("Enter your choise");//1
		String Choicec = input.nextLine();//1
		

		if (conts.empty())//if contact list is empty (1)
			System.out.println("Contact its empty");//1
		else {// if contact list not empty (1)
			// user choose the serach criteria
			switch (Choicec) {//1
			// if user want search by name
			case "1": {//1
				System.out.print("Enter the contact's name: ");
				String name = input.nextLine();
				if (conts.findkey(name)) {
					System.out.println("Contact found! ");
					System.out.println("Name: " + conts.retrieve().getContact_name());
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());
					System.out.println("Address: " + conts.retrieve().getContact_address());
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());
					System.out.println("Notes: " + conts.retrieve().getContact_notes());
				}else {
				System.out.println("Contact not found!");
				}
			}
				break;//1
				
				// 11n + 30 O(n)
				// if user want search by phone number
			case "2": {
				System.out.print("Enter the contact's Phone number");
				String num = input.nextLine();
				if (conts.Searchnumber(num)) {
					System.out.println("Contact found! ");
					System.out.println("Name: " + conts.retrieve().getContact_name());
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());
					System.out.println("Address: " + conts.retrieve().getContact_address());
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());
					System.out.println("Notes: " + conts.retrieve().getContact_notes());
					
				}else {
				System.out.println("Contact not found!");
				}
			}
				break;//1
				
				// 11n + 15 O(n)
				// if user want search by email address
			case "3": {
				System.out.println("Enter the contact's Email Address: ");
				String em = input.nextLine();
				if (conts.SearchEmail(em)) {
					System.out.println("Contact found! ");
					System.out.println("Name: " + conts.retrieve().getContact_name());
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());
					System.out.println("Address: " + conts.retrieve().getContact_address());
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());
					System.out.println("Notes: " + conts.retrieve().getContact_notes());
					
				}else {
				System.out.println("Contact not found!");
				}
			}
				break;//1
				// 11n + 15 O(n)
				// if user want search by address
			case "4": {
				System.out.print("Enter the contact's Address: ");
				String add = input.nextLine();
				if (conts.SearchAddress(add)) {
					System.out.println("Contact found! ");
					System.out.println("Name: " + conts.retrieve().getContact_name());
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());
					System.out.println("Address: " + conts.retrieve().getContact_address());
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());
					System.out.println("Notes: " + conts.retrieve().getContact_notes());
				}else {
				System.out.println("Contact not found!");
				}
			}
				break;//1
				// 11n + 15 O(n)
				// if user want search by birthday date
			case "5": {
				System.out.print("Enter the contact's Birthday: ");
				Date d = new Date(input.nextLine());
				if (conts.SearchBirthday(d)) {
					System.out.println("Contact found! ");
					System.out.println("Name: " + conts.retrieve().getContact_name());
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());
					System.out.println("Address: " + conts.retrieve().getContact_address());
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());
					System.out.println("Notes: " + conts.retrieve().getContact_notes());
				}else {
				System.out.println("Contact not found!");
				}
			}
			
				break;//1
				// 11n + 75 O(n)
				default:
					System.out.println("plesae enter valid input !");
}
		}
	}

	// method that search events by contact name or event title.
	public static void printEventDetails() { 
		System.out.println("Enter search criteria:");//1
		System.out.println("1.contact name");//1
		System.out.println("2.Event title\r\n");//1
		int eventChoice = input.nextInt();//1
		// check if contact list is empty or not
		
		if(conts.empty())              //1                                                                             
		{
			System.out.println("Sorry there is no contact !");    //1                                                                               
		}else//1
		// check if events list is empty or not
		if (events.empty())//1
			  System.out.println("Sorry No Event there !");      //1                      
		// events list is not empty
		else {//1
			switch (eventChoice) {//1
			// if user want search by contact name
			case 1: {//1
				// set events current into first element (head)
				events.findFirst();//1
				System.out.print("Enter the contact name:");//1
				input.nextLine();//1
				String n = input.nextLine();//1
				boolean foundCon = false;//1
				// check elements in events list
				while (!events.last()) {//n-1
					
					// if event has same contact name that user enter.
					if (events.retrieve().getType() == 0 && events.retrieve().get_appContact().getContact_name().compareTo(n) == 0) {//n
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
							System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
	
						System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
						System.out.println("Event location:" + events.retrieve().get_location());//n
						// change boolean found to true that means system find event has same contact name that user enter.
						foundCon = true;//n
					}else if(events.retrieve().getType() == 1) {
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
						System.out.print("Contacts name: ");
						printrelatedevent(events.retrieve().event_contacts.getRoot());	
						System.out.println();
						System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
						System.out.println("Event location:" + events.retrieve().get_location());//n
						
						
					}
					// move current into next element

						events.findNext(); //n
					
				}
				
				
				
				
				
				// if event has same contact name that user enter.
				if (events.retrieve().getType() == 0 && events.retrieve().get_appContact().getContact_name().compareTo(n) == 0) {//n
					System.out.println("Event found!\r\n");//n
					System.out.println("Event title:" + events.retrieve().get_title());//n
						System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n

					System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
					System.out.println("Event location:" + events.retrieve().get_location());//n
					// change boolean found to true that means system find event has same contact name that user enter.
					foundCon = true;//n
				}else if(events.retrieve().getType() == 1) {
					System.out.println("Event found!\r\n");//n
					System.out.println("Event title:" + events.retrieve().get_title());//n
					System.out.print("Contacts name: ");
					printrelatedevent(events.retrieve().event_contacts.getRoot());
					System.out.println();
					System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
					System.out.println("Event location:" + events.retrieve().get_location());//n
					
					
				}
				
				// if contact not found
				if(foundCon == false)//1
					System.out.print("events not found !\n");//1
			}
				break;//1
				
				// if user want search by event title.
			case 2: {//1 
				// set events current into first element (head)
				events.findFirst();//1
				System.out.print("Enter the event title:");//1
				String n = input.next();//1
				boolean foundCon = false;//1
				// check elements in events list
				while (!events.last()) {//n-1
					// if event has event title that user enter.
					if (events.retrieve().get_title().equalsIgnoreCase(n)) {//n
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
						if(events.retrieve().getType() ==0)
							System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
							else {
								System.out.print("Contacts name: ");
								printrelatedevent(events.retrieve().event_contacts.getRoot());
								System.out.println();

							}
						System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
						System.out.println("Event location:" + events.retrieve().get_location());//n
						// change boolean found to true that means system find event has same event title that user enter.

						foundCon = true;//n
					}
					// move current into next element
					events.findNext();//n

				}
				// check the last element in event list
				// if event has event title that user enter.
				if (events.retrieve().get_title().equalsIgnoreCase(n)) {//1
					System.out.println("Event found!\r\n");//1
					System.out.println("Event title:" + events.retrieve().get_title());//1
					if(events.retrieve().getType() ==0)
						System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
						else {
							System.out.print("Contacts name: ");
							printrelatedevent(events.retrieve().event_contacts.getRoot());
							System.out.println();

						}
					System.out.println("Event date and time:" + events.retrieve().get_date_time());//1
					System.out.println("Event location:" + events.retrieve().get_location());//1
					// change boolean found to true that means system find event has same event title that user enter.
					foundCon = true;//1
				}
				// if contact not found
				if(foundCon == false)//1
					System.out.println("Sorry there is No event");                                                                 //1                          1 
			}
				break;//1

			}

		}
	}
	

	// method for delete a contact
	public static void deletcontact(String name) {
		if(conts.empty())
			System.out.println("Contact its empty");
		else {
			if(!conts.findkey(name))
				System.out.println("Contact not found");
			else {
				Contact c = conts.searchbyName(name);
				
				if(!conts.retrieve().event.empty()) {
				conts.retrieve().event.findFirst(); //1
				while (!conts.retrieve().event.last()) {// n-1
					Event e = events.retrieve(); //n
					if (events.search(e)) {//n*n
						events.remove(e);//n*n

					}

					conts.retrieve().event.findNext();//n
				}
				Event e = events.retrieve(); //1
				if (events.search(e)) {//n
					events.remove(e);//n

				}
			}
				
				events.findFirst();
				while(!events.last()) {
					if(events.retrieve().event_contacts.searchbyName(name) != null) {
						events.retrieve().event_contacts.remove(name);
				}
					
	

						events.findNext();
			
				}
				if(events.retrieve().event_contacts.searchbyName(name) != null) {
					events.retrieve().event_contacts.remove(name);
			}
			
				
			
				conts.remove(name);
				
			
				
				System.out.println("Contact deleted successfully! ");
				events.findFirst();
	while(!events.last() && !events.empty()) {
		if(events.retrieve().event_contacts.empty())
			events.remove(events.retrieve());
		
		events.findNext();
	}
	if(events.retrieve().event_contacts.empty())
		events.remove(events.retrieve());
		
				
			}
		}
	}
public static BSTNode<Contact> searchBynumber(BSTNode<Contact> node, String number) { 
	if (node==null) {
    return null;
}
if (node.data.getContact_number().equalsIgnoreCase(number)) {
    return node;
}
BSTNode<Contact> leftResult = searchBynumber(node.left,number);    
if (leftResult!=null) {
    return leftResult;
}
BSTNode<Contact> rightResult = searchBynumber(node.right,number);
if (rightResult != null) {
    return rightResult;
}
return null;
}
	
    
	public static BSTNode<Contact> print_firstname(BSTNode<Contact> node, String name) {

		if (node==null) {
		    return null;
		}
		String[] fulnum = node.data.getContact_name().split("\\s");
		if (fulnum[0].equalsIgnoreCase(name)) {
			System.out.print("Name:" + node.data.getContact_name()
			+ "\nPhone Number:" + node.data.getContact_number()
			+ "\nEmail Address:" + node.data.getContact_mail()
			+ "\nAddress: " + node.data.getContact_address()
			+ "\nBirthday:" + node.data.getContact_birthDay()
			+ "\nNotes:" + node.data.getContact_notes());//1
	System.out.print("\n");//1
		}
		
		BSTNode<Contact> leftResult = print_firstname(node.left,name);    
		if (leftResult!=null) {
		    return leftResult;
		}
		BSTNode<Contact> rightResult = print_firstname(node.right,name);
		if (rightResult != null) {
		    return rightResult;
		}
		return null;
		
		
	}
	
	public static BSTNode<Contact> printrelatedevent(BSTNode<Contact> node) {

		if (node==null) {
		    return null;
		}
		
		System.out.print(node.data.getContact_name() + ", ");
	
		BSTNode<Contact> leftResult = printrelatedevent(node.left);    
		if (leftResult!=null) {
		    return leftResult;
		}
		BSTNode<Contact> rightResult = printrelatedevent(node.right);
		if (rightResult != null) {
		    return rightResult;
		}
		return null;
		
		
	}
	// method for print events alphabetically
	public static void print_alph() {
		
		// check if events list is empty or not
		if (events.empty()) {//1
			System.out.println("There are no events\n");//1
			return; //1
		}
		// set events current into first element (head)
		events.findFirst();//1
		// check elements in events list
		while (!events.last()) {//n-1
			System.out.println("Event title:" + events.retrieve().get_title());//n
			if(events.retrieve().getType() ==0)
				System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
				else {
					System.out.print("Contacts name: ");
					printrelatedevent(events.retrieve().event_contacts.getRoot());
					System.out.println();

				}
				
			System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
			System.out.println("Event location:" + events.retrieve().get_location());//n
			System.out.print("\n");//n
			
			// move current into next element
			events.findNext();//n
		}
		// print last element in event list.
		System.out.println("Event title:" + events.retrieve().get_title());//1
		if(events.retrieve().getType() ==0)
		System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
		else {
			System.out.print("Contacts name: ");
			printrelatedevent(events.retrieve().event_contacts.getRoot());
			System.out.println();

		}
		System.out.println("Event date and time:" + events.retrieve().get_date_time());//1
		System.out.println("Event location:" + events.retrieve().get_location());//1
		System.out.print("\n");//1
		
		}
	
	// Time Complexity of print_alph method : 7n + 8 O(n)

	
	public static BSTNode<Contact> isConflictBST(BSTNode<Contact> node, Contact conts) {

		if (node==null) {
		    return null;
		}
	
		if(node.data.getContact_name().equalsIgnoreCase(conts.getContact_name()))
			return node;
		
		BSTNode<Contact> leftResult = isConflictBST(node.left, conts);    
		if (leftResult!=null) {
		    return leftResult;
		}
		BSTNode<Contact> rightResult = isConflictBST(node.right, conts);
		if (rightResult != null) {
		    return rightResult;
		}
		return null;
		
		
	}
	
	public static boolean isConflict(Date date, Contact cont) {
		events.findFirst();
		if(events.empty())
			return false;
		
		events.findFirst();
		while(!events.last()) {
			if(events.retrieve().getType() ==0) {
				if(events.retrieve().get_date_time().equals(date) && events.retrieve().get_appContact().equals(cont)) {
					return true;
				}
				
			}else {
				if(events.retrieve().get_date_time().equals(date) && (isConflictBST(events.retrieve().event_contacts.getRoot(), cont) != null)) {
					return true;
				}
			}
			
			
			events.findNext();
		}
		if(events.retrieve().getType() ==0) {
			if(events.retrieve().get_date_time().equals(date) && events.retrieve().get_appContact().equals(cont)) {
				return true;
			}
			
		}else {
			if(events.retrieve().get_date_time().equals(date) && (isConflictBST(events.retrieve().event_contacts.getRoot(), cont) != null)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	 //this method for schecule an Event   
	 public static void shceduleEvent() {       
			System.out.println("Enter event title:"); //1
			String event_title=input.next();//1
			System.out.println("Enter contact name separated by a comma:");//1
			input.nextLine();//1
			String event_contactsname=input.nextLine();//1
			
			// split contacts.
			String[] evconts_names = event_contactsname.split(",");
			
			// find if any contact enterd not found in list.
			for(int i=0; i<evconts_names.length;i++) {
			if(conts.searchbyName(evconts_names[i]) == null) {
				System.out.print("Soory!, there are contact enered not exists, please add contact and schedule event again.");
				return;
			}
			}
			
			System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");//1
			Date event_datetime;

			try {
				 event_datetime = new Date(input.nextLine());//1
				}catch(IllegalArgumentException i) {
					System.out.print("date is not correct, enter correct date \n");//1
					 event_datetime = new Date(input.nextLine());//1

				
				}
		
			System.out.println("Enter event location:");//1
			String event_location=input.nextLine();		//1
	
			// check if events list is empty or not
			if(events.empty()) {    //1

				Event e = new Event(event_title, event_datetime, event_location);//1
				// insert into big event list
				events.insert(e);    //1
				
				// add contacts in contact list inside event
				for(int k=0; k<evconts_names.length;k++) {
					Contact contaev = conts.searchbyName(evconts_names[k]);
					e.event_contacts.insert(contaev.getContact_name(), contaev);
				}
				
			return; //1
			}else {//1
				
				// check every contact if have event/appointment have same date or not.
				for(int j=0; j<evconts_names.length;j++) {
					if(isConflict(event_datetime, conts.searchbyName(evconts_names[j]))) {
						System.out.print("Soory!, there are conflict with " + evconts_names[j] +  " events, already have events/appointment with same date.");
						return;
					}
				}
				
				
//make object for event
				Event e = new Event(event_title, event_datetime, event_location);//1
		//insert into big event list
				events.insert(e); //1
				// add contacts in contact list inside event
				for(int d=0; d<evconts_names.length;d++) {
					Contact contaev = conts.searchbyName(evconts_names[d]);
					e.event_contacts.insert(contaev.getContact_name(), contaev);
					
					
				}							
			}                                                                                           
		
}
	 //this method for schecule an Event   
	 public static void shceduleAppoint() {       
			System.out.println("Enter appointment title:"); //1
			String event_title=input.next();//1
			System.out.println("Enter contact name:");//1
			input.nextLine();//1
			String event_contactname=input.nextLine();//1
			Contact contact = conts.searchbyName(event_contactname);//n
			if(contact==null) {//1
				System.out.println("contact not found !");//1
				return;//1
			}
			
			System.out.println("Enter appointment date and time (MM/DD/YYYY HH:MM):");//1
			Date event_datetime;

			try {
				 event_datetime = new Date(input.nextLine());//1
				}catch(IllegalArgumentException i) {
					System.out.print("date is not correct, enter correct date \n");//1
					 event_datetime = new Date(input.nextLine());//1

				
				}
			
			System.out.println("Enter appointment location:");//1
			String event_location=input.nextLine();		//1
	
			// check if events list is empty or not
			if(events.empty()) {    //1

				Event e = new Event(event_title, event_datetime, event_location, contact);//1
				// insert into big event list
				events.insert(e);    //1
				// insert into event list for contact list
				contact.event.insert(e);//1
			return; //1
			}else {//1
	
				if(isConflict(event_datetime, contact)){
						System.out.println("Sorry there is event/appointment in this time");  //n
					return;
					}
					
				
				
				Event e = new Event(event_title, event_datetime, event_location, contact);//1

				events.insert(e); //1
				contact.event.insert(e);//1
				}				
				}                                                                                         
		

	 
	 //5n + 25 O(n)
	public static void main(String[] args) {

		
	
	
		Scanner input = new Scanner(System.in);
		int choice = 0;

		System.out.println("\nWelcome to the Linked Tree Phonebook !");
		do {
			System.out.println("Please choose an option");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event/appointments");
			System.out.println("5. Print event details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit\n");
			System.out.print("Enter your choice: ");
			
			try {
			choice = input.nextInt();
	
			
			System.out.println();
			switch (choice) {
				case 1:

				       System.out.print("Enter the contact's name:");
				       input.nextLine();
				        String contact_name = input.nextLine();
						while(conts.searchbyName(contact_name) != null) {
							System.out.print("Contact is already exists! ");
							
							System.out.print("\nEnter contact's name: ");
							 contact_name = input.next();

						}
				        System.out.print("Enter the contact's phone number:");
				        String contact_phone = input.next();
						while(searchBynumber(conts.getRoot(), contact_phone) != null) {
							System.out.print("Contact number is already exists! ");
							
							System.out.print("Enter the contact's phone number: ");
							contact_phone = input.next();

						}
				        System.out.print("Enter the contact's email address:");
				        String contact_mail = input.next();
				        System.out.print("Enter the contact's address:");
				        input.nextLine();
				        String contact_address = input.nextLine();
				        System.out.print("Enter the contact's birthday:");
				        Date contact_birthday;
						try {
					        contact_birthday = new Date(input.nextLine());
							}catch(IllegalArgumentException i) {
								System.out.print("date is not correct \n");
								break;
							
							}
				        System.out.print("Enter any notes for the contact:");
				        String contact_note = input.nextLine();
				        
						Contact newcont = new Contact(contact_name, contact_phone, contact_mail, contact_address, contact_birthday, contact_note);
						conts.insert(contact_name, newcont);
						System.out.println("Contact added successfully!");

					break;

					
				case 2:
					Searchcontact();

					break;
				case 3:
					
					System.out.print("Enter Contact name: ");
					String cont_delete_name = input.next();
					deletcontact(cont_delete_name);
					break;
				case 4:
				
					System.out.println("Enter type:"); //1
					System.out.println("1.event"); //1
					System.out.println("2.appointment");//1
					System.out.print("Enter your choise");//1
					input.nextLine();
					String Choica = input.nextLine();//1
					

					if (conts.empty())//if contact list is empty (1)
						System.out.println("Contact its empty");//1
					
					else {// if contact list not empty (1)
						// user choose the serach criteria
						switch (Choica) {//1
						// if user want search by name
						case "1": {//1				
	
					shceduleEvent();
					break;
						}
						case "2":{
							shceduleAppoint();
							break;
						}
						}
					}
					break;
				case 5:
					printEventDetails();
					break;
				case 6:
					
					System.out.print("Enter the first name: ");
					input.nextLine();
					String firstname = input.nextLine();
					String[] namefirst = firstname.split("\\s");

					print_firstname(conts.getRoot(), namefirst[0]);

					break;
				case 7:
					print_alph();
					break;

				default:
					System.out.println("Invalid input! \n");
			}
			}catch(InputMismatchException e) {
				input.nextLine();
							}
		} while (choice != 8);
		System.out.println("Goodbye!");


	}



}