package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Include extends Condition {
    public Include(JSONArray conditionValue) {
        super(conditionValue);
    }

    String getName() {return "include";}

    public ArrayList<JSONObject> action(ArrayList<JSONObject> jsonArray) {
        ArrayList<JSONObject> newArrayListOfJSONObjects = new ArrayList<>();

        for (int i = 0; i < conditionValue.length(); i++) {
            String key = conditionValue.getJSONObject(i).keySet().iterator().next();
            Object value = conditionValue.getJSONObject(i).get(key);
            for (JSONObject jsonObject : jsonArray) {
                if (jsonObject.get(key).equals((value))) {
                    newArrayListOfJSONObjects.add(jsonObject);
                }
            }

        }
        return newArrayListOfJSONObjects;
    }
}
