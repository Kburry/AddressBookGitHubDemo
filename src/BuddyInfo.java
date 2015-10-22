
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
	
	@Override
	public String toString(){
		return "Name: "+name+" Address: "+address+" Phone: "+phoneNumber;
	}
	
	@Override
	public boolean equals(Object buddy){
		if(buddy == null || !(buddy instanceof BuddyInfo)){
			return false;
		}
		BuddyInfo b = (BuddyInfo) buddy;
		return name.equals(b.name) && address.equals(b.address) && phoneNumber.equals(b.phoneNumber);
	}
	

}
