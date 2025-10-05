package main.java.org.mzerek.solutions.algorithms_03.snowPackage;

import java.util.Arrays;

//https://www.csestack.org/snow-between-hills-coding-challenge/
public class SnowExample {

    public static void main(String[] args) {
        int[] table = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println("table: " + Arrays.toString(table));

        System.out.println("table sum: " + countSnowPackage(table));

        System.out.println("======================");

        int[] table2 = {0, 3, 1, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println("table: " + Arrays.toString(table2));

        System.out.println("table2 sum: " + countSnowPackage(table2));
    }

    public static int countSnowPackage(int[] table){

        int[] leftTableWithMax = new int[table.length];
        int[] rightTableWithMax = new int[table.length];

        int leftMax = table[0];
        int rightMax = table[table.length - 1];

        for(int i=0; i<table.length; i++){
            if(leftMax<table[i]){
                leftMax = table[i];
            }
            leftTableWithMax[i] = leftMax;
        }

        System.out.println("leftTable: " + Arrays.toString(leftTableWithMax));

        for(int i=table.length-1; i>-1; i--){
            if(rightMax<table[i]){
                rightMax = table[i];
            }
            rightTableWithMax[i] = rightMax;
        }

        System.out.println("rightTable: " + Arrays.toString(rightTableWithMax));

        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            sum = sum + Math.min(leftTableWithMax[i], rightTableWithMax[i]) - table[i];
        }
        return sum;
    }
}
