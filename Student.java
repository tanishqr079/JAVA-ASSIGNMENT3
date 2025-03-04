//Student.java

class Student{ //All attributes of student
	private String name;
	private long prn;
	private int age;
	private double cgpa;
	
	public Student(String name, long prn,int age,double cgpa){
		setName(name);  //constructor
		setPrn(prn);
		setAge(age);
		setCgpa(cgpa);
	}
	
	public void setName(String name){ //setter for name
		this.name = name;
	}
	
	public String getName(){ //getter for name
		return name;
	}
	
	public void setPrn(long prn){ //setter for prn
		this.prn = prn;
	}
	
	public long getPrn(){ //getter for prn
		return prn;
	}
	
	public void setAge(int age){ //setter for Age
		this.age = age;
	}
	
	public int getAge(){ //getter for Age
		return age;
	}
	
	public void setCgpa( double cgpa){ //setter for cgpa
		this.cgpa = cgpa;
	}
	
	public double getCgpa(){ //getter for cgpa
		return cgpa;
	}
	
	public void display(){ // Display method
		System.out.println("Name: " + getName()+ "\nPRN: " + getPrn() + "\nAge: " + getAge() + "\nCGPA: " + getCgpa());
    }
}
