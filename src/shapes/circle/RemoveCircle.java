package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveCircle implements Command {

	private ShapeModel model;
	private Circle circle;

	
	public RemoveCircle(ShapeModel model, Circle circle) {
		this.model =model;
		this.circle=circle;

	}
	@Override
	public void execute() {
		this.model.remove(circle);

		
	}

	@Override
	public void unexecute() {
		this.model.add(circle);

	}

}
