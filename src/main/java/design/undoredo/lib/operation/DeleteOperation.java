package design.undoredo.lib.operation;

import design.undoredo.lib.TextAction;

/**
 * Created by adarsh.sharma on 15/03/15.
 */
public class DeleteOperation implements Operation {
    private int position;
    private String removedText;

    public DeleteOperation(int position, String removedText) {
        if (position < 0 || removedText == null || removedText.length() < 1) {
            throw new RuntimeException("incorrect position or length");
        }
        this.position = position;
        this.removedText = removedText;
    }

    @Override
    public void perform(TextAction textAction, String text) {
        if (text == null || text.length() < position + removedText.length()) {
            throw new RuntimeException("incorrect position");
        }
        textAction.removeText(position, removedText.length());
    }

    @Override
    public void undo(TextAction textAction, String text) {
        if (text == null || text.length() < position) {
            throw new RuntimeException("incorrect position");
        }
        textAction.addText(position, removedText);
    }
}
