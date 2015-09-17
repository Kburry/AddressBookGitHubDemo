import java.util.ArrayList;

public class AddressBook {
	
	private ArrayList<BuddyInfo> buddies;
	
	public AddressBook(){
		buddies = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy){
		if (buddy != null){
			buddies.add(buddy);
		}
	}
	
	public void removeBuddy(int index){
		if(index < buddies.size() && index >= 0)
			buddies.remove(index);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		if (buddy != null && buddies.contains(buddy)){
			buddies.remove(buddy);
		}
	}
	
	public static void main(String[] args) {
		BuddyInfo Jimbo = new BuddyInfo("Jimbo","123 Fake Street", "(555) 555-5555");
		BuddyInfo Name = new BuddyInfo();
		AddressBook buddies = new AddressBook();
		Jimbo.printName();
		Name.setName("John Doe");
		Name.setAddress("321 Faker Street");
		Name.setPhoneNumber("(613) 555-5555");
		Name.printName();
		buddies.addBuddy(Jimbo);
		buddies.addBuddy(Name);
		buddies.removeBuddy(Name);
	}

}
