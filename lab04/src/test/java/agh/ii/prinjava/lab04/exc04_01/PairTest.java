package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1() {
        int fst = 25;
        String snd = "massima";

        int fst1 = 21;
        String snd1 = "mass";

        Pair<Integer,String> pairOfIntStr = new Pair<>(25,"massima");

        assertEquals(fst, pairOfIntStr.getFst());
        assertEquals(snd, pairOfIntStr.getSnd());

       // assertEquals(fst1, pairOfIntStr.getFst());
        //assertEquals(snd1, pairOfIntStr.getFst());
    }
    @Test
    void test2() {
        Pair<Integer,String> pairOfIntStr = new Pair<>(25,"massima");

        Pair<Integer,String> pairOfIntStr1 = new Pair<>(25,"massima");


        assertEquals(true,pairOfIntStr.equals(pairOfIntStr1));
        assertEquals(pairOfIntStr1.hashCode(),pairOfIntStr.hashCode());


        //assertEquals(false,pairOfIntStr.equals(pairOfIntStr1));
    }
    @Test
    void test3(){
        Pair<String, Integer> pair1 = new Pair<>("Hello", 123);
        try {
            Pair  pair2 = (Pair) pair1.clone();
            pair2.setFst("Hello");
            pair2.setSnd(123);

            assertEquals(pair1,pair2);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


}