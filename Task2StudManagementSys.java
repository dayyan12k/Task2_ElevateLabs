import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    double marks;

    public Student(int id, String name,double marks) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}


public class Task2StudManagementSys {
    static ArrayList<Student> students = new ArrayList<>();
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\n--- Student Record Management ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Sort by Marks");
        System.out.println("6. Exit");

        boolean continueCheck=true;
        while(continueCheck){


           int choice = getValidInput(sc , "Enter a choice: ");
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }
            System.out.println("Do you want to continue?(yes/no): ");
            String check = sc.next();
            if(check.equalsIgnoreCase("no")) continueCheck=false;

        }

    }

    private static int getValidInput(Scanner sc, String s) {
       while(true){
           System.out.println(s);
           try{
               return sc.nextInt();
           } catch (Exception e) {
               System.out.println("Enter a valid input: ");
               sc.nextLine();
           }
       }
    }

    private static void addStudent() {
        System.out.println("Enter Id of student: ");
        int id = sc.nextInt();
        sc.nextLine(); // flush
        System.out.print("Enter Name of student: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks of student: ");
        double marks = sc.nextDouble();
        students.add(new Student(id , name , marks));
        System.out.println("Student Added Successfully....");
    }

    //view student
    private static void viewStudent() {
        if(students.isEmpty()){
            System.out.println("No records found! ");
        }
        else{
            for (Student student:students){
                System.out.println(student);
            }
        }
    }

    private static void updateStudent() {
        System.out.println("Enter id to update: ");
        int id = sc.nextInt();
        for(Student s: students){
            if(s.getId() == id){
                sc.nextLine(); // flush
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("Student updated!");
                return;
            }
            System.out.println("No Record found for the id: "+id);
        }
    }

    //delete student
    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
       boolean ch = students.removeIf(s -> s.getId() == id);
       if (ch) System.out.println("Student Deleted Successfully! ");
       System.out.println("Student does not exist! ");
    }

    private static void sortStudents() {
        students.sort((a,b) -> Double.compare(b.getMarks() , a.getMarks()));
        viewStudent();
    }


}
