
public class Solution {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = gcd(len1, len2);

        return str1.substring(0, gcdLength);
    }

    public static void main(String[] args) {
        String str1_1 = "ABCABC";
        String str2_1 = "ABC";
        String result1 = gcdOfStrings(str1_1, str2_1);
        System.out.println("Input: str1 = \"" + str1_1 + "\", str2 = \"" + str2_1 + "\"");
        System.out.println("Output: \"" + result1 + "\"");

        String str1_2 = "ABABAB";
        String str2_2 = "ABAB";
        String result2 = gcdOfStrings(str1_2, str2_2);
        System.out.println("Input: str1 = \"" + str1_2 + "\", str2 = \"" + str2_2 + "\"");
        System.out.println("Output: \"" + result2 + "\"");

        String str1_3 = "LEET";
        String str2_3 = "CODE";
        String result3 = gcdOfStrings(str1_3, str2_3);
        System.out.println("Input: str1 = \"" + str1_3 + "\", str2 = \"" + str2_3 + "\"");
        System.out.println("Output: \"" + result3 + "\"");
    }
}