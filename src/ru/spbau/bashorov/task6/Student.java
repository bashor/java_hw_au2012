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

    /**
     * @return name value
     */
    public String getName(){
        return name;
    }

    /**
     * Set name value
     * @param name new value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return get surname value
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set surname value
     * @param surname new value
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return age value
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age value
     * @param age new value
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return avgGrade value
     */
    public double getAvgGrade() {
        return avgGrade;
    }

    /**
     * Set avgGrade value
     * @param avgGrade new value
     */
    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    /**
     * @return get charProp value
     */
    public char getChar(){
        return charProp;
    }

    /**
     * Set charProp value
     * @param value new value
     */
    public void setCharProp(char value){
        charProp = value;
    }
}