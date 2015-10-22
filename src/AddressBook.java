
import javax.swing.DefaultListModel;
//small change
//new branch
public class AddressBook {
	
	private DefaultListModel<BuddyInfo> buddies;
	
	public AddressBook(){
		buddies = new DefaultListModel<BuddyInfo>();
	}
	
	public DefaultListModel<BuddyInfo> getListModel(){
		return buddies;
	}
	
	public void addBuddy(BuddyInfo buddy){
		if (buddy != null && !buddies.contains(buddy)){
			buddies.addElement(buddy);
		}
	}
	
	public BuddyInfo removeBuddy(int index){
		if(index < buddies.size() && index >= 0)
			return buddies.remove(index);
		return null;
	}
	
	public Boolean removeBuddy(BuddyInfo buddy){
		if (buddy != null && buddies.contains(buddy))
			return buddies.removeElement(buddy);
		return false;
	}
	
	@Override
	public String toString(){
		return buddies.toString();
	}
	
	/*public static void main(String[] args) {
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
	}*/

}
