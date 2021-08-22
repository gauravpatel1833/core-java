package com.corejava.practice.corejava.map;

import java.util.HashMap;
import java.util.Map;

public class SumValuesOfMap {

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        System.out.println(map.values().stream().mapToInt(i -> Integer.parseInt(i.toString())).sum());

        int sum = 0;
        for (Object o : map.keySet()) {
            int v = (int) map.get(o);
            sum = sum + v;
        }
    }
}
