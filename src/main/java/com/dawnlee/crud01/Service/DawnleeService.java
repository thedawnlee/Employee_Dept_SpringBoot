package com.dawnlee.crud01.Service;

public class DawnleeService {

    public void hello(){

        System.out.println("123");

    }
    public void sayhello(){

        System.out.println("23");


    }
    private void notimetosay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(3);
    }


}
