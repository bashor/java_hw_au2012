package ru.spbau.bashorov.task6;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Reflection Serializer
 */
public class ReflectionSerializer {

    /**
     * Serialization object to file
     *
     * @param object to serialize
     * @param filename target file
     * @param <T>      class type
     * @throws IllegalSerializationException when have some problem
     */
    public <T> void serialize(T object, String filename) throws IllegalSerializationException{
        Properties properties = new Properties();
        Class<?> clazz = object.getClass();

        Method methods[];
        try {
            methods = clazz.getDeclaredMethods();
        } catch (SecurityException e) {
            throw new IllegalSerializationException("Can not serialize. Detail info: " + e.getMessage());
        }
        for (Method m : methods) {
            String name = m.getName();
            if (name.length() <= 3 || !name.startsWith("get"))
                continue;

            String property = Character.toLowerCase(name.charAt(3)) + name.substring(4);
            Object value = null;
            try {
                value = m.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (value != null) {
                properties.setProperty(property, value.toString());
            }
        }

        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);
            properties.store(writer, "");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalSerializationException("Can not serialize. Detail info: " + e.getMessage());
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new IllegalSerializationException("Can not serialize. Detail info: " + e.getMessage());
                }
        }
    }

}