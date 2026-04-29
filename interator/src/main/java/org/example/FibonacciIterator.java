package org.example;

import java.util.Iterator;

// Tämä luokka tekee varsinaisen työn:
// se laskee Fibonacci-luvut yksi kerrallaan
public class FibonacciIterator implements Iterator<Integer> {

    // Tallennetaan kaksi viimeisintä arvoa
    private int previous = 0;
    private int current = 1;

    @Override
    public boolean hasNext() {
        // Fibonacci voi jatkua loputtomiin,
        // joten palautetaan aina true
        return true;
    }

    @Override
    public Integer next() {

        // Palautetaan nykyinen arvo
        int nextNumber = current;

        // Lasketaan seuraava Fibonacci-luku
        int newCurrent = previous + current;

        // Päivitetään arvot seuraavaa kierrosta varten
        previous = current;
        current = newCurrent;

        return nextNumber;
    }
}