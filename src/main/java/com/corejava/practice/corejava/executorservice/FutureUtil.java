package com.corejava.practice.corejava.executorservice;

import java.util.concurrent.*;

public class FutureUtil {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Implementation to submit a callable task which will return the object which is stored in future object
        Future<String> future = executorService.submit(new SampleCallable());
        //Do some other processing if above is long process. It will run parallel.
        //Below is blocking operation thread will process this method then only moves to next line.
        System.out.println(future.get());

        //To complete the process without this java process will keep on running.
        executorService.shutdown();


        //Second way of implementation is to create future task and submit them.
        FutureTask<String> futureTask = new FutureTask<>(new SampleCallable());
        executorService.submit(futureTask);
        System.out.println("task completion status is "+futureTask.isDone() + " and value is "+futureTask.get());
    }
}

class SampleCallable implements Callable{

    @Override
    public String call() throws Exception {
        return "Task executed in callable";
    }
}
