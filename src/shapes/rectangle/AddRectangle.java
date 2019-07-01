package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddRectangle implements Command{
	private ShapeModel model;
	private Rectangle rectangle;

	
	public AddRectangle(ShapeModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;

	}
	

	@Override
	public boolean execute() {
		this.model.add(rectangle);
		return true;
		
	}

	@Override
	public boolean unexecute() {
		this.model.remove(rectangle);
		return true;
		
	}
	
	public String toString() {
		return "Add: " + rectangle.toString();
	}

}
