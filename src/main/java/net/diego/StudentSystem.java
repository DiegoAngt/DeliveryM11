package net.diego;

import java.util.*;

public class StudentSystem {

    static ArrayList<String> names = new ArrayList<>();
    static HashMap<String, Double> studentGrades = new HashMap<>();
    static double[] grades = new double[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {

            System.out.println("\nSTUDENT SYSTEM v1.0");
            System.out.println("1. Register students");
            System.out.println("2. View grades");
            System.out.println("3. View statistics");
            System.out.println("4. Search student");
            System.out.println("5. Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();

                    if (grade >= 0 && grade <= 10) {

                        names.add(name);
                        studentGrades.put(name, grade);
                        grades[count] = grade;
                        count++;

                        Student s = new Student(name, age, grade);
                        s.displayInfo(true);

                    } else {
                        System.out.println("Invalid grade. Must be between 0 and 10.");
                    }

                    break;

                case 2:

                    for (String student : names) {
                        System.out.println(student + " - " + studentGrades.get(student));
                    }

                    break;

                case 3:

                    System.out.println("Average: " + calculateAverage(grades, count));
                    System.out.println("Highest: " + highestGrade(grades, count));
                    System.out.println("Lowest: " + lowestGrade(grades, count));
                    System.out.println("Passed: " + countPassed(grades, count));

                    break;

                case 4:

                    System.out.print("Enter student name: ");
                    String search = scanner.nextLine();

                    if (studentGrades.containsKey(search)) {
                        double g = studentGrades.get(search);
                        System.out.println(search + " grade: " + g + " - " + getStatus(g));
                    } else {
                        System.out.println("Student not found");
                    }

                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static double calculateAverage(double[] grades, int size) {
        double sum = sumGrades(grades, size - 1);
        return sum / size;
    }

    public static double sumGrades(double[] grades, int i) {
        if (i < 0)
            return 0;
        return grades[i] + sumGrades(grades, i - 1);
    }

    public static double highestGrade(double[] grades, int size) {

        double max = grades[0];

        for (int i = 1; i < size; i++) {
            if (grades[i] > max)
                max = grades[i];
        }

        return max;
    }

    public static double lowestGrade(double[] grades, int size) {

        double min = grades[0];

        for (int i = 1; i < size; i++) {
            if (grades[i] < min)
                min = grades[i];
        }

        return min;
    }

    public static int countPassed(double[] grades, int size) {

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (grades[i] >= 6)
                count++;
        }

        return count;
    }

    public static String getStatus(double grade) {

        if (grade >= 6)
            return "Passed";
        else
            return "Failed";
    }
}
