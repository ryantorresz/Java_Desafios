import java.util.List;
import java.util.Arrays;

public class NewYearChaosList {

    public static void minimumBribes(List<Integer> q) {
        int totalBribes = 0;
        int n = q.size();

        for (int i = 0; i < n; i++) {
            int originalPosition = q.get(i);
            int currentPosition = i + 1;

            if (originalPosition - currentPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            int personValue = q.get(i);

            int start = Math.max(0, personValue - 2);

            for (int j = start; j < i; j++) {
                if (q.get(j) > personValue) {
                    totalBribes++;
                }
            }
        }

        System.out.println(totalBribes);
    }

    public static void main(String[] args) {
        List<Integer> q1 = Arrays.asList(2, 1, 5, 3, 4);
        System.out.print("Fila 1: ");
        minimumBribes(q1);

        List<Integer> q2 = Arrays.asList(5, 1, 2, 3, 4);
        System.out.print("Fila 2: ");
        minimumBribes(q2);

        List<Integer> q3 = Arrays.asList(4, 1, 2, 3, 6, 5, 7, 8);
        System.out.print("Fila 3: ");
        minimumBribes(q3);
    }
}