package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    // 1) Ainoa Logger-olio
    private static Logger instance;

    // 2) Tiedoston kirjoittaja
    private PrintWriter writer;

    // 3) Oletustiedoston nimi
    private String fileName = "log.txt";

    // 4) Private constructor → estää new Logger()
    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error opening log file");
        }
    }

    // 5) Ainoa tapa saada Logger-olio
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // 6) Kirjoittaa viestin lokiin (uusi rivi)
    public void write(String message) {
        writer.println(message);
        writer.flush(); // varmistaa että teksti menee tiedostoon
    }

    // 7) Vaihda lokitiedosto
    public void setFileName(String fileName) {
        this.fileName = fileName;
        try {
            writer.close();
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error changing log file");
        }
    }

    // 8) Sulje tiedosto
    public void close() {
        writer.close();
    }
}
