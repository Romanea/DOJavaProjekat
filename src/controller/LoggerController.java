package controller;

import app.MainFrame;
import shapes.Command;
import view.LoggerView;

public class LoggerController {

	LoggerView view;
	
	public LoggerView getView() {
		return view;
	}

	public void setView(LoggerView view) {
		this.view = view;
	}

	public void logCommand(Command cmd) {
		view.getLogs().addElement(cmd.toString());
		//System.out.println(cmd.toString());
	}
}
