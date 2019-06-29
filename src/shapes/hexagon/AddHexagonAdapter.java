package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;

	
	public AddHexagonAdapter(ShapeModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;

	}
	
	public void execute() {
		
		this.model.add(hexagon);

		
	}

	@Override
	public void unexecute() {
		this.model.remove(hexagon);
		
	}
	
	public String toString() {
		return "Add: " + hexagon.toString();
	}

}
