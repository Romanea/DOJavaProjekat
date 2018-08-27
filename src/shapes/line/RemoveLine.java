package shapes.line;

import model.ShapeModel;
import shapes.Command;
import view.LoggerView;

public class RemoveLine implements Command {
	
	private ShapeModel model;
	private Line line;
	private LoggerView log;


	public RemoveLine(ShapeModel model, Line line, LoggerView log) {
		this.model=model;
		this.line = line;
		this.log = log;

	}
	
	@Override
	public void execute() {
		this.model.remove(line);
		log.getModel().addElement("Remove: " + line.toString());

	}

	@Override
	public void unexecute() {
		this.model.add(line);
		log.getModel().addElement("Undo Remove: " + line.toString());

	}
	
	

}
