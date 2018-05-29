package design.undoredo.lib.operation;

import design.undoredo.lib.TextAction;

/**
 * Created by adarsh.sharma on 14/03/15.
 */
public class AddOperation implements Operation {
    private int position;
    private String textToAdd;

    public AddOperation(int position, String textToAdd) {
        if (textToAdd == null || position < 0) {
            throw new RuntimeException("invalid values to create undoRedo.operation");
        }
        this.position = position;
        this.textToAdd = textToAdd;
    }

    @Override
    public void perform(TextAction textAction, String text) {
        if (text == null || text.length() < position) {
            throw new RuntimeException("incorrect position");
        }
        textAction.addText(position, textToAdd);
    }

    @Override
    public void undo(TextAction textAction, String text) {
        if (text == null || text.length() < (position + textToAdd.length())) {
            throw new RuntimeException("incorrect position");
        }
        textAction.removeText(position, textToAdd.length());
    }
}
