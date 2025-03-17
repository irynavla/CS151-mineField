package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    public boolean unsavedChanges = false;
    public String fileName = null;

    public abstract void update();
    public void unsubscribe(AppPanel appPanel) {
    }

    public void subscribe(AppPanel appPanel) {
    }

    protected void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }
    public void setFileName(String fName) {
    }
    public String getFileName() {
        return null;
    }
    public boolean getUnsavedChanges() {
        return false;
    }
    public void setUnsavedChanges(boolean b) {
    }
}
