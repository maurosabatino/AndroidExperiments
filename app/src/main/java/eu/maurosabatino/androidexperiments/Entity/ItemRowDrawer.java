package eu.maurosabatino.androidexperiments.Entity;

/**
 * Created by Mauro on 08/04/2015.
 */
public class ItemRowDrawer {

        public int iconId;
        public String title;

    public ItemRowDrawer(String title, int iconId) {
        this.title = title;
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
