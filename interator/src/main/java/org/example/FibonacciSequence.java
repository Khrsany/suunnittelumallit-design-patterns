package org.example;

import java.util.Iterator;

// Tämä luokka edustaa Fibonacci-lukujonoa
// Se EI itse laske lukuja, vaan antaa iteratorin joka tekee sen
public class FibonacciSequence implements Sequence {

    @Override
    public Iterator<Integer> iterator() {

        // Palautetaan uusi iterator joka laskee Fibonacci-luvut
        // Jokainen iterator on oma "instanssi", eli toimii itsenäisesti
        return new FibonacciIterator();
    }
}