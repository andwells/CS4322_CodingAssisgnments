package controller.command;

import java.awt.Color;

import javax.jws.WebParam.Mode;

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

}