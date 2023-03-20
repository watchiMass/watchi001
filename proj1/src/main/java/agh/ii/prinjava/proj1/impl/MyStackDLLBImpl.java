package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 *this class represent implementation of Stack
 * @param <E>
 * @author Samad OCENI G3
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Removes an element from the top of the Stack
     * @return  E element named ele
     */
    @Override
    public E pop() {
        if(elems.numOfElem()==0){
            throw new IllegalStateException("Stack is empty");
        }
        E ele = elems.getElement();
        elems.removeFirst();
        return ele;
    }

    /**
     * Adds nex element x to the top of the stack
     * @param x
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Return size of the stack
     * @return integer int
     */
    @Override
    public int numOfElems() {
        return elems.numOfElem();
    }

    /**
     * Return the top of the stack without removing it
     * @return E element named ele
     */
    @Override
    public E peek() {
        if(elems.numOfElem()==0){
            throw new IllegalStateException("Stack is empty");
        }
        E ele = elems.getElement();
        return ele;
    }


    /**
     * This method allow us to display all the elements of the stack
     * as a character string
     * @return table of all the elements in our stack
     */
    @Override
    public String toString(){
        return elems.toString();
    }
}
