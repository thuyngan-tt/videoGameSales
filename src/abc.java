import java.util.ArrayList;
import java.util.Collections;


public class abc {
    static class Student implements Comparable<Student> {
       String name;
       int age;
       double grade;

        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        String getName() {
            return name;
        }
        int getAge() {
            return age;
        }
        double getGrade() {
            return grade;
        }

        public int compareTo(Student other) {
            // Compare by grade (descending order)
            if (Double.compare(other.grade, this.grade) != 0) {
                return Double.compare(this.grade, other.grade) ;
            }
            return 0;
        }

        public static void main(String[] args) {
            // Create a list of students
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 20, 85.5));
            students.add(new Student("Bob", 22, 90.0));
            students.add(new Student("Charlie", 19, 78.3));
            students.add(new Student("David", 21, 85.5));
            students.add(new Student("Eve", 20, 92.7));

            // Display unsorted list
            System.out.println("Unsorted list of students:");
            for (int i=0; i<students.size(); i++) {
                System.out.println(students.get(i).getName() + " " + students.get(i).getAge() +" " + students.get(i).getGrade());
            }

            // Sort the list using the natural ordering defined by Comparable
            Collections.sort(students);

            // Display sorted list
            System.out.println("\nSorted list of students (by grade descending, then age ascending, then name):");
            for (int i=0; i<students.size(); i++) {
                System.out.println(students.get(i).getName() + " " + students.get(i).getAge() + " " + students.get(i).getGrade());
            }
        }
    }
}
