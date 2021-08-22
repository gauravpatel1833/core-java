package com.corejava.practice.corejava.immutableclass;

import java.util.HashMap;
import java.util.Map;


//An Immutable Class
public final class Student {

    /*
    1.The class must be declared as final (So that child classes can’t be created)
    2.Data members in the class must be declared as private (So that direct access is not allowed)
    3.Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
    4.A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
    5.Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
    6.No setters (To not have the option to change the value of the instance variable)*/

    private final String name;
    private final int regNo;
    private final Map<String,String> metadata;

    public Student(String name, int regNo, Map<String, String> metadata) {
        this.name = name;
        this.regNo = regNo;

        //Deep copy collection object to avoid changing original object when multiple objects get created
        Map<String,String> tempMap = new HashMap<>();
        metadata.forEach((k,v) -> tempMap.put(k,v));
        this.metadata = tempMap;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetadata() {
        //Deep copy collection object to avoid changing original object when multiple objects get created
        Map<String,String> tempMap = new HashMap<>();
        this.metadata.forEach((k,v) -> tempMap.put(k,v));
        return tempMap;
    }
}

// Driver class
class Test {
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        Student s = new Student("ABC", 101, map);
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());

        // Uncommenting below line causes error
        //s.regNo = 102;

        map.put("3", "third");
        System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in constructor

        s.getMetadata().put("4", "fourth");
        System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in getter
    }
}
