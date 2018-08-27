package shapes.line;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class AddLine implements Command{
	
	private ShapeModel model;
	private Line line;
	private LoggerView log;

	
	public AddLine(ShapeModel model, Line line, LoggerView log) {
		this.model = model;
		this.line = line;
		this.log = log;

	}

	@Override
	public void execute() {
		this.model.add(line);
		log.getModel().addElement("Add: " + line.toString());

	}

	@Override
	public void unexecute() {
		this.model.remove(line);
		log.getModel().addElement("Undo Add: " + line.toString());

		
	}

}
