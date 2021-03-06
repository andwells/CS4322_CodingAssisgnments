package model;

import java.awt.Color;

public class TextChange
{
	private TextChangeType type;
	private int startIndex;
	private int length;
	private Color newColor;
	
	public TextChange(TextChangeType changeType, int changeStartIndex, int changeLength)
	{
		type = changeType;
		startIndex = changeStartIndex;
		length = changeLength;
		newColor = null;
	}
	
	public TextChange(TextChangeType changeType, int changeStartIndex, int changeLength, Color aColor)
	{
		type = changeType;
		startIndex = changeStartIndex;
		length = changeLength;
		newColor = aColor;
	}
	
	public TextChangeType getChangeType()
	{
		return type;
	}
	public int getStartIndex()
	{
		return startIndex;
	}
	public int getLength()
	{
		return length;
	}
	
	public Color getColor()
	{
		return this.newColor;
	}
	
	public void setColor(Color aColor)
	{
		this.newColor = aColor;
	}
}