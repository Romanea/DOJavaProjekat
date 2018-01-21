package shapes.square;

import model.ShapeModel;
import shapes.Command;

public class RemoveSquare implements Command {

	private ShapeModel model;
	private Square square;
	
	public RemoveSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;
	}
	@Override
	public void execute() {
		this.model.remove(square);
	}

	@Override
	public void unexecute() {
		this.model.add(square);
	}

}
