package controller.command;

import java.io.Serializable;
import java.util.Stack;

public class TextCommandInvoker implements Serializable {
	Stack<TextCommand> commands = new Stack<>();
	Stack<TextCommand> redoCommands = new Stack<>();
    public void doCommand(TextCommand c) {
        commands.push(c);
        c.execute();
        System.out.println(c);
    }

    public void undoCommand() {
    	TextCommand c = commands.pop();
    	if( c != null ) {
    		c.undo();
    		redoCommands.push(c);
            System.out.println("Undo:" + c);
    	}
    }
    //returns true if has more redos; false otherwise
    public void redoCommand(){
    	TextCommand c = redoCommands.pop();
    	if( c != null) {
    		c.redo();
    		System.out.println("Redo:" + c);
    	}
    }
}