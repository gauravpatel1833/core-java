package com.corejava.practice.corejava.sort;

import java.util.*;
import java.util.stream.Collectors;

public class SortMap {

    public static void main(String[] args) {

        
        HashMap<String, String> codenames = new HashMap<String, String>();
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        codenames.put("Java SE 7", "Dolphin");

        //No order guarantee
        System.out.println(codenames);


        Map<String, String> sortedMapByKey = codenames.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(sortedMapByKey);

        //Sort based on key
        //map.entrySet().stream().sorted((o1,o2) -> o1.getKey().compareTo(o2.getKey())).forEach(o -> System.out.println(o.getKey()));

        //map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        //Sort based on value
        //map.entrySet().stream().sorted((o1,o2) -> o1.getValue() - o2.getValue()).forEach(o -> System.out.println(o));
        //map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    }
}
