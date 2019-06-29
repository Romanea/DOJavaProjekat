package shapes.line;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveLine implements Command {
	
	private ShapeModel model;
	private Line line;


	public RemoveLine(ShapeModel model, Line line) {
		this.model=model;
		this.line = line;

	}
	
	@Override
	public void execute() {
		this.model.remove(line);

	}

	@Override
	public void unexecute() {
		this.model.add(line);
	}
	
	public String toString() {
		return "Remove: " + line.toString();
	}

}
