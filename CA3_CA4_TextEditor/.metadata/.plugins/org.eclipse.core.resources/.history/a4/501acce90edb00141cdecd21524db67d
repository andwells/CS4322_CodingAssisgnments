package controller.command;
import model.StyleList;
import model.TextEditorModel;

public class RemoveTextCommand implements TextCommand{
    public static final String action = "bold";
    TextEditorModel model;
    int start;
    String oldText;
    StyleList oldStyles;
    public RemoveTextCommand(TextEditorModel m, int s, String text, StyleList removedStyles)
    {
        model = m;
        start = s;
        oldText=text;
        oldStyles = removedStyles;
    }
    @Override
    public void execute() {
    	model.removeTextAt(start, oldText.length());
    }

    @Override
    public void undo() {
    	model.insertTextAt(start, oldText, oldStyles);

    }
    
    @Override
    public void redo() {
        execute();
    }
    
    @Override
    public String toString() {
    	String msg = String.format("RemoveTextCommand: start=%d, Text=%s", start, oldText);
    	return msg;
    }
}