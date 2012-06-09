package ru.spbau.bashorov.task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;
import java.util.Set;

/**
 * Reflection DeSerializer
 */
public class ReflectionDeSerializer {

    /**
     * DeSerialize object from file
     * @param filename source file
     * @param clazz object class
     * @param <T> class type
     * @return DeSerialized object
     * @throws IllegalSerializationException, FileNotFoundException
     */
    public <T> T deserialize(String filename, Class<T> clazz) throws IllegalSerializationException, FileNotFoundException {
        T object;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalSerializationException("Can not deserialize. Detail info: " + e.getMessage());
        }

        Properties properties = new Properties();

        FileReader reader = null;
        try{
            reader = new FileReader(filename);
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalSerializationException("Can not deserialize. Detail info: " + e.getMessage());
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        Method methods[] = clazz.getDeclaredMethods();
        Arrays.sort(methods, new Comparator<Method>() {
            public int compare(Method a, Method b) {
                return a.getName().compareTo(b.getName());
            }
        });

        Set<String> names = properties.stringPropertyNames();
        for (String name : names) {
            final String setterName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

            int res = Arrays.binarySearch(methods, setterName, new Comparator<Object>() {
                public int compare(Object method, Object name) {
                    String methodName = ((Method) method).getName();
                    return methodName.compareTo((String) name);
                }
            });

            if (res < 0)
                continue;

            Method method = methods[res];
            String value = properties.getProperty(name);

            Class<?> cl = method.getParameterTypes()[0];
            try {
                method.invoke(object, getObjectByStringValue(cl, value));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new IllegalSerializationException("Can not deserialize. Detail info: " + e.getMessage());
            }

        }

        return object;
    }

    private static Object getObjectByStringValue(Class<?> clazz, String value) throws IllegalSerializationException {
        if (clazz == String.class) {
            return value;
        }

        if (clazz == char.class) {
            if (value != null && value.length() == 1) {
                return value.charAt(0);
            } else {
                throw new IllegalSerializationException("Type char doesn't match with actual value: " + value);
            }
        }

        if (clazz.isPrimitive()) {
            try {
                Object wrappedObject = Array.get(Array.newInstance(clazz, 1), 0);
                Method valueOfMethod = wrappedObject.getClass().getMethod("valueOf", String.class);
                return valueOfMethod.invoke(wrappedObject.getClass(), value);
            } catch (ReflectiveOperationException e) {
                throw new IllegalSerializationException("Can not recognize data format");
            }
        } else {
            throw new IllegalSerializationException("Unsupported type");
        }
    }
}