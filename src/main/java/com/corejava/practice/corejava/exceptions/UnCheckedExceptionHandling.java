package com.corejava.practice.corejava.exceptions;

/*In case of unchecked exceptions we don't need to hanlde them they will automatically
propagate in the entire call hierarchy*/

class A{

    public void display(int age) {
        if(age > 18) {
            System.out.println("age is :" + age);
        }else{
            throw new CustomUncheckedException("Age is less than 18");
        }
    }
}
class B extends A {

    public void show(int age){
        display(age);
    }

}

public class UnCheckedExceptionHandling {

    public static void main(String[] args) {
        B b = new B();
        try {
            b.show(14);
        }catch (CustomUncheckedException e){
            System.out.println("Handling unchecked exception as it will propagate to call hierarchy no need of throws");
        }

    }
}
