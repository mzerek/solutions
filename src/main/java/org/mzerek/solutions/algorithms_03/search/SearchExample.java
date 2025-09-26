package main.java.org.mzerek.solutions.algorithms_03.search;

public class SearchExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 3, 8, 9};
        int param = 12;
        int paramPosition = searchParam(param, array);
        System.out.println("Param: " + param + " exists at positon: " + paramPosition);
    }
    public static int searchParam(int param, int[] array) {
        for(int i=0; i<array.length; i++){
            if (array[i] == param) {
                return i+1;
            }
        }
        throw new RuntimeException("Param: " + param + " not exists");
    }
}
