package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveRectangle implements Command {

	private ShapeModel model;
	private Rectangle rectangle;

	
	public RemoveRectangle(ShapeModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;

	
	}
	@Override
	public void execute() {
		this.model.remove(rectangle);
	}

	@Override
	public void unexecute() {
		this.model.add(rectangle);
	}

}
