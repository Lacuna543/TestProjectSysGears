package task1;

import org.json.JSONObject;

public class Main {
    private static final JSONObject SOURCE_DATA = new JSONObject("{\"distance\": {\"unit\": \"m\", \"value\": 0.5}, \"convert_to\": \"ft\"}");

    public static void main(String[] args) {

        Converter converter = new Converter();
        System.out.println(converter.convertUnitsToJSON(SOURCE_DATA));
    }
}
