package controller.command;
import model.TextEditorModel;

public class UnderlineCommand implements TextCommand{
    public static final String action = "underline";
    TextEditorModel model;
    int start, length;
    boolean isUnderline;
    public UnderlineCommand(TextEditorModel m, int s, int l, boolean isUnderlineb){
        model = m;
        start = s;
        length = l;
        this.isUnderline = isUnderlineb;
    }
    @Override
    public void execute() {
        model.setUnderline(start, length, isUnderline);
    }

    @Override
    public void undo() {
        model.setUnderline(start, length, !isUnderline);
    }
    
    @Override
    public void redo() {
        execute();
    }
    
    @Override
    public String toString() {
    	String msg = String.format("UnderlineCommand: start=%d, length=%d, isUnderline=%b", start, length, isUnderline);
    	return msg;
    }
}