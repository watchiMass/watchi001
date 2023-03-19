package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *in this package we will write unit tests for each method of the DlinkList class
 * @author Massima Theodore Jeriel
 */
class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    /**
     * this function allows us to test the addfirst method on a list of integers
     * by adding three integers to dLinkList at the top
     */
    @Test
    void addFirstTest() {

        dLinkList.addFirst(25);
        dLinkList.addFirst(26);
        dLinkList.addFirst(27);
        List<Integer> temp1 = new ArrayList<>(List.of(27, 26, 25));

        assertEquals(temp1.toString(), dLinkList.toString());
        System.out.println(dLinkList.toString());
    }

    /**
     *this fonction allows us to test the removeLast on intergers list
     */
    @Test
    void removeFirstTest(){
        DLinkList<Integer> dLinkList = new DLinkList<>();

        //given
        dLinkList.addFirst(25);
        dLinkList.addFirst(26);
        dLinkList.addFirst(27);

        //when
       dLinkList.removeFirst();
        dLinkList.removeFirst();
        List<Integer> temp1 = new ArrayList<>(List.of( 25));

        //then
        assertEquals(temp1.toString(), dLinkList.toString());
        System.out.println(dLinkList.toString());
    }

    /**
     * this function allows us to test the addfirst method
     * on a list of integers by adding three integers to dLinkList at the end
     */
    @Test
    void addLastTest(){
        DLinkList<Integer> dLinkList2 = new DLinkList<>();
        dLinkList2.addLast(1);
        dLinkList2.addLast(2);
        dLinkList2.addLast(3);

        List<Integer> temp2= new ArrayList<>(List.of(1,2,3));

        assertEquals(temp2.toString(), dLinkList2.toString());
        System.out.println(dLinkList2.toString());


    }

    /**
     * this fonction allows us to test the removeLast on intergers list
     */
    @Test
    void removeLastTest(){
        DLinkList<Integer> dLinkList2 = new DLinkList<>();
        dLinkList2.addLast(1);
        dLinkList2.addLast(2);
        dLinkList2.addLast(3);

        dLinkList2.removeLast();
        dLinkList2.removeLast();

        List<Integer> temp2 = new ArrayList<>(List.of(1));

        assertEquals(temp2.toString(), dLinkList2.toString());
        System.out.println(dLinkList2.toString());
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}