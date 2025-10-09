import java.util.*;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    Person(String firstName, String lastName, int idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
    }
}

class Student extends Person {

    private int[] testScores;

    Student(String firstName, String lastName, int id, int[] scores) {
        super(firstName, lastName, id);

        this.testScores = scores;
    }


    public char calculate() {
        int sum = 0;

        for (int score : testScores) {
            sum += score;
        }

        if (testScores.length == 0) {
            return 'U';
        }

        int average = sum / testScores.length;

        if (average >= 90 && average <= 100) {
            return 'O';
        } else if (average >= 80 && average < 90) {
            return 'E';
        } else if (average >= 70 && average < 80) {
            return 'A';
        } else if (average >= 55 && average < 70) {
            return 'P';
        } else if (average >= 40 && average < 55) {
            return 'D';
        } else {
            return 'T';
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Digite o Primeiro Nome: ");
        String firstName = scan.next();

        System.out.print("Digite o Sobrenome: ");
        String lastName = scan.next();

        System.out.print("Digite o ID do Aluno: ");
        int id = scan.nextInt();

        System.out.print("Digite o Número de Notas (ex: 3): ");
        int numScores = scan.nextInt();

        System.out.println("Digite as " + numScores + " Notas (separadas por espaço):");

        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }

        // --- FIM DA ENTRADA ---
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);

        System.out.println("\n--- RESULTADO ---");
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
        System.out.println("-----------------");
    }
}