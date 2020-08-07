package com.moguteam.lib_java;


import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;

public class MainClass {

    static Integer i = 1;
    static Boolean b = false;

    public static void main(String[] args) {
        printLayout(i);
        printLayout(b);

    }

    private static void printLayout(Object o) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
