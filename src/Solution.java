class Solution {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();

        if (M == 0) {
            return 0;
        }

        for (int i = 0; i <= N - M; i++) {
            int j = 0;

            while (j < M) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }

            if (j == M) {
                return i;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Exemplo 1: Ocorrência encontrada no início
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int index1 = solution.strStr(haystack1, needle1);
        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + index1); // Esperado: 0

        System.out.println("---");

        // Exemplo 2: Ocorrência não encontrada
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int index2 = solution.strStr(haystack2, needle2);
        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + index2); // Esperado: -1

        System.out.println("---");

        // Exemplo 3: Ocorrência no meio
        String haystack3 = "mississippi";
        String needle3 = "issip";
        int index3 = solution.strStr(haystack3, needle3);
        System.out.println("Input: haystack = \"" + haystack3 + "\", needle = \"" + needle3 + "\"");
        System.out.println("Output: " + index3); // Esperado: 4
    }
}