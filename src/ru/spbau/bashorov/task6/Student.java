package ru.spbau.bashorov.task6;

/**
 * Student bean
 */
public class Student {
    String name;
    String surname;
    int age;
    double avgGrade;
    char charProp;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public char getChar(){
        return charProp;
    }

    public void setCharProp(char value){
        charProp = value;
    }
}