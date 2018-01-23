package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;

public class RemoveHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;
	
	public RemoveHexagonAdapter(ShapeModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}
	
	public void execute() {
		this.model.remove(hexagon);
		
	}

	@Override
	public void unexecute() {
		this.model.add(hexagon);
		
	}

}
