package controller;

import app.MainFrame;
import shapes.Command;
import view.LoggerView;

public class LoggerController {

	LoggerView view;
	
	public void logCommand(Command cmd) {
		view.getModel().getDlm().addElement(cmd.toString());
	}
}
