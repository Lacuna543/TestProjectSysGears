package task2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JSONComparator implements Comparator<JSONObject> {
    JSONArray condition;

    public JSONComparator(JSONArray condition) {
        this.condition = condition;
    }



        public int compare (JSONObject jsonObject, JSONObject jsonObject1){

                if( jsonObject.get(condition.getString(0)) instanceof Comparable && jsonObject1.get(condition.getString(0)) instanceof Comparable){
                    return ((Comparable)jsonObject.get(condition.getString(0))).compareTo(jsonObject1.get(condition.getString(0)));
                }else {
                    throw new JSONException("Wrong type.");
                }
       /* String v1 = (String) ((JSONObject) jsonObject.get("data")).get("name");
        String v2 = (String) ((JSONObject) t1.get("data")).get("email");
        //  JSONArray o2 = jsonObject.getJSONArray("email");
        return v1.compareTo(v2);*/

    }


}
