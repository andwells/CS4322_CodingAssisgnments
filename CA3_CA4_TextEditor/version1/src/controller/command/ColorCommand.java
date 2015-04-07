package controller.command;

import java.awt.Color;
import model.TextEditorModel;

public class ColorCommand implements TextCommand 
{
	public static final String action = "color";
	TextEditorModel model;
	int start, length;
	Color newColor, prevColor;
	public ColorCommand(TextEditorModel m, int s, int l, Color nc, Color pc)
	{
		model = m;
		start = s;
		length = l;
		newColor = nc;
		prevColor = pc;
	}
	
	public ColorCommand(ColorCommand c)
	{
		this.model = c.model;
		this.start = c.start;
		this.length = c.length;
		this.newColor = c.newColor;
		this.prevColor = c.prevColor;
	}
	
	@Override
	public void execute() 
	{
		model.setColor(start, length, newColor);
	}

	@Override
	public void undo() 
	{
		model.setColor(start, length, prevColor); 
	}

	@Override
	public void redo() 
	{
		execute();
	}
	
	@Override
    public String toString() 
	{
    	return String.format("ColorCommand: start=%d, length=%d, newColor=%s, prevColor=%s", start, length, newColor.getRGB(), prevColor.getRGB());
    }

	@Override
    public void updateStart(int start)
    {
    	this.start = start;
    }
}
