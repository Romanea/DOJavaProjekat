package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddCircle implements Command{

	private ShapeModel model;
	private Circle circle;
	private LoggerView log;

	
	public AddCircle(ShapeModel model, Circle circle, LoggerView log) {
		this.model = model;
		this.circle = circle;
		this.log = log;

	}
	@Override
	public void execute() {
		this.model.add(circle);
		log.getModel().addElement("Add: " + circle.toString());
	}

	@Override
	public void unexecute() {
		this.model.remove(circle);
		log.getModel().addElement("Undo Add: " + circle.toString());

	}

}
