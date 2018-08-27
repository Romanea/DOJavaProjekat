package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveCircle implements Command {

	private ShapeModel model;
	private Circle circle;
	private LoggerView log;

	
	public RemoveCircle(ShapeModel model, Circle circle, LoggerView log) {
		this.model =model;
		this.circle=circle;
		this.log = log;

	}
	@Override
	public void execute() {
		this.model.remove(circle);
		log.getModel().addElement("Remove: " + circle.toString());

		
	}

	@Override
	public void unexecute() {
		this.model.add(circle);
		log.getModel().addElement("Undo Remove: " + circle.toString());

	}

}
