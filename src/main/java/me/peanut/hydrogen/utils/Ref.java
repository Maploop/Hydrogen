package me.peanut.hydrogen.utils;

import java.lang.reflect.Field;

public class Ref
{
    public static <T, E> T get(E clazz, String fieldName) {
        try {
            Field field = clazz.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
