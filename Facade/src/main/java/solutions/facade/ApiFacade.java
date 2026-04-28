package solutions.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    /*
     * Tämä on facade-luokan tärkein metodi.
     * Asiakas antaa vain URL-osoitteen ja attribuutin nimen.
     * Metodi hakee JSON-datan API:sta ja palauttaa halutun arvon.
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        try {
            // Haetaan JSON-data API:sta
            String json = getJsonFromApi(urlString);

            // Muutetaan JSON-teksti JSONObject-muotoon
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            // Haetaan JSON:sta haluttu attribuutti
            Object value = jsonObject.get(attributeName);

            // Jos attribuuttia ei löydy, heitetään virhe
            if (value == null) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            // Palautetaan arvo String-muodossa
            return value.toString();

        } catch (IOException e) {
            // Jos URL on väärä tai HTTP-pyyntö epäonnistuu
            throw new IOException("HTTP request failed: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Jos attribuuttia ei löydy
            throw e;

        } catch (Exception e) {
            // Jos JSON ei ole oikeassa muodossa tai parsing epäonnistuu
            throw new IllegalArgumentException("Invalid JSON data");
        }
    }

    /*
     * Tämä metodi tekee varsinaisen HTTP GET -pyynnön.
     * Se on private, koska käyttäjän ei tarvitse kutsua tätä itse.
     */
    private String getJsonFromApi(String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Määritellään pyynnön tyypiksi GET
        connection.setRequestMethod("GET");

        // Tarkistetaan HTTP-vastauskoodi
        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            connection.disconnect();
            throw new IOException("HTTP error code: " + responseCode);
        }

        // Luetaan API:n vastaus rivi kerrallaan
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            return result.toString();

        } finally {
            // Suljetaan yhteys lopuksi
            connection.disconnect();
        }
    }
}