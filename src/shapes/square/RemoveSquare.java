package shapes.square;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveSquare implements Command {

	private ShapeModel model;
	private Square square;
	private LoggerView log;

	
	public RemoveSquare(ShapeModel model, Square square, LoggerView log) {
		this.model = model;
		this.square = square;
		this.log = log;

	}
	@Override
	public void execute() {
		this.model.remove(square);
		log.getModel().addElement("Remove: " + square.toString());

	}

	@Override
	public void unexecute() {
		this.model.add(square);
		log.getModel().addElement("Undo Remove: " + square.toString());

	}

}
