package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    private static final JSONObject SOURCE_DATA = new JSONObject("{\"data\": [{\"name\": \"Jane\", \"email\": \"bohn2@mail.com\"}," +
            "\n{\"name\": \"Abr\", \"email\": \"cohn1@mail.com\"},\n{\"name\": \"Jane\", \"email\": \"ane@mail.com\"}]}");

    private static final JSONObject CONDITION = new JSONObject("{\"condition\": {\"include\": [{\"name\": \"Jane\"}], \"sort_by\": [\"email\"]}}");

    public static final String RESULT = "result";

    static ArrayList<JSONObject> j = listProcessing(convertFromJSONArrayToArrayList(SOURCE_DATA), convertConditions(CONDITION));
    public static void main(String[] args) {
        System.out.println(convertToJSONObject(j));
    }

    public static JSONObject convertToJSONObject(ArrayList<JSONObject> input){
        JSONArray jsonArray = new JSONArray(input);
        JSONObject result = new JSONObject();
       return result.put(RESULT, jsonArray);

    }
    public static ArrayList<Condition> convertConditions(JSONObject conditions) {
        ArrayList<Condition> tempArrayList = new ArrayList<>();
        JSONObject condition = conditions.getJSONObject("condition");
        for (Iterator<String> it = condition.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            JSONArray conditionValue = condition.getJSONArray(key);
            switch (key) {
                case "include":
                    tempArrayList.add(new Include(conditionValue));
                    break;
                case "exclude":
                    tempArrayList.add(new Exclude(conditionValue));
                    break;
                case "sort_by":
                    tempArrayList.add(new SortBy(conditionValue));
                    break;
            }

        }
        return tempArrayList;
    }

    public static ArrayList<JSONObject> listProcessing(ArrayList<JSONObject> data, ArrayList<Condition> conditions) { //applying the condition to list
        for (Condition condition : conditions) {
            data = condition.action(data);
        }
        return data;
    }


    public static ArrayList<JSONObject> convertFromJSONArrayToArrayList(JSONObject jsonObject) {
        ArrayList<JSONObject> listOfJSONObjects = new ArrayList<>();

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                listOfJSONObjects.add((JSONObject) jsonArray.get(i));
            }
        }
        return listOfJSONObjects;
    }
}

