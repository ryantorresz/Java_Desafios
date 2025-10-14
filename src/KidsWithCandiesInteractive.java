import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) left++;
            while (left < right && !vowels.contains(chars[right])) right--;

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Input: IceCreAm -> Output: " + solution.reverseVowels("IceCreAm"));
        System.out.println("Input: leetcode -> Output: " + solution.reverseVowels("leetcode"));

        System.out.println("Input: hello -> Output: " + solution.reverseVowels("hello"));
        System.out.println("Input: AEIOU -> Output: " + solution.reverseVowels("AEIOU"));
        System.out.println("Input: aA -> Output: " + solution.reverseVowels("aA"));
        System.out.println("Input: xyz -> Output: " + solution.reverseVowels("xyz"));
        System.out.println("Input: empty string -> Output: " + solution.reverseVowels(""));
        System.out.println("Input: a -> Output: " + solution.reverseVowels("a"));
        System.out.println("Input: programming -> Output: " + solution.reverseVowels("programming"));
    }
}