/*************Example***************
CLASS: PhoneBook.java
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
3-12-2023
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
				System.out.print("Enter the contact's name: ");//1
				String name = input.nextLine();//1
				if (conts.findkey(name)) {// logn
					System.out.println("Contact found! ");//1;
					System.out.println("Name: " + conts.retrieve().getContact_name());//1
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());//1
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());//1
					System.out.println("Address: " + conts.retrieve().getContact_address());//1
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());//1
					System.out.println("Notes: " + conts.retrieve().getContact_notes());//1
				}else {//1
				System.out.println("Contact not found!");//1
				}
			}
				break;//1
				
				
				// if user want search by phone number
			case "2": {//1
				System.out.print("Enter the contact's Phone number");//1
				String num = input.nextLine();//1
				if (conts.Searchnumber(num)) {//n
					System.out.println("Contact found! ");//1
					System.out.println("Name: " + conts.retrieve().getContact_name());//1
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());//1
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());//1
					System.out.println("Address: " + conts.retrieve().getContact_address());//1
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());//1
					System.out.println("Notes: " + conts.retrieve().getContact_notes());//1
					
				}else {//1
				System.out.println("Contact not found!");//1
				}
			}
				break;//1
				
				// if user want search by email address
			case "3": {//1
				System.out.println("Enter the contact's Email Address: ");//1
				String em = input.nextLine();//1
				if (conts.SearchEmail(em)) {//n
					System.out.println("Contact found! ");//1
					System.out.println("Name: " + conts.retrieve().getContact_name());//1
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());//1
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());//1
					System.out.println("Address: " + conts.retrieve().getContact_address());//11
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());//1
					System.out.println("Notes: " + conts.retrieve().getContact_notes());//1
					
				}else {//1
				System.out.println("Contact not found!");//1
				}
			}
				break;//1
				// if user want search by address
			case "4": {//1
				System.out.print("Enter the contact's Address: ");//1
				String add = input.nextLine();//1
				if (conts.SearchAddress(add)) {//n
					System.out.println("Contact found! ");//1
					System.out.println("Name: " + conts.retrieve().getContact_name());//1
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());//1
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());//1
					System.out.println("Address: " + conts.retrieve().getContact_address());//1
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());//1
					System.out.println("Notes: " + conts.retrieve().getContact_notes());//1
				}else {//1
				System.out.println("Contact not found!");//1
				}
			}
				break;//1
				// 11n + 15 O(n)
				// if user want search by birthday date
			case "5": {//1
				System.out.print("Enter the contact's Birthday: ");//1
				Date d = new Date(input.nextLine());//1
				if (conts.SearchBirthday(d)) {//n
					System.out.println("Contact found! ");//1
					System.out.println("Name: " + conts.retrieve().getContact_name());//1
					System.out.println("Phone Number: " + conts.retrieve().getContact_number());//1
					System.out.println("Email Address: " + conts.retrieve().getContact_mail());//1
					System.out.println("Address: " + conts.retrieve().getContact_address());//1
					System.out.println("Birthday: " + conts.retrieve().getContact_birthDay());//1
					System.out.println("Notes: " + conts.retrieve().getContact_notes());//1
				}else {//1
				System.out.println("Contact not found!");//1
				}
			}
			
				break;//1
				
				default://1
					System.out.println("plesae enter valid input !");//1
}
		}
	}
	// 4n + logn + 78 O(n)
	
	
	
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
				while (!events.last()) {//n+1
					
					// if event has same contact name that user enter.
					if (events.retrieve().getType() == 0 && events.retrieve().get_appContact().getContact_name().compareTo(n) == 0) {//n
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
							System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
	
						System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
						System.out.println("Event location:" + events.retrieve().get_location());//n
						// change boolean found to true that means system find event has same contact name that user enter.
						foundCon = true;//n
				
					}else if(events.retrieve().getType() == 1 && events.retrieve().event_contacts.searchbyName(n) != null) {//n (logn) = nlogn
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
						System.out.print("Contacts name: ");//n
						printrelatedevent(events.retrieve().event_contacts.getRoot());	 // n*n
						System.out.println();//n
						System.out.println("Event date and time:" + events.retrieve().get_date_time());//n
						System.out.println("Event location:" + events.retrieve().get_location());//n
						foundCon = true;//n

						
					}
					
					
					// move current into next element

						events.findNext(); //n
					
				}
				
				// if event has same contact name that user enter.
				if (events.retrieve().getType() == 0 && events.retrieve().get_appContact().getContact_name().compareTo(n) == 0) {//1
					System.out.println("Event found!\r\n");//1
					System.out.println("Event title:" + events.retrieve().get_title());//1
						System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//1

					System.out.println("Event date and time:" + events.retrieve().get_date_time());//1
					System.out.println("Event location:" + events.retrieve().get_location());//1
					// change boolean found to true that means system find event has same contact name that user enter.
					foundCon = true;//n
			
				}else if(events.retrieve().getType() == 1 && events.retrieve().event_contacts.searchbyName(n) != null) {//logn
					System.out.println("Event found!\r\n");//1
					System.out.println("Event title:" + events.retrieve().get_title());//1
					System.out.print("Contacts name: ");//1
					printrelatedevent(events.retrieve().event_contacts.getRoot());	 // n
					System.out.println();//1
					System.out.println("Event date and time:" + events.retrieve().get_date_time());//1
					System.out.println("Event location:" + events.retrieve().get_location());//1
					foundCon = true;//1
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
				while (!events.last()) {//n+1
					// if event has event title that user enter.
					if (events.retrieve().get_title().equalsIgnoreCase(n)) {//n
						System.out.println("Event found!\r\n");//n
						System.out.println("Event title:" + events.retrieve().get_title());//n
						if(events.retrieve().getType() ==0)//n
							System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
							else {//n
								System.out.print("Contacts name: ");//n
								printrelatedevent(events.retrieve().event_contacts.getRoot());//n * n
								System.out.println();//n

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
					if(events.retrieve().getType() ==0)//1
						System.out.println("Contact name:" + events.retrieve().get_appContact().getContact_name());//n
						else {
							System.out.print("Contacts name: ");//1
							printrelatedevent(events.retrieve().event_contacts.getRoot());//n
							System.out.println();//1

						}
					System.out.println("Event date and time:" + events.retrieve().get_date_time());//1
					System.out.println("Event location:" + events.retrieve().get_location());//1
					// change boolean found to true that means system find event has same event title that user enter.
					foundCon = true;//1
				}
				// if contact not found
				if(foundCon == false)//1
					System.out.println("Sorry there is No event");     //1                           
			}
				break;//1

			}

		}
	}
	
// 2n^2 + 31n + nlogn + logn + 52 O(n^2) 

	// method for delete a contact
	public static void deletcontact(String name) {
		if(conts.empty())//1
			System.out.println("Contact its empty");//1
		else {
			if(!conts.findkey(name))//logn+1
				System.out.println("Contact not found");//logn
			else {
				Contact c = conts.searchbyName(name);//logn
				
				if(!conts.retrieve().event.empty()) {//1
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
				if(!events.empty()) {
				events.findFirst();//1
				while(!events.last()) {//n+1
					if(events.retrieve().event_contacts.searchbyName(name) != null) {//logn(n) = nlogn
						events.retrieve().event_contacts.remove(name);//n
				}
					
	

						events.findNext();//n
			
				}
				if(events.retrieve().event_contacts.searchbyName(name) != null) {//logn
					events.retrieve().event_contacts.remove(name);//1
			}
			
				
				}
				conts.remove(name);//1
				
			
				
				System.out.println("Contact deleted successfully! ");//1
				events.findFirst();//1		
	
				
				while(!events.empty() && !events.last()) {//n+1
		
		if(events.retrieve().event_contacts.empty()){//n
			events.remove(events.retrieve());//n
		}
		
		events.findNext();//n
		
		
	}
	if(!events.empty() && events.retrieve().event_contacts.empty())//1
		events.remove(events.retrieve());//1
		
				
			}
		}
	}
	// 2n^2 + 12n + 5logn + nlogn + 15 O(n^2)
	
	
public static BSTNode<Contact> searchBynumber(BSTNode<Contact> node, String number) { 
	if (node==null) {//1
    return null;//1
}
if (node.data.getContact_number().equalsIgnoreCase(number)) {//1
    return node;//1
}
BSTNode<Contact> leftResult = searchBynumber(node.left,number);  //n
if (leftResult!=null) {//1
    return leftResult;//1
}
BSTNode<Contact> rightResult = searchBynumber(node.right,number);//n
if (rightResult != null) {//1
    return rightResult;//1
}
return null;//1
}
	// 2n + 8 O(n)
    
	public static BSTNode<Contact> print_firstname(BSTNode<Contact> node, String name) {

		if (node==null) {//1
		    return null;//1
		}
		String[] fulnum = node.data.getContact_name().split("\\s");//1
		if (fulnum[0].equalsIgnoreCase(name)) {//1
			System.out.print("Name:" + node.data.getContact_name()
			+ "\nPhone Number:" + node.data.getContact_number()
			+ "\nEmail Address:" + node.data.getContact_mail()
			+ "\nAddress: " + node.data.getContact_address()
			+ "\nBirthday:" + node.data.getContact_birthDay()
			+ "\nNotes:" + node.data.getContact_notes());//1
	System.out.print("\n");//1
		}
		
		BSTNode<Contact> leftResult = print_firstname(node.left,name);    //n
		if (leftResult!=null) {//1
		    return leftResult;//1
		}
		BSTNode<Contact> rightResult = print_firstname(node.right,name);//n
		if (rightResult != null) {//1
		    return rightResult;//1
		}
		return null;//1
		
		
	}
	//2n + 11 O(n)
	public static BSTNode<Contact> printrelatedevent(BSTNode<Contact> node) {

		if (node==null) {//1
		    return null;//1
		}
		
		System.out.print(node.data.getContact_name() + ", ");//1
	
		BSTNode<Contact> leftResult = printrelatedevent(node.left);    //n 
		if (leftResult!=null) {//1
		    return leftResult;//1
		}
		BSTNode<Contact> rightResult = printrelatedevent(node.right);//n
		if (rightResult != null) {//1
		    return rightResult;//1
		}
		return null;//1
		
		
	}
	// 2n + 8 O(n)
	
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
		while (!events.last()) {//n+1
			if(events.retrieve().getType() == 0)//n
			System.out.print("Appointment title:" + events.retrieve().get_title());//n
			else
			System.out.print("Event title:" + events.retrieve().get_title());//n

			
			System.out.print("\n");//n
			
			// move current into next element
			events.findNext();//n
		}
		// print last element in event list.
		if(events.retrieve().getType() == 0)//1
		System.out.print("Appointment title:" + events.retrieve().get_title());//1
		else//1
		System.out.print("Event title:" + events.retrieve().get_title());//1

		System.out.print("\n");//1

		
		}
	
	// Time Complexity of print_alph method : 6n + 9 O(n)

	
	public static boolean isConflict(Date date) {
		events.findFirst();//1
		if(events.empty())//1
			return false;//1
		
		events.findFirst();//1
		while(!events.last()) {//n+1
				if(events.retrieve().get_date_time().equals(date) ) {//n
					return true;//n
				}
				
			
			
			events.findNext();//n
		}
		if(events.retrieve().get_date_time().equals(date) ) {//1
			return true;//1
		}
		
		
		return false;//1
	}
	//4n + 8 O(n)
	
	
	
	 //this method for schecule an Event   
	 public static void shceduleEvent() {       
			System.out.println("Enter event title:"); //1
			String event_title=input.next();//1
			System.out.println("Enter contact name separated by a comma:");//1
			input.nextLine();//1
			String event_contactsname=input.nextLine();//1
			
			// split contacts.
			String[] evconts_names = event_contactsname.split(",");//1
			
			// find if any contact enterd not found in list.
			for(int i=0; i<evconts_names.length;i++) {//n
				
				// to remove spaces in name
				evconts_names[i]= evconts_names[i].replaceAll("\\s", "");//n-1
				
				//check if any contact is not found in list.
			if(conts.searchbyName(evconts_names[i]) == null) {//logn(n-1) = nlogn - logn
				System.out.print("Soory!, there are contact enered not exists, please add contact and schedule event again.");//n-1
				return;//n-1
			}
			}
			
			System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");//1
			Date event_datetime;//1

			try {//1
				 event_datetime = new Date(input.nextLine());//1
				}catch(IllegalArgumentException i) {//1
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
				for(int k=0; k<evconts_names.length;k++) {//n
					Contact contaev = conts.searchbyName(evconts_names[k]);//logn(n-1) = nlogn - logn
					e.event_contacts.insert(contaev.getContact_name(), contaev);//n-1
				}
				
			return; //1
			}else {//1
				
				// check every contact if have event/appointment have same date or not.
				for(int j=0; j<evconts_names.length;j++) {//n
					if(isConflict(event_datetime)) {// n * n
						System.out.print("Soory!, there are conflict with " + evconts_names[j] +  " events, already have events/appointment with same date.");//n-1
						return;//n-1
					}
				}
				
				
//make object for event
				Event e = new Event(event_title, event_datetime, event_location);//1
		//insert into big event list
				events.insert(e); //1
				// add contacts in contact list inside event
				for(int d=0; d<evconts_names.length;d++) {//n
					Contact contaev = conts.searchbyName(evconts_names[d]);//nlogn - logn
					e.event_contacts.insert(contaev.getContact_name(), contaev);//n-1
					
					
				}							
			}                                                                                           
		
}
	 //n^2 + 11n + 3nlogn - 3logn + 14 (n^2) 
	 
	 //this method for schecule an Event   
	 public static void shceduleAppoint() {       
			System.out.println("Enter appointment title:"); //1
			String event_title=input.next();//1
			System.out.println("Enter contact name:");//1
			input.nextLine();//1
			String event_contactname=input.nextLine();//1
			Contact contact = conts.searchbyName(event_contactname);//logn
			if(contact==null) {//1
				System.out.println("contact not found !");//1
				return;//1
			}
			
			System.out.println("Enter appointment date and time (MM/DD/YYYY HH:MM):");//1
			Date event_datetime;//1

			try {//1
				 event_datetime = new Date(input.nextLine());//1
				}catch(IllegalArgumentException i) {//1
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
	
				if(isConflict(event_datetime)){//n 
						System.out.println("Sorry there is event/appointment in this time");  //1
					return;//1
					}
					
				
				
				Event e = new Event(event_title, event_datetime, event_location, contact);//1

				events.insert(e); //1
				contact.event.insert(e);//1
				}				
				}                                                                                         
		

	 
	 //n + logn + 28 O(n)
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