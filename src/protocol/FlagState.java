package protocol;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagState {
    private final AtomicBoolean flag = new AtomicBoolean(false);

    public void setFlag(boolean value) {
        flag.set(value);
    }

    public boolean isFlagSet() {
        return flag.get();
    }
}
