class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int currentVowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
        }

        int maxVowelCount = currentVowelCount;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }

            if (isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }

            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);

            if (maxVowelCount == k) {
                return k;
            }
        }

        return maxVowelCount;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();

        String s1 = "abciiidef";
        int k1 = 3;
        int result1 = solver.maxVowels(s1, k1);
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + result1); // Esperado: 3
        System.out.println("--------------------");

        String s2 = "aeiou";
        int k2 = 2;
        int result2 = solver.maxVowels(s2, k2);
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + result2); // Esperado: 2
        System.out.println("--------------------");

        String s3 = "leetcode";
        int k3 = 3;
        int result3 = solver.maxVowels(s3, k3);
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: " + result3); // Esperado: 2
        System.out.println("--------------------");

        String s4 = "rhythms";
        int k4 = 4;
        int result4 = solver.maxVowels(s4, k4);
        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        System.out.println("Output: " + result4); // Esperado: 0
        System.out.println("--------------------");
    }
}