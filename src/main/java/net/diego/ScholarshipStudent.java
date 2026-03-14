package net.diego;

/**
 * Represents a scholarship student.
 * Overrides the getType method to indicate the student type.
 */

public class ScholarshipStudent extends Student {

    public ScholarshipStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    @Override
    public String getType() {
        return "Scholarship";
    }
}
