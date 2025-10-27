import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// ===============================================
// CLASSE STUDENT
// ===============================================
class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    // Getters
    public int getId() { return id; }
    public String getFname() { return fname; }
    public double getCgpa() { return cgpa; }
}

// ===============================================
// CLASSE COMPARATOR
// ===============================================
class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        // 1. CGPA (Decrescente)
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }

        // 2. Nome (Crescente/Alfabetico)
        if (!s1.getFname().equals(s2.getFname())) {
            return s1.getFname().compareTo(s2.getFname());
        }

        // 3. ID (Crescente)
        return Integer.compare(s1.getId(), s2.getId());
    }
}


// ===============================================
// CLASSE PRINCIPAL com dados hardcoded
// ===============================================
public class Solution {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        // INICIALIZAÇÃO MANUAL DOS DADOS DE AMOSTRA
        studentList.add(new Student(33, "Rumpa", 3.68));
        studentList.add(new Student(85, "Ashis", 3.85));
        studentList.add(new Student(56, "Samiha", 3.75));
        studentList.add(new Student(19, "Samara", 3.75));
        studentList.add(new Student(22, "Fahim", 3.76));

        System.out.println("Lista de alunos ANTES da ordenacao:");
        studentList.forEach(s -> System.out.println("  " + s.getFname() + " (" + s.getCgpa() + ")"));
        System.out.println("---------------------------------");

        // ORDENACAO
        Collections.sort(studentList, new StudentComparator());

        // OUTPUT: Imprime o nome de cada aluno ordenado
        System.out.println("Lista de alunos DEPOIS da ordenacao:");
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

    }
}