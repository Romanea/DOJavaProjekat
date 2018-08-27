package shapes.square;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddSquare implements Command {

	private ShapeModel model;
	private Square square;
	private LoggerView log;

	
	public AddSquare(ShapeModel model, Square square, LoggerView log) {
		this.model = model;
		this.square = square;
		this.log = log;

	}
	@Override
	public void execute() {
		this.model.add(square);
		log.getModel().addElement("Add: " + square.toString());

	}

	@Override
	public void unexecute() {
		this.model.remove(square);
		log.getModel().addElement("Undo Add: " + square.toString());

		
	}

}
