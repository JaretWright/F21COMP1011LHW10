package com.example.f21comp1011lhw10;

public class MyCustomThread extends Thread{
    public void run(){
        this.setName("MyCustomThread");

        System.out.println("Started: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended: "+ Thread.currentThread().getName());
    }
}
