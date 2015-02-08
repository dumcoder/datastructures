package org.dumcoder;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> integerSll = new SingleLinkedList<Integer>();
        integerSll.addHead(new Node<Integer>(1));
        integerSll.addHead(new Node<Integer>(2));
        integerSll.addHead(new Node<Integer>(3));
        integerSll.addHead(new Node<Integer>(4));

        Node<Integer> node5 = new Node<Integer>(5);
        integerSll.addHead(node5);

        integerSll.addHead(new Node<Integer>(6));
        integerSll.addHead(new Node<Integer>(7));
        Node<Integer> node8 = new Node<Integer>(8);
        integerSll.addHead(node8);

        node8.setNext(node5);

        System.out.printf("Has cycle:" + integerSll.hasCycle());

/*        for (Integer data : integerSll) {
            System.out.println(data + "->");
        }*/
    }
}