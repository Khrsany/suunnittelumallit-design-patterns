package memento.guistate;

public class Model {
    private int box1Color;
    private int box2Color;
    private int box3Color;
    private boolean checkboxSelected;

    public Model() {
        this.box1Color = 0;
        this.box2Color = 0;
        this.box3Color = 0;
        this.checkboxSelected = false;
    }

    public IMemento createMemento() {
        return new Memento(box1Color, box2Color, box3Color, checkboxSelected);
    }

    public void restoreState(IMemento memento) {
        Memento state = (Memento) memento;
        this.box1Color = state.getBox1Color();
        this.box2Color = state.getBox2Color();
        this.box3Color = state.getBox3Color();
        this.checkboxSelected = state.isCheckboxSelected();
    }

    public int getBox1Color() {
        return box1Color;
    }

    public void setBox1Color(int box1Color) {
        this.box1Color = box1Color;
    }

    public int getBox2Color() {
        return box2Color;
    }

    public void setBox2Color(int box2Color) {
        this.box2Color = box2Color;
    }

    public int getBox3Color() {
        return box3Color;
    }

    public void setBox3Color(int box3Color) {
        this.box3Color = box3Color;
    }

    public boolean isCheckboxSelected() {
        return checkboxSelected;
    }

    public void setCheckboxSelected(boolean checkboxSelected) {
        this.checkboxSelected = checkboxSelected;
    }
}