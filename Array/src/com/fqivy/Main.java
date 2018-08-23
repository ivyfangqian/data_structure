package com.fqivy;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println(arr.contains(1));
        System.out.println(arr.contains(99));
        System.out.println(arr.find(-1));
        System.out.println(arr.find(99));


        arr.set(0, -5);
        System.out.println(arr.get(10));

        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);


    }
}
