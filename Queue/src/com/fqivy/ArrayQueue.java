package com.fqivy;

/**
 * @program: Queue
 * @description:
 * @author: fqivy
 * @create: 2018-07-24 15:52
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取队列元素个数
     *
     * @return 队列元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取队列容量
     *
     * @return 队列容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列为空返回true，队列不为空返回false
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入队
     *
     * @param e 将元素e从队尾加入队列
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     *
     * @return 从队首出队的元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayQueue : front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(" , ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
