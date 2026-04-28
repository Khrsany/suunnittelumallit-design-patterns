package solutions;

import solutions.facade.ApiFacade;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ApiFacade facade = new ApiFacade();

        /*
         * Esimerkki 1:
         * Haetaan satunnainen Chuck Norris -vitsi.
         * JSON:ssa vitsi löytyy attribuutista "value".
         */
        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println("Chuck Norris joke:");
            System.out.println(joke);

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error while getting joke: " + e.getMessage());
        }

        System.out.println();

        /*
         * Esimerkki 2:
         * Käytetään toista API:a.
         * Tässä haetaan valuuttakurssi-API:sta base-attribuutti.
         */
        try {
            String baseCurrency = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );

            System.out.println("Base currency:");
            System.out.println(baseCurrency);

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error while getting currency data: " + e.getMessage());
        }

        System.out.println();

        /*
         * Esimerkki 3:
         * Testataan virhetilanne, jossa attribuuttia ei ole olemassa.
         * Tämän pitäisi aiheuttaa IllegalArgumentException.
         */
        try {
            String wrongAttribute = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "notExistingAttribute"
            );

            System.out.println(wrongAttribute);

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Expected error:");
            System.out.println(e.getMessage());
        }
    }
}