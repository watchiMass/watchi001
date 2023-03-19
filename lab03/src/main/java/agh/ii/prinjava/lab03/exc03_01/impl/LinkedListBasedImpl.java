package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class LinkedListBasedImpl implements QueueOfInts {

    @Override
    public void enqueue(int x) {
        throw new IndexOutOfBoundsException("full list");
    }

    @Override
    public int dequeue() {
        throw new NoSuchElementException( "empty list");
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        throw new NoSuchElementException( "empty list");
    }

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
