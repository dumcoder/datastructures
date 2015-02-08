package org.dumcoder;


import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T>{
    private int noOfNodes =0;
    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        head = tail = null;
    }

    public void addHead(Node<T> node){
        if (node == null){
            return;
        }

        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
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

    public boolean hasCycle(){
        boolean hasCycle = true;

        //Brents Cycle detection Algorithm
        Node turtle = head;
        Node bunny = head;
        int steps_taken = 0;
        int step_limit = 2;

        while (true){
            if (bunny == null){
                hasCycle = false;
                break;
            }
            bunny = bunny.getNext();
            ++steps_taken;

            if (bunny == turtle){
                hasCycle = true;
                break;
            }

            if(steps_taken == step_limit){
                steps_taken = 0;
                step_limit *= 2;

                //teleport turtle
                turtle = bunny;
            }
        }
        return hasCycle;

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