package me.bingbingpa.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 코딩 테스트 TDD 를 위한 클래스
 */
public class TestUnit {
    private static String methodName;
    private static int index = 0;

    /**
     * 해당 클래스에서 @CustomTest 애노테이션이 붙은 메소드를 실행
     */
    public static <T> void test(Class<T> classType) {
        T instance = createInstance(classType);
        System.out.println("==========================START=======================================");
        Arrays.stream(classType.getDeclaredMethods()).forEach(f -> {
            if (f.getAnnotation(CustomTest.class) != null) {
                try {
                    methodName = f.getName();
                    index = 0;
                    f.setAccessible(true);
                    f.invoke(instance);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("reflection error =========== " + e.getMessage());
                }
            }
        });
        System.out.println("===========================END========================================");
    }

    /**
     * 테스트 결과에 따른 콘솔 메시지 출력
     */
    public static void printMessage(boolean testResult) {
        String message = "CustomTest ==== methodName(" + index++ + "):" + methodName + ", result: " + testResult;
        if (!testResult) {
            System.err.println(message);
            return;
        }
        System.out.println(message);
    }

    /**
     *  해당 클래스 인스턴스 생성
     */
    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor((Class<?>[]) null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
