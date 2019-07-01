package shapes.square;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveSquare implements Command {

	private ShapeModel model;
	private Square square;

	
	public RemoveSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;

	}
	@Override
	public boolean execute() {
		this.model.remove(square);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.add(square);
		return true;
	}
	
	public String toString() {
		return "Remove: " + square.toString();
	}

}
