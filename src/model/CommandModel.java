package model;

import java.util.ArrayList;

import shapes.Command;

public class CommandModel {

private ArrayList<Command> commands = new ArrayList<Command>();
	
	
	public void add(Command c) {
		commands.add(c);
	}

	public boolean remove(Command c) {
		return commands.remove(c);
	}

	public Command getCommand(int index) {
		return commands.get(index);
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}

}
