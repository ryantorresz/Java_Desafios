import java.util.Scanner;

public class JavaStringsExercise {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        sc.close();

        int somaComprimentos = A.length() + B.length();
        System.out.println(somaComprimentos);


        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


        String A_capitalizada = A.substring(0, 1).toUpperCase() + A.substring(1);

        String B_capitalizada = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(A_capitalizada + " " + B_capitalizada);
    }
}