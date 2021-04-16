package me.bingbingpa.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestUnit {
    private static String methodName;
    public static <T> void test(Class<T> classType) {
        T instance = createInstance(classType);
        System.out.println("==========================START=======================================");
        Arrays.stream(classType.getDeclaredMethods()).forEach(f -> {
            if (f.getAnnotation(CustomTest.class) != null) {
                try {
                    methodName = f.getName();
                    f.setAccessible(true);
                    f.invoke(instance);
//                    Object resultType = f.invoke(instance);
                    // return 타입 Boolean 인 메소드에 대해서만 메시지 출력
//                    if (resultType instanceof Boolean) {
//                        printMessage(f.getName(), (Boolean)resultType);
//                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("reflection error =========== " + e.getMessage());
                }
            }
        });
        System.out.println("===========================END========================================");
    }

//    public static void printMessage(String methodName, boolean testResult) {
//        String message = "CustomTest ==== methodName: " + methodName + ", result: " + testResult;
//        if (!testResult) {
//            System.err.println(message);
//            return;
//        }
//        System.out.println(message);
//    }

    public static void printMessage(boolean testResult) {
        String message = "CustomTest ==== methodName: " + methodName + ", result: " + testResult;
        if (!testResult) {
            System.err.println(message);
            return;
        }
        System.out.println(message);
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor((Class<?>[]) null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
