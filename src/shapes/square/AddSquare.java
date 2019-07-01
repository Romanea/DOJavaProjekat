package shapes.square;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddSquare implements Command {

	private ShapeModel model;
	private Square square;

	
	public AddSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;

	}
	@Override
	public boolean execute() {
		this.model.add(square);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.remove(square);
		return true;
	}
	
	public String toString() {
		return "Add: " + square.toString();
	}

}
