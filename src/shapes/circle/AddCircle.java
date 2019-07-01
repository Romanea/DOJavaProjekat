package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddCircle implements Command{

	private ShapeModel model;
	private Circle circle;

	
	public AddCircle(ShapeModel model, Circle circle) {
		this.model = model;
		this.circle = circle;

	}
	@Override
	public boolean execute() {
		this.model.add(circle);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.remove(circle);
		return true;

	}
	
	@Override
	public String toString() {
		return "Add: " + circle.toString();
	}

}
