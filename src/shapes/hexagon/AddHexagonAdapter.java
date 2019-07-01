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
	
	public boolean execute() {
		
		this.model.add(hexagon);
		return true;
		
	}

	@Override
	public boolean unexecute() {
		this.model.remove(hexagon);
		return true;
	}
	
	public String toString() {
		return "Add: " + hexagon.toString();
	}

}
