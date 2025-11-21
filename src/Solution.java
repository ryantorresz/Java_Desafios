import java.util.Arrays;

class Arithmetic {
    public int add(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
}

class Adder extends Arithmetic {
}

public class Solution {
    public static void main(String[] args) {
        Adder a = new Adder();

        int n1 = 42;
        int n2 = 13;
        int n3 = 20;

        String superclassName = a.getClass().getSuperclass().getSimpleName();
        System.out.println("My superclass is: " + superclassName);

        int sumResult = a.add(n1, n2, n3);

        System.out.println(n1 + " " + n2 + " " + n3);

    }
}