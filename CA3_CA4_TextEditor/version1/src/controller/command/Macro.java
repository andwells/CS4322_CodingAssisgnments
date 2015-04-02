package controller.command;

import java.util.Stack;


public class Macro
{
	private String name;
	private Stack<TextCommand> commands;
	
	public Macro(String name)
	{
		this.name = name;
		commands = new Stack<TextCommand>();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addStep(TextCommand c)
	{
		if(c != null)
		{
			commands.push(c);
		}
	}
	
	public TextCommand removeLast()
	{
		return commands.pop();
	}
	
	public void play()
	{
		
	}
}
