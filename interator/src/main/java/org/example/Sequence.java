package org.example;

import java.util.Iterator;

// Tämä on rajapinta (interface)
// Idea: kaikki "lukujonot" voi tarjota iteratorin samalla tavalla
public interface Sequence {

    // Tämä metodi palauttaa iteratorin,
    // jonka avulla voidaan käydä lukujono läpi yksi arvo kerrallaan
    Iterator<Integer> iterator();
}