package main.java.org.mzerek.solutions.algorithms_03.reverse;

public class ReverseString {

    public static void main(String[] args) {
        String text = "What a wonderful day!";
        StringBuilder reverseText = new StringBuilder();

        for(int i = 0; i<text.length(); i++) {
            char t = text.charAt((text.length()-1)-i);
            reverseText.append(t);
        }
        System.out.println("Normal text is: " + text);
        System.out.println("Reverse text is: " + reverseText);
    }
}
