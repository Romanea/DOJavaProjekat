package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveHexagonAdapter implements Command {

	private ShapeModel model;
	private HexagonAdapter hexagon;
	private LoggerView log;

	
	public RemoveHexagonAdapter(ShapeModel model, HexagonAdapter hexagon, LoggerView log) {
		this.model = model;
		this.hexagon = hexagon;
		this.log = log;

	}
	
	public void execute() {
		this.model.remove(hexagon);
		log.getModel().addElement("Remove: " + hexagon.toString());

		
	}

	@Override
	public void unexecute() {
		this.model.add(hexagon);
		log.getModel().addElement("Undo Remove: " + hexagon.toString());

		
	}

}
