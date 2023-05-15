package org.mzerek.solutions.mystrichrepeater;

public class SolutionFirstChar {

    String findFirstSingleChar(String someText) {
        int textLength = someText.length();
        //System.out.println("someText: " + someText);
        //System.out.println("textLength: " + textLength);


        for (int i = 0; i <= textLength - 1; i++) {
            char v = someText.charAt(i);
            System.out.println("v: " + v);
            int counter = 1;
            for (int j = 0; j <= textLength - 1; j++) {
                if (v == someText.charAt(j) && i != j) {
                    counter++;
                }
            }
            if (counter == 1) {
                return String.valueOf(v);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        SolutionFirstChar ssr = new SolutionFirstChar();

        //String singleCharacter = ssr.findFirstSingleChar("some test text");
        String singleCharacter = ssr.findFirstSingleChar("somoe test tmext");
        if (singleCharacter != null) {
            System.out.println("First single character: " + singleCharacter);
        } else {
            System.out.println("Not exists any single character");
        }
    }

}
