package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;
	private LoggerView log;

	
	public AddHexagonAdapter(ShapeModel model, HexagonAdapter hexagon, LoggerView log) {
		this.model = model;
		this.hexagon = hexagon;
		this.log = log;

	}
	
	public void execute() {
		
		this.model.add(hexagon);
		log.getModel().addElement("Add: " + hexagon.toString());

		
	}

	@Override
	public void unexecute() {
		this.model.remove(hexagon);
		log.getModel().addElement("Undo Add: " + hexagon.toString());

		
	}

}
