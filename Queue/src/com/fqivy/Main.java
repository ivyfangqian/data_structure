package com.fqivy;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String res = "1223G345";
        Pattern p = Pattern.compile("[0-9]+G[0-9]+");
        Matcher m = p.matcher(res);
        System.out.println(m.find());
        System.out.println(m.group());

        int opCount = 100000;
        Queue<Integer> queue1 = new ArrayQueue<>();
        Queue<Integer> queue2 = new LoopQueue<>();

        System.out.println(testQueue(queue1, opCount));
        System.out.println(testQueue(queue2, opCount));
    }

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.00;
    }
}
