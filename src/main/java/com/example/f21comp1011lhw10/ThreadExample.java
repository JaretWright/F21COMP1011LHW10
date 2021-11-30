package com.example.f21comp1011lhw10;

public class ThreadExample {
    public static void main(String[] args) {
        MyCustomThread myCustomThread = new MyCustomThread();

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("Started: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Ended: "+ Thread.currentThread().getName());
            }
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        Thread thread4 = new Thread(runnable, "Thread 4");
        Thread thread5 = new Thread(runnable, "Thread 5");
        Thread thread6 = new Thread(runnable, "Thread 6");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        myCustomThread.start();
    }
}
