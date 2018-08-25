package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;

public class AddHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;
	
	public AddHexagonAdapter(ShapeModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}
	
	public void execute() {
		
		this.model.add(hexagon);
		System.out.println(this.model);
		
	}

	@Override
	public void unexecute() {
		this.model.remove(hexagon);
		
	}

}
