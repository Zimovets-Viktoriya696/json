import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by vika on 18.05.17.
 */
public class Json {
   private static String url = "http://ip-api.com/json/";

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();
        return response.toString();
    }

    private static void perseUrl(String resultJson){
        try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject countryJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            // получаем название города
            System.out.println("Название города: " + countryJsonObject.get("city"));
            System.out.println("Название страны: " + countryJsonObject.get("city"));

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String content = Json.getText(url);
        perseUrl(content);
    }
}
