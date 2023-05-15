package org.mzerek.solutions.mysteppingnumbers;

//https://www.codingninjas.com/codestudio/library/stepping-numbers
public class SolutionSteppingNumbers {

    boolean isSteppingNumber(int x) {


        int previewNumber = -1;

        while (x > 0) {
            //System.out.println("x: " + x);
            int currentNumber = x % 10;
            //System.out.println("previewNumber1: " + previewNumber);
            //System.out.println("currentNumber1: " + currentNumber);

            if (previewNumber != -1) {
                if (Math.abs(currentNumber - previewNumber) != 1) {
                    return false;
                }
            }
            x = x / 10;

            previewNumber = currentNumber;

        }

        return true;
    }

    void displaySteppingNumber(int begin, int end) {
        for(int i = begin; i <=end; i++) {
            if(isSteppingNumber(i)) {
                System.out.println(i + "");
            }
        }
    }

    public static void main(String[] args) {
        SolutionSteppingNumbers ssn = new SolutionSteppingNumbers();
        boolean steppingNumber = ssn.isSteppingNumber(345678);
        System.out.println("Is stepping number: " + steppingNumber);

        ssn.displaySteppingNumber(15, 45);
    }
}
