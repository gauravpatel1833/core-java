package com.corejava.practice.corejava.executorservice;

class Service implements Runnable{
    int i = 0;

    public Service(int i){
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println(i+" ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
