package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;

public class AddRectangle implements Command{
	private ShapeModel model;
	private Rectangle rectangle;
	
	public AddRectangle(ShapeModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}
	

	@Override
	public void execute() {
		this.model.add(rectangle);
		
	}

	@Override
	public void unexecute() {
		this.model.remove(rectangle);
		
	}

}