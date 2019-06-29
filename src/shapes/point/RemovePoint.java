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
	public void execute() {
		this.model.remove(point);
}

	@Override
	public void unexecute() {
		this.model.add(point);
		
	}

}
