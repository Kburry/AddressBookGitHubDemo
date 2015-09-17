
public class BuddyInfo {
	
	private String name;
	private String address;
	private String phoneNumber;
	
	BuddyInfo(){
		this.name = null;
		this.address = null;
	}
	
	BuddyInfo(String name, String address, String phoneNumber){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber; }

	public void printName(){
		System.out.println("Hello "+this.getName());
	}
	
	public static void main(String[] args) {
		BuddyInfo Jimbo = new BuddyInfo("Jimbo","123 Fake Street", "(555) 555-5555");
		BuddyInfo Name = new BuddyInfo();
		Jimbo.printName();
		Name.setName("John Doe");
		Name.setAddress("321 Faker Street");
		Name.setPhoneNumber("(613) 555-5555");
		Name.printName();
	}

}