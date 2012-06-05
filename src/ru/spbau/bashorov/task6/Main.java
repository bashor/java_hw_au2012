package ru.spbau.bashorov.task6;

/**
 * Start class
 */
public class Main {

    /**
     * Start point
     * @param args filename to update avgGrade or nothing to create example
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                createExampleFile();
            } else {
                increaseAvgGrade(args[0]);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Create file with example object
     * @throws Exception
     */
    public static void createExampleFile() throws Exception {
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
     * @throws Exception
     */
    public static void increaseAvgGrade(String filename) throws Exception {
        ReflectionDeSerializer d = new ReflectionDeSerializer();
        Student sn = d.deserialize(filename, Student.class);

        sn.avgGrade = Math.min(5.0, sn.avgGrade + 1.0);

        ReflectionSerializer s = new ReflectionSerializer();
        s.serialize(sn, filename);

    }
}