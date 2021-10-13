package com.corejava.practice.corejava.executorservice;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorRunnableSubmitUtil {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println(new Date());

        //Submit method will not return anything in case of runnable task.
        //However, in case of callable interface it will return Future Objects. Whose get method will be blocking operations.
        for(int i=0;i<25;i++){
            executorService.submit(new Service(i));
        }

        //Shutdown needs to be done to signal the threadpool to close it's process.
        executorService.shutdown();
        //await termination make sure the process wait for the completion.
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(new Date());
    }
}
