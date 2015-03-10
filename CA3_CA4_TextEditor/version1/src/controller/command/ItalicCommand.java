package controller.command;
import model.TextEditorModel;

public class ItalicCommand implements TextCommand{
    public static final String action = "italic";
    TextEditorModel model;
    int start, length;
    boolean isItalic;
    public ItalicCommand(TextEditorModel m, int s, int l, boolean isItalicb){
        model = m;
        start = s;
        length = l;
        this.isItalic = isItalicb;
    }
    @Override
    public void execute() {
        model.setItalic(start, length, isItalic);
    }

    @Override
    public void undo() {
        model.setItalic(start, length, !isItalic);
    }
    
    @Override
    public void redo() {
        execute();
    }
    
    @Override
    public String toString() {
    	String msg = String.format("ItalicCommand: start=%d, length=%d, isItalic=%b", start, length, isItalic);
    	return msg;
    }
}