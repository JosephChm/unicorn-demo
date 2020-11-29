package com.unicorn.demo.singlethread;

public class Executor {

    public static void main(String[] args) {
        System.out.println("Testing Gate.!!!!!!");
        Gate gate=new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"chris","Canada").start();
    }

}
