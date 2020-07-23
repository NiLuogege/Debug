package com.moguteam.lib_java;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClass {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 4; i++) {
            service.execute(() -> addData("data "+ Thread.currentThread().getName()));
        }
        printData();
    }

    static ArrayList<String> datas = new ArrayList<>();

    private static synchronized void addData(String data){
        datas.add(data);
    }

    private static void printData(){
        synchronized (datas){
            for (String data : datas) {
                System.out.println(data);
            }

        }
    }
}
