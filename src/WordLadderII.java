import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        // Convert wordList to set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return result;

        // Map to store the parent relationships for BFS
        Map<String, List<String>> parents = new HashMap<>();

        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Set for current level and next level
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> nextLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Generate all possible transformations
                char[] charArray = current.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char original = charArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        charArray[j] = c;
                        String transformed = new String(charArray);

                        if (transformed.equals(endWord)) {
                            found = true;
                        }

                        if (wordSet.contains(transformed) && !visited.contains(transformed)) {
                            if (!nextLevel.contains(transformed)) {
                                queue.offer(transformed);
                                nextLevel.add(transformed);
                            }

                            // Add parent relationship
                            parents.computeIfAbsent(transformed, k -> new ArrayList<>()).add(current);
                        }
                    }
                    charArray[j] = original;
                }
            }
            visited.addAll(nextLevel);
        }

        // If we found the endWord, backtrack to find all paths
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void backtrack(String current, String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path,
                           List<List<String>> result) {

        if (current.equals(beginWord)) {
            List<String> completePath = new ArrayList<>(path);
            Collections.reverse(completePath);
            result.add(completePath);
            return;
        }

        if (!parents.containsKey(current)) return;

        for (String parent : parents.get(current)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }

    // Alternative optimized solution using bidirectional BFS
    public List<List<String>> findLaddersOptimized(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return result;

        // Bidirectional BFS setup
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);

        boolean found = false;
        boolean reverse = false;

        while (!startSet.isEmpty() && !endSet.isEmpty() && !found) {
            // Always work with the smaller set
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
                reverse = !reverse;
            }

            Set<String> nextLevel = new HashSet<>();
            wordSet.removeAll(startSet);

            for (String word : startSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char original = charArray[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        charArray[i] = c;
                        String transformed = new String(charArray);

                        if (endSet.contains(transformed)) {
                            found = true;
                        }

                        if (wordSet.contains(transformed)) {
                            nextLevel.add(transformed);

                            String key = reverse ? transformed : word;
                            String value = reverse ? word : transformed;

                            graph.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                        }
                    }
                    charArray[i] = original;
                }
            }
            startSet = nextLevel;
        }

        // Build paths using DFS
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, graph, path, result);
        }

        return result;
    }

    private void dfs(String current, String endWord,
                     Map<String, List<String>> graph,
                     List<String> path,
                     List<List<String>> result) {

        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(current)) return;

        for (String next : graph.get(current)) {
            path.add(next);
            dfs(next, endWord, graph, path, result);
            path.remove(path.size() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        WordLadderII solution = new WordLadderII();

        // Test case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result1 = solution.findLadders(beginWord1, endWord1, wordList1);
        System.out.println("Test case 1:");
        for (List<String> path : result1) {
            System.out.println(path);
        }

        // Test case 2
        String beginWord2 = "red";
        String endWord2 = "tax";
        List<String> wordList2 = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");

        List<List<String>> result2 = solution.findLaddersOptimized(beginWord2, endWord2, wordList2);
        System.out.println("\nTest case 2 (Optimized):");
        for (List<String> path : result2) {
            System.out.println(path);
        }
    }
}