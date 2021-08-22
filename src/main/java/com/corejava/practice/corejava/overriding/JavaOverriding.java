package com.corejava.practice.corejava.overriding;

class TestA{
    protected void methodTestA(){
        System.out.println("methodTestA");
    }
    static void display(){
        System.out.println("static display");
    }
}

class TestB extends TestA{

    /*For overriding we cannot change return type*/
    /*public String methodTestA(){
        System.out.println("methodTestB");
        return "ss";
    }*/

    /*Access specifier should be equal or greater from parent class*/
    /*private void methodTestA(){
        System.out.println("methodTestB");
    }*/

    protected void methodTestA(){
        System.out.println("methodTestB");
    }
}

public class JavaOverriding {
    public static void main(String[] args) {
        TestA a = new TestB();
        a.methodTestA();
        TestB.display();
    }
}
