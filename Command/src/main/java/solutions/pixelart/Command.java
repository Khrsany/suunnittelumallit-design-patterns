package solutions.pixelart;

/*
 * Tämä on Command Patternin yhteinen rajapinta.
 * Kaikki komennot toteuttavat tämän saman execute()-metodin.
 */
public interface Command {
    void execute();
}