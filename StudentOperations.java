//StudentOperations.java //Perform CRUD operations
import java.util.*;
class StudentOperations{
	ArrayList<Student> students; // <Student> refers to Student.java
	
	public StudentOperations(){ //constructor
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student){ //Adding Student
		students.add(student);
		System.out.println("Student Added");
	}
	
	public void displayStudents(){ // method to display the students
		for (Student student : students){
			
			System.out.println("-----------------------------------------------------");
			student.display();
			System.out.println("-----------------------------------------------------");
			System.out.println("\n");
		}
	}
	
	public void searchStudent(){ // method to search the students
        Scanner scan = new Scanner(System.in);
        System.out.println("Search by:\n1. PRN\n2. Name\n3. Position");
        int choice = Integer.parseInt(scan.nextLine());

        switch (choice) { // search by prn, name or position based on user input
            case 1:
                System.out.println("\nEnter PRN to search: ");
                long prn = Long.parseLong(scan.nextLine());
                searchByPrn(prn); //calls search by prn method
                break;
            case 2:
                System.out.println("\nEnter Name to search: ");
                String name = scan.nextLine();
                searchByName(name); //calls search by name method
                break;
            case 3:
                System.out.println("\nEnter Position (Index) to search: ");
                int pos = Integer.parseInt(scan.nextLine());
                searchByPosition(pos); //calls search by postion method
                break;
            default:
                System.out.println("\nInvalid choice!");
        }
    }
	
	public void searchByPrn(long prn) { // checks all students prn's to find matching one
        for (Student student : students) {
            if (student.getPrn() == prn) {
                System.out.println("\nStudent Found:");
                student.display();
                return;
            }
        }
        System.out.println("\nStudent with PRN " + prn + " not found.");
    }
	
	
	public void searchByName(String name) { // checks all students names to find matching one 
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) { // is not case sensitive
                System.out.println("Student Found:");
                student.display();
                return;
            }
        }
        System.out.println("Student with Name " + name + " not found.");
    }
	
	public void searchByPosition(int pos) {
        if (pos >= 0 && pos < students.size()) {//checks for positions 0 to the size of ArrayList
            System.out.println("Student at Position " + pos + ":");
            students.get(pos).display();
        }
		else {
            System.out.println("Invalid Position! No student exists at index " + pos);
        }
    }
	
	public void deleteStudent() { //Delete by prn
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter PRN to delete: ");
        long prn = Long.parseLong(scan.nextLine());

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getPrn() == prn) {
                iterator.remove();
                System.out.println("Student with PRN " + prn + " deleted.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }
	
	public void editStudent() { //edit students details based on prn
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter PRN of the student to edit: ");
        long prn = Long.parseLong(scan.nextLine());

        for (Student student : students) { //change everything except prn (editing it)
            if (student.getPrn() == prn) {
                System.out.println("Student Found. Enter new details:");

                System.out.println("Enter New Name: ");
                student.setName(scan.nextLine());

                System.out.println("Enter New Age: ");
                student.setAge(Integer.parseInt(scan.nextLine()));

                System.out.println("Enter New CGPA: ");
                student.setCgpa(Double.parseDouble(scan.nextLine()));

                System.out.println("Student details updated successfully!");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }
}
	
