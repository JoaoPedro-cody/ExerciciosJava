package Entities;

public class PeopleData {
    private double height;
    private char sex;

    public PeopleData(double height, char sex) {
        this.height = height;
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public char getSex() {
        return sex;
    }
}
