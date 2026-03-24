package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private final int box1Color;
    private final int box2Color;
    private final int box3Color;
    private final boolean checkboxSelected;
    private final LocalDateTime savedAt;

    public Memento(int box1Color, int box2Color, int box3Color, boolean checkboxSelected) {
        this.box1Color = box1Color;
        this.box2Color = box2Color;
        this.box3Color = box3Color;
        this.checkboxSelected = checkboxSelected;
        this.savedAt = LocalDateTime.now();
    }

    public int getBox1Color() {
        return box1Color;
    }

    public int getBox2Color() {
        return box2Color;
    }

    public int getBox3Color() {
        return box3Color;
    }

    public boolean isCheckboxSelected() {
        return checkboxSelected;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    @Override
    public String getDisplayText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "Saved: " + savedAt.format(formatter)
                + " | Boxes: [" + box1Color + ", " + box2Color + ", " + box3Color + "]"
                + " | Checkbox: " + checkboxSelected;
    }

    @Override
    public String toString() {
        return getDisplayText();
    }
}