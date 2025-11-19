import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // CGPA descending
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
        // Name ascending
        int nameCompare = s1.getName().compareTo(s2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        // ID ascending
        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class Solution {
    public static void main(String[] args) {
        // Criando os inputs diretamente - Sample Input do problema
        List<Student> students = new ArrayList<>();

        // Adicionando os estudantes do exemplo
        students.add(new Student(33, "Rumpa", 3.68));
        students.add(new Student(85, "Ashis", 3.85));
        students.add(new Student(56, "Samiha", 3.75));
        students.add(new Student(19, "Samara", 3.75));
        students.add(new Student(22, "Fahim", 3.76));

        Collections.sort(students, new StudentComparator());

        System.out.println("=== Sample Output ===");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}