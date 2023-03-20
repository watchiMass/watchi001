package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;


/**
 * this class represent implementation of Queue
 * @param <E>
 * @author Samad OCENI and Nafy Ndiaye G3
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Adds nex element x to the top of the queue
     * @param x
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * Removes an element from the top of the queue
     * @return E element named ele
     */
    @Override
    public E dequeue() {
        if(elems.numOfElem()==0){
            throw new IllegalStateException("The queue is empty");
        }
        E ele = elems.getElement();
        elems.removeFirst();
        return ele;
    }

    /**
     * Return size of the queue
     * @return integer int
     */
    @Override
    public int numOfElems() {
        return elems.numOfElem();
    }

    /**
     * Return the top of the queue without removing it
     * @return E element named ele
     */
    @Override
    public E peek() {
        if(elems.numOfElem()==0){
            throw new IllegalStateException("The queue is empty");
        }
        E ele = elems.getElement();
        return ele;
    }

    /**
     * This method allow us to display all the elements of the queue
     * as a character string
     * @return table of all the elements in our queue
     */
    @Override
    public String toString(){
        return elems.toString();
    }
}
