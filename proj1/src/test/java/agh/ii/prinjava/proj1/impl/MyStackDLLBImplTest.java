package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * in this package we will write unit tests for each method of the Stack
 * @author Samad OCENI G3
 */
class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = new MyStackDLLBImpl<>() ;

    /**
     * this function allows us to test the push method on a stack of integers
     * by adding gradually three integers to stackOfInts  at the top
     */
    @Test
    void push() {

        stackOfInts.push(5);
        stackOfInts.push(9);
        stackOfInts.push(15);
        List<Integer> temp1 = new ArrayList<>(List.of(15,9 ,5 ));

        assertEquals(temp1.toString(), stackOfInts.toString());
    }

    /**
     * this function allows us to test the pop method on a stack of integers
     * after adding three integers then we remove the integer which is to the top of stack
     */
    @Test
    void pop() {

        stackOfInts.push(5);
        stackOfInts.push(9);
        stackOfInts.push(15);

        assertEquals(15, stackOfInts.pop());
        System.out.println(stackOfInts.toString());
    }


    /**
     * this function allows us to test the numOfElems method on a stack of integers
     * after adding four integers and  then removing two ,this method count element in the stack
     */
    @Test
    void numOfElems() {

        stackOfInts.push(5);
        stackOfInts.push(9);
        stackOfInts.push(15);
        stackOfInts.push(29);

        stackOfInts.pop();
        stackOfInts.pop();

        assertEquals(2, stackOfInts.numOfElems());

    }

    /**
     * this function allows us to test the peek method on a stack of integers
     * after adding four elements and  then removing one , this method return
     *  the top of the stack without removing it
     */
    @Test
    void peek() {

        stackOfInts.push(5);
        stackOfInts.push(9);
        stackOfInts.push(15);
        stackOfInts.push(29);

        stackOfInts.pop();

        assertEquals(15, stackOfInts.peek());

        System.out.println(stackOfInts.toString());

    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}