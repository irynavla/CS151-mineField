package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    public boolean unsavedChanges = false;
    public String fileName = null;

    public abstract void update();

    void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }
}
