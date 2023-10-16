package assignment;

public class Student {
	private int id;
	private String first_name;
	private String gpa;
	private String email;
	private String gender;
	
	public Student() {
		
	}
	
	public Student(String first_name, String gender, String email, String gpa) {
		this.first_name = first_name;
		this.gpa = gpa;
		this.email = email;
		this.gender = gender;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setGPA(String gpa) {
		this.gpa = gpa;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public String getGPA() {
		return this.gpa;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	@Override
	public String toString() {
		return this.first_name + " " + this.gender + " " + this.email + " " + this.gpa;
	}
}
