package memento.guistate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private final Model model;
    private Gui gui;

    private final List<IMemento> undoList;
    private final List<IMemento> redoList;
    private final List<IMemento> historyList;

    public Controller(Model model) {
        this.model = model;
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
        this.historyList = new ArrayList<>();
    }

    public void setGui(Gui gui) {
        this.gui = gui;
        saveInitialState();
    }

    private void saveInitialState() {
        IMemento initialState = model.createMemento();
        historyList.add(initialState);
        updateView();
    }

    public void changeBoxColor(int boxNumber) {
        saveStateForUndo();

        switch (boxNumber) {
            case 1 -> model.setBox1Color((model.getBox1Color() + 1) % 3);
            case 2 -> model.setBox2Color((model.getBox2Color() + 1) % 3);
            case 3 -> model.setBox3Color((model.getBox3Color() + 1) % 3);
            default -> {
                return;
            }
        }

        afterNewChange();
    }

    public void changeCheckbox(boolean selected) {
        saveStateForUndo();
        model.setCheckboxSelected(selected);
        afterNewChange();
    }

    private void saveStateForUndo() {
        undoList.add(model.createMemento());
    }

    private void afterNewChange() {
        redoList.clear();
        historyList.add(model.createMemento());
        updateView();
    }

    public void undo() {
        if (undoList.isEmpty()) {
            return;
        }

        redoList.add(model.createMemento());

        IMemento previousState = undoList.remove(undoList.size() - 1);
        model.restoreState(previousState);
        updateView();
    }

    public void redo() {
        if (redoList.isEmpty()) {
            return;
        }

        undoList.add(model.createMemento());

        IMemento redoneState = redoList.remove(redoList.size() - 1);
        model.restoreState(redoneState);
        updateView();
    }

    public List<IMemento> getHistory() {
        return Collections.unmodifiableList(historyList);
    }

    public void restoreFromHistory(IMemento memento) {
        saveStateForUndo();
        redoList.clear();
        model.restoreState(memento);
        historyList.add(model.createMemento());
        updateView();
    }

    public void openHistoryWindow() {
        new HistoryWindow(this);
    }

    public void updateView() {
        if (gui == null) {
            return;
        }

        gui.updateFromModel(
                model.getBox1Color(),
                model.getBox2Color(),
                model.getBox3Color(),
                model.isCheckboxSelected()
        );
    }
}