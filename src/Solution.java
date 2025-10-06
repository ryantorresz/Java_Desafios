class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedString = s.trim();


        int lastSpaceIndex = trimmedString.lastIndexOf(' ');


        return trimmedString.length() - (lastSpaceIndex + 1);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("--- Testes de Comprimento da Última Palavra ---");

        String s1 = "Hello World";
        int result1 = solution.lengthOfLastWord(s1);
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + result1 + " \n");

        String s2 = "   fly me   to   the moon  ";
        int result2 = solution.lengthOfLastWord(s2);
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + result2 + " \n");

        String s3 = "luffy is still joyboy";
        int result3 = solution.lengthOfLastWord(s3);
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + result3 + " \n");

        String s4 = "   única   ";
        int result4 = solution.lengthOfLastWord(s4);
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + result4 + "\n");
    }
}