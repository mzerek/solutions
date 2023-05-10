package org.mzerek.solutions.myreversestring;

public class SolutionReverseString {

    public static void main(String[] args) {

        String normal = "kaloryfer";
        String reverse = "";

        for(int i=0 ; i < normal.length(); i++) {
            char c = normal.charAt(i);

            System.out.println("char at index: " + i + " is: " + c);

            reverse = c + reverse;
        }

        System.out.println("Normal word " + normal);
        System.out.println("Reverse word " + reverse);

    }
}
