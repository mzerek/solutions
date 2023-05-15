package org.mzerek.solutions.myfirstcharsearch;

//https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/amp/
public class SolutionGfGFirstChar {

    String findFirstSingleChar(String someText) {
        char searchValue = ' ';

        for (char v : someText.toCharArray()) {
            if (someText.indexOf(v) == someText.lastIndexOf(v)) {
                searchValue = v;
                break;
            }
        }

        return String.valueOf(searchValue);
    }

    public static void main(String[] args) {
        SolutionGfGFirstChar ssr = new SolutionGfGFirstChar();
        //String singleCharacter = ssr.findFirstSingleChar("some test text");
        String singleCharacter = ssr.findFirstSingleChar("somoe test tmext");
        if (!singleCharacter.isBlank()) {
            System.out.println("First single character: " + singleCharacter);
        } else {
            System.out.println("Not exists any single character");
        }
    }
}
