package org.zerock.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SujebiTest {

    static int compute(int num) {
        if (num <= 1) return num;

        return compute(num - 1) + compute(num - 3);
    }
    public static void main(String args[]) {


        System.out.println("SujebiTest.compute(4) = " + SujebiTest.compute(4));


    }
}
