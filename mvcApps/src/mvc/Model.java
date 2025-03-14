package mvc;

public abstract class Model extends Publisher {
    public abstract void update();

    public boolean getUnsavedChanges() {
        return false;
    }

    public String getFileName() {
        return null;
    }

    public void setFileName(String fName) {
    }

    public void setUnsavedChanges(boolean b) {
    }

    public void unsubscribe(AppPanel appPanel) {
    }

    public void subscribe(AppPanel appPanel) {
    }

    public void changed() {
    }
}
