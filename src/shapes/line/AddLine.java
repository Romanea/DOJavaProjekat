package shapes.line;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddLine implements Command{
	
	private ShapeModel model;
	private Line line;

	
	public AddLine(ShapeModel model, Line line) {
		this.model = model;
		this.line = line;

	}

	@Override
	public boolean execute() {
		this.model.add(line);
		return true;

	}

	@Override
	public boolean unexecute() {
		this.model.remove(line);
		return true;
	}
	
	public String toString() {
		return "Add: " + line.toString();
	}

}
