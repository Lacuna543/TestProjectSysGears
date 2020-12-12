package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class SortBy extends Condition{

    public SortBy(JSONArray conditionValue) {
        super(conditionValue);
    }

    public String getName() {
        return "sort_by";
    }

    public ArrayList<JSONObject> action(ArrayList<JSONObject> jsonArray) {
       Collections.sort(jsonArray, new JSONComparator(conditionValue));

        return jsonArray;
    }
}
