package controller.command;

import java.io.Serializable;
import java.util.Stack;

public class TextCommandInvoker implements Serializable {
	Stack<TextCommand> commands = new Stack<>();
	Stack<TextCommand> redoCommands = new Stack<>();
	
    public void doCommand(TextCommand c) {
        commands.push(c);
        redoCommands.clear();
        c.execute();
        System.out.println(c);
        //printStack();
    }

    public void add(TextCommand c)
    {
    	if(c != null)
    	{
    		commands.push(c);
    		redoCommands.clear();
    	}
    }
    public boolean undoCommand() {
    	TextCommand c = commands.pop();
    	if( c != null ) {  
    		c.undo();
    		redoCommands.push(c);
            System.out.println("Undo:" + c);
            //printStack();
    	}
    	
    	return commands.isEmpty();
    }
    //returns true if has more redos; false otherwise
    public boolean redoCommand(){
    	TextCommand c = redoCommands.pop();
    	if( c != null) {
    		c.redo();
    		commands.push(c);
    		System.out.println("Redo:" + c);
    		//printStack();
    	}
    	return redoCommands.isEmpty();
    }
    
    private void printStack()
    {
    	System.out.println("DEBUG::PRINTING COMMAND STACK::DEBUG");
    	
    	for(int i = commands.size() - 1; i >= 0; i--)
    	{
    		System.out.println(commands.get(i));
    	}
    	
    }
    
    public boolean canUndo()
    {
    	if(commands.size() > 0)
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean canRedo()
    {
    	if(redoCommands.size() > 0)
    	{
    		return true;
    	}
    	return false;
    }
}
