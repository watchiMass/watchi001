package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * in this package we will write unit tests for each method of the Queue
 * @author Samad OCENI  and Nafy Ndiaye G3
 */
class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    /**
     * this function allows us to test the enqueue method on a queue of integers
     * by adding gradually three integers to queueOfInts  at the top
     */
    @Test
    void enqueue() {

        queueOfInts.enqueue(5);
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(15);
        List<Integer> temp1 = new ArrayList<>(List.of(5,9,15 ));

        assertEquals(temp1.toString(), queueOfInts.toString());
    }

    /**
     * this function allows us to test the dequeue method on a queue of integers
     * after adding three integers then we remove the integer which is to the top of queue
     */
    @Test
    void dequeue() {

        queueOfInts.enqueue(5);
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(15);

        assertEquals(5, queueOfInts.dequeue());
        System.out.println(queueOfInts.toString());
    }


    /**
     * this function allows us to test the numOfElems method on a queue of integers
     * after adding four integers and  then removing two ,this method count  number od elements  in the queue
     */
    @Test
    void numOfElems() {

        queueOfInts.enqueue(5);
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(15);
        queueOfInts.enqueue(29);

        queueOfInts.dequeue();
        queueOfInts.dequeue();

        assertEquals(2, queueOfInts.numOfElems());

    }

    /**
     * this function allows us to test the peek method on a queue of integers
     * after adding four elements and  then removing one , this method return
     *  the top of the queue without removing it
     */
    @Test
    void peek() {

        queueOfInts.enqueue(5);
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(15);
        queueOfInts.enqueue(29);

        queueOfInts.dequeue();

        assertEquals(9, queueOfInts.peek());

        System.out.println(queueOfInts.toString());

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}