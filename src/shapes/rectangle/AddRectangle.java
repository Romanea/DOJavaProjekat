package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddRectangle implements Command{
	private ShapeModel model;
	private Rectangle rectangle;
	private LoggerView log;

	
	public AddRectangle(ShapeModel model, Rectangle rectangle, LoggerView log) {
		this.model = model;
		this.rectangle = rectangle;
		this.log = log;

	}
	

	@Override
	public void execute() {
		this.model.add(rectangle);
		log.getModel().addElement("Add: " + rectangle.toString());

		
	}

	@Override
	public void unexecute() {
		this.model.remove(rectangle);
		log.getModel().addElement("Undo Add: " + rectangle.toString());

		
	}

}
