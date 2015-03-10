package controller.command;

public interface TextCommand {
	public void execute();
	public void undo();
	public void redo();
}
