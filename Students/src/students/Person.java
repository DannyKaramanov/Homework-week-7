package students;

public class Person {
	
	private String fName = "Danny";
	private String midName = "Ivanov";
	private String lName = "Karamanov";
	
	public Person(String fName, String midName, String lName) {
		this.fName = fName;
		this.midName = midName;
		this.lName = lName;
	}
	public Person() {
		
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
		
	}
}
