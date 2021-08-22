package com.corejava.practice.corejava.overloading;


//Overloading methods can have different return and input datatype and access modifier
class A{
    protected void methodA(int a){
        System.out.println("methodA:"+a);
    }
    private String methodA(int a,String b){
        System.out.println("methodA with 2 arguments");
        return a+b;
    }
}

public class JavaOverloading {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(1);
    }
}
