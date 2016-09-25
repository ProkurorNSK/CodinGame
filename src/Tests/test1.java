package Tests;


import java.util.concurrent.*;

public class test1 {
    public static void main(String[] args) {
//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        };
//
//        task.run();
//
//        Thread thread = new Thread(task);
//        thread.start();
//
//        System.out.println("Done!");
//
//*******************************************
//        Runnable runnable = () -> {
//            try {
//                String name = Thread.currentThread().getName();
//                System.out.println("Foo " + name);
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Bar " + name);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//        thread = new Thread(runnable);
//        thread.start();
// *******************************************

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        });
//
//        try {
//            System.out.println("attempt to shutdown executor");
//            executor.shutdown();
//            executor.awaitTermination(5, TimeUnit.SECONDS);
//        }
//        catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        }
//        finally {
//            if (!executor.isTerminated()) {
//                System.err.println("cancel non-finished tasks");
//            }
//            executor.shutdownNow();
//            System.out.println("shutdown finished");
//        }

//*******************************************

        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };


        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        try {
            Integer result = future.get();
            System.out.println("future done? " + future.isDone());
            System.out.print("result: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
