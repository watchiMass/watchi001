package agh.ii.prinjava.proj1.impl;

import java.util.NoSuchElementException;

/**
 *This class represent a dynamic list (doubly linked list)
 * @param <E>
 **@author Massima Thedojeriel G3
 */
public class DLinkList<E> {


    private Node<E> head;
    private Node<E> last;
    public DLinkList() {}

    /**
     * This nested class allows us to create first links of our list
     * @param <T>
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * this is the one-parameter constructor of Nodes
         * @param t
         */
        public Node(T t){
            this.elem = t;
        }

        /**
         * this is the default Node constructor
         */
        public Node(){

        }
    }
    private  Node<E> list ;


    /**
     * This method allows us to add an element at the top of the list
     * @param e
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
          head = newNode ;
          last = newNode ;
        }
        else{
            newNode.next= head;
            head.prev= newNode;
            head = newNode;
        }
    }

    /**
     * this method allows us to add an element at the end of the list
     * @param e
     */
    public void  addLast(E e){

           Node newNode = new Node<E>(e);
           if(last==null){
              head= newNode;
              last= newNode;
           }
           else{
               newNode.prev=last;
               last.next= newNode;
               last= newNode;
           }

    }

    /**
     * This method allows us to delete an element at the top of the list
     */
    public void removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        else{
            Node<E> temp = new Node();
            temp= head;
            head = temp.next;
            if(head != null) {
                head.prev = null;
            }
        }
    }

    /**
     * this method allows us to delete an element at the end of the list
     */
    public void removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        } else if (last.prev == null) {
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
    }

    /**
     * This method allow us to display all the elements of the list
     * as a charactere string
     * @return table of all the elements in our list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> newNode = head;
        while (newNode != null) {
            sb.append(newNode.elem.toString());
            if (newNode.next != null) {
                sb.append(", ");
            }
            newNode = newNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}



