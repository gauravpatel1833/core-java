package com.corejava.practice.corejava.comparatorvscomparable;

import org.omg.CORBA.OMGVMCID;

import java.util.*;

public class LaptopRunner {

    public static void main(String[] args) {

        List<LaptopBean> list = new ArrayList<>();
        list.add(new LaptopBean("Dell",32,50000));
        list.add(new LaptopBean("Apple",16,87000));
        list.add(new LaptopBean("Lenovo",8,27000));

        //To make list synchronized
        // Collections.synchronizedList(list);

        //Prints default insertion order
        System.out.println(list);

        Collections.sort(list);
        //Prints in ascending order of brand as bean is implementing comparable interface with compareTo method
        System.out.println(list);

        /* Older way to create comparator and pass to sort with lambda java8 it is not required.
        Comparator<LaptopBean> comparator = new Comparator<LaptopBean>() {
            @Override
            public int compare(LaptopBean o1, LaptopBean o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        };
        Collections.sort(list,comparator);
        */

        //Sort using comparator with compare to method in decreasing order overriding comparable
        Collections.sort(list,(l1,l2) -> l2.getBrand().compareTo(l1.getBrand()));
        System.out.println(list);

        //Sort using comparator with compare to method in increasing order of ram
        Collections.sort(list,(l1,l2) -> l1.getRam()-l2.getRam());
        System.out.println(list);
    }
}
