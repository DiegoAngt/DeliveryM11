package net.diego;

/**
 * Represents a regular student.
 * Overrides the getType method to indicate the student type.
 */

public class RegularStudent extends Student {

    public RegularStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    @Override
    public String getType() {
        return "Regular";
    }
}
