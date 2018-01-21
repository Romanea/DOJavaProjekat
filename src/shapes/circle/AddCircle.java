package shapes.circle;

import model.ShapeModel;
import shapes.Command;

public class AddCircle implements Command{

	private ShapeModel model;
	private Circle circle;
	
	public AddCircle(ShapeModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}
	@Override
	public void execute() {
		this.model.add(circle);
	}

	@Override
	public void unexecute() {
		this.model.remove(circle);
	}

}
