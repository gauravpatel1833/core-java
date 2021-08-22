package com.corejava.practice.corejava.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    public static void main(String[] args) throws CloneNotSupportedException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1. Will give compile error as private construction singleton object
        // LazySingleton lazySingleton = new LazySingleton();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton.hashCode());

        /*2. Clone will break singleton pattern if singleton class implements cloneable or it's parent class implement cloneable.
             With clone we will be able to create new object of singleton.
             To avoid this override clone method in singleton class and throw exception in it.*/
        LazySingleton clonedSingleton = (LazySingleton) lazySingleton.clone();
        System.out.println(clonedSingleton.hashCode());

        /*3. With Reflection we can break singleton pattern.
             To avoid it in private constructor of singleton check existence of object*/
        LazySingleton reflectionSingletonObj = null;

        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            reflectionSingletonObj = (LazySingleton) constructor.newInstance();
        }
        System.out.println(reflectionSingletonObj.hashCode());

        /*4. To avoid singleton break using serialization need to override readResolve method in singleton class and return same instance*/

    }
}
