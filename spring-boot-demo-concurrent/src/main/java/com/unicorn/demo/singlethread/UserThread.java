package com.unicorn.demo.singlethread;

public class UserThread extends Thread{

    private final Gate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(Gate gate,String name,String myAddress){
        this.gate=gate;
        this.myName=name;
        this.myAddress=myAddress;
    }

    public void run(){
        System.out.println(myName+"Begin");
        for (int i = 0; i < 100; i++) {
            gate.pass(myName,myAddress);
        }
    }

}
