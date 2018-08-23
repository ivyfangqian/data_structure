package com.fqivy;

/**
 * @program: LinkedList
 * @description: 链表
 * @author: fqivy
 * @create: 2018-07-30 12:48
 */
public class LinkedList<E> {
    /**
     * 链表的结点Node
     *
     * @param
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    //    private Node head;
    private Node dummyHead;
    private int size;

    /**
     * 构造方法，生成一个链表对象
     */
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表结点数
     *
     * @return 结点数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 为空返回true，不为空返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

//    /**
//     * 向链表头部添加结点
//     * 无虚拟头结点的方式
//     *
//     * @param e
//     */
//    public void addFirst(E e) {
////        Node newHead = new Node(e);
////        newHead.next = head;
////        head = newHead;
//
//        head = new Node(e, head);
//        size++;
//    }

//    /**
//     * 向链表中间插入元素，不常用，O(n),这仅仅作为练习
//     * 注意：这里是不适用虚拟头结点的添加方式
//     *
//     * @param index 索引
//     * @param e     插入元素
//     */
//    public void add(int index, E e) {
//        if (index < 0 || index >= size) {
//            throw new IllegalArgumentException("Add failed! Index is illegal!");
//        }
//        if (index == 0) {
//            addFirst(e);
//        } else {
//            Node prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
////            Node newNode = new Node(e, prev.next);
////            prev.next = newNode;
//            prev.next = new Node(e, prev.next);
//            size++;
//        }
//
//    }

    /**
     * 向链表中添加结点，包含虚拟头结点
     *
     * @param index 添加的索引位置
     * @param e     插入的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Index is illegal!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头添加结点
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向链表尾部添加结点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取索引为index的链表的值
     *
     * @param index 索引
     * @return 索引对应的元素值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed! Illegal index!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表头结点
     *
     * @return 链表头结点
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后的结点
     *
     * @return 最后的结点
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新索引处结点的值
     *
     * @param index 索引
     * @param e     更新后的值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed! Index illegal!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 移除索引处的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed! Index illegal!");
        }
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed! LinkedList is empty!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    /**
     * 删除链表头结点
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表尾部结点
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e);
            res.append("-->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.removeFirst();
        System.out.println(linkedList);

        System.out.println(linkedList.contains(4));
    }

}


