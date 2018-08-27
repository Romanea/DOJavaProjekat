package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveRectangle implements Command {

	private ShapeModel model;
	private Rectangle rectangle;
	private LoggerView log;

	
	public RemoveRectangle(ShapeModel model, Rectangle rectangle, LoggerView log) {
		this.model = model;
		this.rectangle = rectangle;
		this.log = log;

	
	}
	@Override
	public void execute() {
		this.model.remove(rectangle);
		log.getModel().addElement("Remove: " + rectangle.toString());

		
	}

	@Override
	public void unexecute() {
		this.model.add(rectangle);
		log.getModel().addElement("Undo Remove: " + rectangle.toString());

	}

}
