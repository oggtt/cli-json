package protocol;

import org.json.JSONObject;

public class JsonMessageReceiver {

    private final FlagListener flagListener;

    public JsonMessageReceiver(FlagListener flagListener) {
        this.flagListener = flagListener;
    }

    public void receive(String rawJson) {
        JSONObject json = new JSONObject(rawJson);
        flagListener.onReceive(json);
    }
}
