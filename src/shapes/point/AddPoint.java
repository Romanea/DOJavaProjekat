package shapes.point;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;

public class AddPoint implements Command {

	private ShapeModel model;
	private Point point;
	
	public AddPoint(ShapeModel model, Point point)
	{
		this.model = model;
		this.point = point;
	}
	
	@Override
	public boolean execute() {
		this.model.add(point);
		return true;
	}

	@Override
	public boolean unexecute() {
		this.model.remove(point);
		return true;
	}
	
	@Override
	public String toString() {
		return "Add: " + point.toString();
	}
}
