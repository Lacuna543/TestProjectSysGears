package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Exclude extends Condition {
    public Exclude(JSONArray conditionValue) {
        super(conditionValue);
    }

    String getName() {
        return "exclude";
    }

    public ArrayList<JSONObject> action(ArrayList<JSONObject> jsonArray) {
        for (int i = 0; i < conditionValue.length(); i++) {
            String key = conditionValue.getJSONObject(i).keySet().iterator().next();
            Object value = conditionValue.getJSONObject(i).get(key);
            for (JSONObject jsonObject : jsonArray) {
                if (jsonObject.get(key).equals(value)) {
                    jsonArray.remove(jsonObject);
                }
            }

        }
        return jsonArray;
    }
}
