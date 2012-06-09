package ru.spbau.bashorov.task6;

import java.io.FileNotFoundException;

/**
 * Start class
 */
public class Main {

    /**
     * Entry point
     * @param args filename to update avgGrade or nothing to create example
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                createExampleFile();
            } else {
                increaseAvgGrade(args[0]);
            }
        } catch (IllegalSerializationException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Create file with example object
     * @throws IllegalSerializationException
     */
    public static void createExampleFile() throws IllegalSerializationException {
        ReflectionSerializer s = new ReflectionSerializer();
        Student st = new Student();
        st.setAge(0x19);
        st.setName("Aaaaa");
        st.setSurname("Bbbbbbbb");
        st.setAvgGrade(2.1);
        st.setCharProp('A');
        s.serialize(st, "student.properties");
    }

    /**
     * Increase avgGrade in file
     * @param filename to update
     * @throws IllegalSerializationException, FileNotFoundException
     */
    public static void increaseAvgGrade(String filename) throws IllegalSerializationException, FileNotFoundException {
        ReflectionDeSerializer d = new ReflectionDeSerializer();
        Student student = d.deserialize(filename, Student.class);

        student.avgGrade = Math.min(5.0, student.avgGrade + 1.0);

        ReflectionSerializer s = new ReflectionSerializer();
        s.serialize(student, filename);
    }
}