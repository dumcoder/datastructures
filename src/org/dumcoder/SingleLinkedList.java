package org.dumcoder;


import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T>{
    private int noOfNodes =0;
    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        head = tail = null;
    }

    public void addHead(T data){
        if (data == null){
            return;
        }

        final Node<T> newNode = new Node<T>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        noOfNodes++;
    }

    public Node<T> removeHead(){
        if (head == null){
            return null;
        }
        Node<T> tmpNode = head;
        head = head.getNext();
        noOfNodes--;
        return tmpNode;
    }

    public void addTail(Node<T> node){
        if (node == null){
            return;
        }
        if (tail == null){
            head = tail = node;
        } else {
            tail.getNext().setNext(node);
            tail = tail.getNext();
        }
        noOfNodes++;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                final T data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }
}