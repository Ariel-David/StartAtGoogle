package startAtGoogle.Reflections.exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class Main {

    public static Optional<Object> getNewInstanceFrom(Object o) {
        Class<?> clz = o.getClass();
        try {
            Constructor<?> constructor = clz.getConstructor(String.class);
            Object object = constructor.newInstance("yael");
            return Optional.of(object);
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Faild to instantiate constructor", e);
        }
    }

    public static void main(String[] args) throws Exception {
        Optional<Object> girl = getNewInstanceFrom(new Girl("yael"));
        System.out.println("Girl is exist:" + girl.isPresent());

        Optional<Object> boy = getNewInstanceFrom(new Boy());
        System.out.println("Boy is exist:" + boy.isPresent());
    }
}
