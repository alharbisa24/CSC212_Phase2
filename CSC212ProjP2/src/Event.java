import java.util.Date;

/*************Example***************
CLASS: Event.java
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
public class Event implements Comparable<Event> {
	private String title;
	private Date date_time;
	private String location;
	private Contact appointment_Contact;
	BST event_contacts; 
	private int type;
	
	
	// add appointment
	public Event(String event_title, Date event_date_time, String event_location, Contact contact) {
		this.title = event_title;
		this.date_time = event_date_time;
		this.location = event_location;
		this.appointment_Contact = contact;
		type = 0;
	}
	
	// events
	public Event(String event_title, Date event_date_time, String event_location) {
		this.title = event_title;
		this.date_time = event_date_time;
		this.location = event_location;
		event_contacts = new BST();
		this.appointment_Contact = null;
		type = 1;
	}

	public String get_title() {
		return title;
	}

	public Date get_date_time() {
		return date_time;
	}
	
	public String get_location() {
		return location;
	}
	public Contact get_appContact() {
		return appointment_Contact;
	}
	public int getType() {
		return type;
	}

	public int compareTo(Event e) {
		return this.title.compareTo(e.title);
	}

}