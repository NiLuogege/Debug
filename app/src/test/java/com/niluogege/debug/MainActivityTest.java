package com.niluogege.debug;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void printInt() {
        assertEquals(MainActivity.printInt(),3);
    }
}