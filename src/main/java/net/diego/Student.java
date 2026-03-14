package net.diego;

public class Student extends Person {

    private double grade;

    public Student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStatus() {
        if (grade >= 6.0) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    public String getType() {
        return "Student";
    }

    public void displayInfo() {
        System.out.println(getName() + " - Grade: " + grade);
    }

    public void displayInfo(boolean showStatus) {
        if (showStatus) {
            System.out.println(getName() + " - Grade: " + grade + " - " + getStatus());
        } else {
            displayInfo();
        }
    }
}
