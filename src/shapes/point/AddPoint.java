package shapes.point;

import model.ShapeModel;
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
	public void execute() {
		this.model.add(point);
	}

	@Override
	public void unexecute() {
		this.model.remove(point);
	}

}