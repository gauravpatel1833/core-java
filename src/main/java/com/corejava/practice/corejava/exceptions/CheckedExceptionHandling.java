package com.corejava.practice.corejava.exceptions;

/*For checked exception we need to declare throws as it will not propagate to call hierarchy like unchecked exceptions.
If child class override method is throwing error then parent class method also need to add throws.
If parent is throwing and child is not then no throws required in child.
In case of checked exception entire call hierarchy needs to use throws until try catch with exception is handled.*/

class C{

    public void display(int age) throws CustomCheckedException {
        System.out.println("Override age :"+age);
    }
}

class D extends C {

    public void show(int age) throws CustomCheckedException {
        display(age);
    }
    public void display(int age) throws CustomCheckedException{
        if(age > 18) {
            System.out.println("age is :" + age);
        }else{
            throw new CustomCheckedException("Age is less than 18");
        }
    }

}

public class CheckedExceptionHandling {

    public static void main(String[] args) {
        C d = new D();
        D d1= new D();
        try {
            d.display(14);
            d1.show(15);
        }catch (CustomCheckedException e){
            System.out.println("Handling Checked exception as it will not propagate to call hierarchy so need of throws");
        }

    }
}
