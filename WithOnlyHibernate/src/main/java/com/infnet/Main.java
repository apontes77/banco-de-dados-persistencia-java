package com.infnet;

import com.infnet.util.JpaUtil;
import lombok.val;

public class Main {
    private static JpaUtil jpa;
    public static void main(String[] args) {
        System.out.println("Hello world!");

        jpa = new JpaUtil();
        val em = jpa.createEM();
    }
}