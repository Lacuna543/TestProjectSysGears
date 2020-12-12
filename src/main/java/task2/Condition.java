package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public abstract class Condition {
    abstract String getName();

    protected JSONArray conditionValue;

    public Condition(JSONArray conditionValue) {
        this.conditionValue = conditionValue;
    }

    abstract  ArrayList<JSONObject> action(ArrayList<JSONObject> data);

}
