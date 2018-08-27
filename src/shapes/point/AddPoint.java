package shapes.point;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;

public class AddPoint implements Command {

	private ShapeModel model;
	private Point point;
	private LoggerView log;
	
	public AddPoint(ShapeModel model, Point point, LoggerView log)
	{
		this.model = model;
		this.point = point;
		this.log = log;
	}
	
	@Override
	public void execute() {
		this.model.add(point);
		log.getModel().addElement("Add: " + point.toString());
	}

	@Override
	public void unexecute() {
		this.model.remove(point);
		log.getModel().addElement("Undo Add: " + point.toString());

	}

}
