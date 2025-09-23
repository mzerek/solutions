package main.java.org.mzerek.solutions.algorithms_03.sam_example;

import java.util.List;

public class Example2 {

    public static void main(String[] args) {

        List<Integer> mainList = List.of(-1, 0, 5, -3, 2);
        System.out.println("Main list: " + mainList);

        int maxSum = 0;

        for (int i = 0; i <= mainList.size(); i++) {
            for (int j = i + 1; j <= mainList.size(); j++) {
                List<Integer> subList = mainList.subList(i, j);
                System.out.println("SubList: " + subList);
                int sum = subList.stream().mapToInt(x -> x).sum();
                System.out.println("Sum: " + sum);
                if(sum>=maxSum){
                    maxSum = sum;
                }
            }
        }

        System.out.println("Max sum is: " + maxSum);
    }

}
