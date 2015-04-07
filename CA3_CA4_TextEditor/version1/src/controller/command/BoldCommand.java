package controller.command;
import model.TextEditorModel;

public class BoldCommand implements TextCommand{
    public static final String action = "bold";
    TextEditorModel model;
    int start, length;
    boolean isBold;
    public BoldCommand(TextEditorModel m, int s, int l, boolean isBoldb){
        model = m;
        start = s;
        length = l;
        this.isBold = isBoldb;
    }
    
    public BoldCommand(BoldCommand c)
    {
    	this.model = c.model;
    	this.start = c.start;
    	this.length = c.length;
    	this.isBold = c.isBold;
    }
    
    @Override
    public void execute() {
        model.setBold(start, length, isBold);
    }

    @Override
    public void undo() {
        model.setBold(start, length, !isBold);
    }
    
    @Override
    public void redo() {
        execute();
    }
    
    @Override
    public String toString() {
    	String msg = String.format("BoldCommand: start=%d, length=%d, isBold=%b", start, length, isBold);
    	return msg;
    }
    
    @Override
    public void updateStart(int start)
    {
    	this.start = start;
    }
    
}