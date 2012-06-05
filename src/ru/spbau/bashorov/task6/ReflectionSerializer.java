package ru.spbau.bashorov.task6;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Reflection Serializer
 */
public class ReflectionSerializer {

    /**
     * Serialization object to file
     *
     * @param object
     * @param filename target file
     * @param <T>      class type
     * @throws Exception
     */
    public <T> void serialize(T object, String filename) throws Exception {
        Properties properties = new Properties();
        Class<?> clazz = object.getClass();

        Method methods[] = clazz.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            if (!name.startsWith("get") || name.length() == 3)
                continue;

            String property = Character.toLowerCase(name.charAt(3)) + name.substring(4);
            Object value = m.invoke(object);
            if (value != null) {
                properties.setProperty(property, value.toString());
            }
        }

        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);
            properties.store(writer, "");
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}