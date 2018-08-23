package com.fqivy;

/**
 * @program: Stack
 * @description:
 * @author: fqivy
 * @create: 2018-07-24 13:54
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取栈实际元素个数
     *
     * @return 栈的实际元素数量
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 判断栈是否为空
     *
     * @return 为空返回true，不为空返回false
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈容量
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayStack : [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(" , ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

