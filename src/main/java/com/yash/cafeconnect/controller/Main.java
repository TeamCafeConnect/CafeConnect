package com.yash.cafeconnect.controller;

public class Main {
    private int a;

    public Main(int a) {
        this.a = a;
    }

    public Main() {
    }

    public String toString() {
        return "Main{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        Main main=new Main(10);
        System.out.println(main);
    }
}
