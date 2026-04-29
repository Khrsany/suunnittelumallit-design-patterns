package org.example;

import java.util.Iterator;

// Tämä on testiluokka, jossa käytetään meidän Fibonacci-rakennetta
public class Main {

    public static void main(String[] args) {

        // Luodaan FibonacciSequence-olio
        FibonacciSequence sequence = new FibonacciSequence();

        // Pyydetään siltä iterator
        Iterator<Integer> iterator = sequence.iterator();

        System.out.println("Ensimmäiset 10 Fibonacci-lukua:");

        // Tulostetaan 10 ensimmäistä lukua
        for (int i = 0; i < 10; i++) {
            System.out.println(iterator.next());
        }
    }
}
