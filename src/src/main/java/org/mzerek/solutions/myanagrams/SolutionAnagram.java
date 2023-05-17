package org.mzerek.solutions.myanagrams;

import java.util.*;

//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/

public class SolutionAnagram {

    public static Map<String, List<String>> findAnagrams(String[] table) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : table) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String wordKey = new String(letters);

            if (anagramMap.containsKey(wordKey)) {
                anagramMap.get(wordKey).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                anagramMap.put(wordKey, words);
            }
        }
        return anagramMap;
    }

    public static void printAnagrams(Map<String, List<String>> anagramMap) {
        anagramMap.forEach((key, value) -> System.out.println(value));
    }

    public static void main(String[] args) {

        String[] table = {"cat", "dog", "tac", "god", "act"};
        Map<String, List<String>> anagramMap = findAnagrams(table);
        printAnagrams(anagramMap);
    }
}
