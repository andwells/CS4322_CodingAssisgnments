package controller;

import view.TextEditorPanel;

import model.TextEditorModel;
import model.LengthStyle;
import model.StyleList;
import model.StylePrinter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import controller.command.*;

public class TextEditorController
{
	private boolean isRecording = false;
	private boolean isOvertype = false;
	private Macro recordedCommands;
	private TextEditorView view;
	
	private TextEditorModel model;
	
	private TextCommandInvoker invoker = new TextCommandInvoker();
	
	public TextEditorController(TextEditorModel modelRef)
	{
		setView(null);
		setModel(modelRef);
	}
	public void setView(TextEditorView viewRef)
	{
		view = viewRef;
	}
	private void setModel(TextEditorModel modelRef)
	{
		model = modelRef;
	}
	
	public void setBold(int start, int length, boolean boldOn)
	{
		BoldCommand c = new BoldCommand(model, start, length, boldOn);
		if(isRecording)
		{
			recordedCommands.addStep(new BoldCommand(c));
		}
		invoker.doCommand(c);
		view.setUndoEnabled(true);
		view.setRedoEnabled(false);
	}
	
	public void startRecording()
	{
		isRecording = true;
		recordedCommands = new Macro(invoker);
	}
	
	public void overtype()
	{
		isOvertype = !isOvertype;
	}
	
	public Macro stopRecording()
	{
		isRecording = false;
		//Macro temp = Macro(recordedCommands);
		//recordedCommands.clear();
		return recordedCommands;
	}
	
	public void setItalic(int start, int length, boolean italicOn)
	{
		ItalicCommand c = new ItalicCommand(model, start, length, italicOn);
		if(isRecording)
		{
			recordedCommands.addStep(new ItalicCommand(c));
		}
		invoker.doCommand(c);
		view.setUndoEnabled(true);
		view.setRedoEnabled(false);
	}
	public void setUnderline(int start, int length, boolean underlineOn)
	{
		UnderlineCommand c = new UnderlineCommand(model, start, length, underlineOn);
		if(isRecording)
		{
			recordedCommands.addStep(new UnderlineCommand(c));
		}
		invoker.doCommand(c);
		view.setUndoEnabled(true);
		view.setRedoEnabled(false);
	}
	
	public void setColor(int start, int length, Color newColor, Color prevColor)
	{
		ColorCommand c = new ColorCommand(model, start, length, newColor, prevColor);
		if(isRecording)
		{
			recordedCommands.addStep(new ColorCommand(c));
		}
		invoker.doCommand(c);
		view.setUndoEnabled(true);
		view.setRedoEnabled(true);
	}
	
	public void undo()
	{
		boolean empty;
		empty = invoker.undoCommand();
		view.setRedoEnabled(true);
		if (empty == true)
			view.setUndoEnabled(false);
	}
	public void redo()
	{
		boolean empty;
		empty = invoker.redoCommand();
		view.setUndoEnabled(true);
		if (empty == true)
			view.setRedoEnabled(false);
	}
	
	public void textInserted(int start, int length)
	{
		String insertedText = view.getText().substring(start, start + length);
		System.out.println("text inserted: " + insertedText + ", start=" + start + ", length=" + length );
		StyleList insertedStyles = view.getStylesInRange(start, length);
		
		InsertTextCommand c = new InsertTextCommand(model, start, insertedText, insertedStyles);
		if(isRecording)
		{
			recordedCommands.addStep(new InsertTextCommand(c));
		}
		invoker.doCommand(c);
		
		
		view.setUndoEnabled(true);
		view.setRedoEnabled(true);
	}
	public void textRemoved(int start, int length)
	{
		
		String textRemoved = model.getTextSubstring(start , length);
				
		StyleList removedStyles = view.getStylesInRange(start, length);
		System.out.printf("start: %d \tlength: %d\tText: %s%n", start, length, textRemoved);
		
		RemoveTextCommand c = new RemoveTextCommand(model, start, textRemoved, removedStyles);
		if(isRecording)
		{
			recordedCommands.addStep(new RemoveTextCommand(c));
		}
		invoker.doCommand(c);
		view.setUndoEnabled(true);
		view.setRedoEnabled(true);
	}
	
	private void updateUndoRedoButtons()
	{
	}
	
	public void openFile()
	{
		String fileName = view.getOpenFileName();
		
		if(fileName.equals("") == false)
		{
			/**
			 * Insert your template method pattern file opening code here.
			 */
		}
	}
	
	public void saveFile()
	{
		String fileName = view.getSaveFileName();
		
		if(fileName.equals("") == false)
		{
			/**
			 * Insert your builder pattern file saving code here.
			 */
		}
	}
	
	private SaveType getFileType(String filePath)
	{
		if(filePath.endsWith(".html") || filePath.endsWith(".htm"))
		{
			return SaveType.HTML;
		}
		else if(filePath.endsWith(".gt"))
		{
			return SaveType.GOOGLE_TALK;
		}
		else
		{
			return SaveType.PLAIN_TEXT;
		}
	}
	
	// ----------------------------------------------------------------------------
	// Printing Debug Methods
	// ----------------------------------------------------------------------------
	public void printCommands()
	{
		System.out.println();
	}
	
	public void printTextComparison()
	{
		System.out.println("Editor Text: \"" + view.getText() + "\"");
		System.out.println("Model Text:  \"" + model.getText() + "\"");
		System.out.println();
	}
	
	public void printStyleComparison()
	{
		System.out.println("Editor Styles:");
		StylePrinter.printStyles(view.getStyles());
		System.out.println("Model Styles:");
		StylePrinter.printStyles(model.getStyles());	
		System.out.println();
	}
}
