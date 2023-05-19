package org.mzerek.solutions.mymaxstudentaverage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/students-with-maximum-average-score-of-three-subjects/
public class SolutionMaxAverage {

    public static void main(String[] args) {
       String[][] studentRates = {{"Franek Kimono", "4.5", "3.6", "77", "5.8"}, {"Henryk Kowalski", "2.5", "5.5", "3.6"},
                {"Tomek Zdulski", "2.5", "1.5", "27", "6.6", "12"}};

        Student student = maxStudentAverage(studentRates);
        System.out.println("Student: " + student.getNameAndLastName() + " has max average: " + student.getMaxAverage());
    }

    public static Student maxStudentAverage(String[][] studentRates) {

        int numberOfStudents = studentRates.length;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            int numberOfRates = studentRates[i].length - 1;
            System.out.println("Student : " + studentRates[i][0]);
            System.out.println("Number of rates: " + numberOfRates);
            double sumOfRates = 0.0;
            for (int j = 1; j <= numberOfRates; j++) {
                sumOfRates = sumOfRates + Double.parseDouble(studentRates[i][j]);
            }
            double average = sumOfRates / numberOfRates;
            System.out.println("Average: " + average);
            System.out.println("========================");
            students.add(new Student(studentRates[i][0], average));
        }

        return students.stream()
                .max(Comparator.comparing(Student::getMaxAverage))
                .get();
    }
}

class Student {
    private String nameAndLastName;

    private double maxAverage;

    public Student(String nameAndLastName, double maxAverage) {
        this.nameAndLastName = nameAndLastName;
        this.maxAverage = maxAverage;
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public double getMaxAverage() {
        return maxAverage;
    }
}
