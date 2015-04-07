package controller.command;

import java.util.Stack;

import javax.swing.text.Caret;

public class Macro
{
	private String name;
	private Stack<TextCommand> commands;
	private TextCommandInvoker invoker;
		
	
	public Macro(TextCommandInvoker tci)
	{
		this.name = "";
		commands = new Stack<TextCommand>();
		invoker = tci;
	}
	public Macro(String name, TextCommandInvoker tci)
	{
		this.name = name;
		commands = new Stack<TextCommand>();
		invoker = tci;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int totalCommands()
	{
		return commands.size(); 
	}
	
	public void addStep(TextCommand c)
	{
		//Add something to make start relative to cursor
		if(c != null)
		{
			commands.push(c);
		}
	}
	
	public TextCommand removeLast()
	{
		return commands.pop();
	}
	
	public void play(Caret car)
	{
		for(int i = 0; i < commands.size(); i++)
		{
			TextCommand c = commands.get(i);
			c.updateStart(car.getDot());
			switch(c.getClass().getSimpleName())
			{
				case "BoldCommand":
					BoldCommand b = (BoldCommand) c;
					invoker.doCommand(new BoldCommand(b));
					break;
				case "ColorCommand":
					ColorCommand cr = (ColorCommand) c;
					invoker.doCommand(new ColorCommand(cr));
					break;
				case "InsertTextCommand":
					InsertTextCommand itc = (InsertTextCommand) c;
					invoker.doCommand(new InsertTextCommand(itc));
					break;
				case "ItalicCommand":
					ItalicCommand ic = (ItalicCommand)c;
					invoker.doCommand(new ItalicCommand(ic));
					break;
				case "RemoveTextCommand":
					RemoveTextCommand rtc = (RemoveTextCommand) c; 
					invoker.doCommand(new RemoveTextCommand(rtc));
					break;
				case "UnderlineCommand":
					UnderlineCommand u = (UnderlineCommand) c;
					invoker.doCommand(new UnderlineCommand(u));
					break;
			}
			
			
			
			
		}
	}
}
