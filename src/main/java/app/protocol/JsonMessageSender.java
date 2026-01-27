package app.protocol;

import org.json.JSONObject;

public class JsonMessageSender {

    private final FlagState flagState;

    public JsonMessageSender(FlagState flagState) {
        this.flagState = flagState;
    }

    public boolean canSend() {
        return flagState.isFlagSet();
    }

    public void send(JSONObject json) {
        if (!canSend()) {
            throw new IllegalStateException("相手が readyFlag を立てるまで送信できません。");
        }

        // 実際の送信処理（ソケットやHTTPなど）
        // sendRaw(json.toString());
    }
}
