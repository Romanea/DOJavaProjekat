package shapes.point;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemovePoint implements Command {


	private ShapeModel model;
	private Point point;
	
	public RemovePoint(ShapeModel model, Point point)
	{
		this.model = model;
		this.point = point;
	}
	@Override
	public boolean execute() {
		this.model.remove(point);
		return true;
}

	@Override
	public boolean unexecute() {
		this.model.add(point);
		return true;
	}
	
	public String toString() {
		return "Remove: " + point.toString();
	}

}
