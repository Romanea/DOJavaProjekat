package shapes.point;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemovePoint implements Command {


	private ShapeModel model;
	private Point point;
	private LoggerView log;
	
	public RemovePoint(ShapeModel model, Point point, LoggerView log)
	{
		this.model = model;
		this.point = point;
		this.log = log;
	}
	@Override
	public void execute() {
		this.model.remove(point);
		log.getModel().addElement("Remove: " + point.toString());
}

	@Override
	public void unexecute() {
		this.model.add(point);
		log.getModel().addElement("Undo Remove: " + point.toString());

		
	}

}
