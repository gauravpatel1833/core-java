package com.corejava.practice.corejava.singleton;

import java.io.Serializable;

public class LazySingleton extends BaseClass implements Serializable {

    private String id;
    private static LazySingleton instance;

    //To mark the class as singleton you should have private constructor to not allow create object
    //To avoid singleton break using reflection check for instance.
    private LazySingleton(){
        if(instance!=null){
            throw new IllegalStateException("Object cannot be created using reflection.");
        }
    }

    //Invoker need to get singleton object from getInstance only.
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    //To avoid this object clone override clone method in singleton class and throw exception in it.
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Singleton class object cannot be cloned");
    }

    //To avoid singleton break by creating object using serialization and deserialize override below method to return same instance.
    protected Object readResolve(){
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
