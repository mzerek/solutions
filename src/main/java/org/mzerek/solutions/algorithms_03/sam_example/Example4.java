package main.java.org.mzerek.solutions.algorithms_03.sam_example;

public class Example4 {
    public static void main(String[] args) {
        String s1 = "qwerty";
        String s2 = "tyqwre";
        System.out.println("Result: " + compareRotation(s1.toCharArray(), s2.toCharArray()));
        //false

        String s3 = "qwerty";
        String s4 = "tyqwer";
        System.out.println("Result: " + compareRotation(s3.toCharArray(), s4.toCharArray()));
        //true

        String s5 = "abcd";
        String s6 = "cdab";
        System.out.println("Result: " + compareRotation(s5.toCharArray(), s6.toCharArray()));
        //true

        String s7 = "abcd";
        String s8 = "dcab";
        System.out.println("Result: " + compareRotation(s7.toCharArray(), s8.toCharArray()));
        //false
    }

    public static boolean compareRotation(char[] s1Tab, char[] s2Tab) {
        for (int i = 0; i < s1Tab.length; i++) {
            if(compareArray(s1Tab, s2Tab, i)) {
                return true;
            }
        }
        return false;
    }
    public static boolean compareArray(char[] s1Tab, char[] s2Tab, int i) {
        for(int j=0; j< s1Tab.length; j++){
            int x = j+i;
            if(x >= s1Tab.length){
                x = x - s1Tab.length;
            }
            if(s1Tab[j] != s2Tab[x]){
                return false;
            }
        }
        return true;
    }
}
