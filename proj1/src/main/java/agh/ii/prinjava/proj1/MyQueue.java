package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 *
 * @param <E>
 */

public interface MyQueue<E> {

    /**
     *
     * @param x
     */
    void enqueue(E x);

    /**
     *
     * @return E
     */
    E dequeue();

    /**
     *
     * @return boolean
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     *
     * @return int
     */
    int numOfElems();

    /**
     *
     * @return E
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    /**
     *
     * @return <T>
     * @param <T>
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
