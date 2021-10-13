package com.corejava.practice.corejava.executorservice;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorRunnableExecuteUtil {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println(new Date());

        //Execute method will not return anything. It will just submit the task.
        for(int i=0;i<25;i++){
            executorService.execute(new Service(i));
        }

        //Shutdown needs to be done to signal the threadpool to close it's process.
        executorService.shutdown();
        //await termination make sure the process wait for the completion.
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(new Date());
    }
}
