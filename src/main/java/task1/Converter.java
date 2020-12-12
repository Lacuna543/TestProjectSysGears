package task1;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Converter {
    public static final String DISTANCE = "distance";
    public static final String UNIT = "unit";
    public static final String VALUE = "value";
    public static final String CONVERT_TO = "convert_to";

    public JSONObject convertUnitsToJSON(JSONObject sourceData) {
        try {


            JSONObject distance = sourceData.getJSONObject(DISTANCE);
            String convertFrom = distance.getString(UNIT);
            Double value = distance.getDouble(VALUE);
            String convertTo = sourceData.getString(CONVERT_TO);


            Double result = new Converter().convertUnits(convertFrom, value, convertTo);

            BigDecimal bigDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);

            return new JSONObject().put(UNIT, convertTo).put(VALUE, bigDecimal.doubleValue());
        } catch (JSONException e) {
            throw new JSONException("Check your input data");
        }
    }

    Map<String, Double> map = new HashMap<String, Double>() {{
        put("m", 1.0);
        put("cm", 0.01);
        put("in", 0.0254);
        put("ft", 0.3048);
    }};

    public Double convertUnits(String convertFrom, Double value, String convertTo) {
        Double coefficientFrom = map.get(convertFrom);
        Double coefficientTo = map.get(convertTo);
        if (coefficientFrom == null || coefficientTo == null) {
            throw new NullPointerException();
        }
        if (coefficientTo == 1.0) {
            return value * coefficientFrom * coefficientTo;
        } else {
            return value * coefficientFrom / coefficientTo;
        }
    }

}