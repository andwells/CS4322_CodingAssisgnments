package model;

import java.awt.Color;

public abstract class StyleCreator
{
	public static TextEditorStyle getNormalStyle()
	{
		return new TextEditorStyle();
	}
	
	public static TextEditorStyle getBoldStyle()
	{
		return getBoldStyle(true);
	}
	public static TextEditorStyle getBoldStyle(boolean boldOn)
	{
		TextEditorStyle boldStyle = new TextEditorStyle();
		boldStyle.setBold(boldOn);
		return boldStyle;
	}
	
	public static TextEditorStyle getItalicStyle()
	{
		return getItalicStyle(true);
	}
	public static TextEditorStyle getItalicStyle(boolean italicOn)
	{
		TextEditorStyle italicStyle = new TextEditorStyle();
		italicStyle.setItalic(italicOn);
		return italicStyle;
	}
	
	public static TextEditorStyle getUnderlineStyle()
	{
		return getUnderlineStyle(true);
	}
	public static TextEditorStyle getUnderlineStyle(boolean underlineOn)
	{
		TextEditorStyle underlineStyle = new TextEditorStyle();
		underlineStyle.setUnderline(underlineOn);
		return underlineStyle;
	}
	
	
	//Default implementation returns a style with foreground set to black
	public static TextEditorStyle getColorStyle()
	{
		return getColorStyle(Color.black);
	}
	
	public static TextEditorStyle getColorStyle(Color aColor)
	{
		TextEditorStyle colorStyle = new TextEditorStyle();
		colorStyle.setColor(aColor);
		return colorStyle;
	}
}
