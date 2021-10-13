package com.corejava.practice.corejava.executorservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorCallableSubmitUtil {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println(new Date());

        //Submit method will return data type from callable method. It will just submit the task.
        //and return the future object
        List<Future<String>> futureList = new ArrayList<>();

        for(int i=0;i<10;i++){
            Future<String> future = executorService.submit(new ServiceCallable(i));
            futureList.add(future);
        }

        //Shutdown needs to be done to signal the threadpool to close it's process.
        executorService.shutdown();
        //await termination make sure the process wait for the completion.
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("=============after execution=========");
        for (Future<String> future : futureList) {
            //get method is blocking operation if process is not completed then it will block the thread
            //till its completion.
            System.out.println(future.get());
        }
        System.out.println(new Date());
    }
}

class ServiceCallable implements Callable{

    int i;

    public ServiceCallable(int i){
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("from thread"+i);
        return "from thread"+i;
    }
}
