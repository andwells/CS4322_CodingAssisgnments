package controller.command;
import model.StyleList;
import model.TextEditorModel;

public class InsertTextCommand implements TextCommand{
    public static final String action = "bold";
    TextEditorModel model;
    int start;
    String t;
    StyleList styles;
    public InsertTextCommand(TextEditorModel m, int s, String text, StyleList insertedStyles){
        model = m;
        start = s;
        t=text;
        styles = insertedStyles;
    }
    
    public InsertTextCommand(InsertTextCommand c)
    {
    	this.model = c.model;
    	this.start = c.start;
    	this.t = c.t;
    	this.styles = c.styles;
    }
    
    @Override
    public void execute() {
    	model.insertTextAt(start, t, styles);
    }

    @Override
    public void undo() {
    	model.removeTextAt(start, t.length());
    }
    
    @Override
    public void redo() {
        execute();
    }
    
    @Override
    public String toString() {
    	String msg = String.format("InsertTextCommand: start=%d, Text=%s", start, t);
    	return msg;
    }
    @Override
    public void updateStart(int start)
    {
    	this.start = start;
    }
}