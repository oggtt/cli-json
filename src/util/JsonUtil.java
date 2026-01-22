package util;

import org.json.JSONObject;

public class JsonUtil {

    public static JSONObject createFlagMessage() {
        JSONObject json = new JSONObject();
        json.put("readyFlag", true);
        return json;
    }
}
