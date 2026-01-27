package app.protocol;

import org.json.JSONObject;

public class FlagListener {

    private final FlagState flagState;

    public FlagListener(FlagState flagState) {
        this.flagState = flagState;
    }

    public void onReceive(JSONObject json) {
        if (json.optBoolean("readyFlag", false)) {
            flagState.setFlag(true);
        }
    }
}
