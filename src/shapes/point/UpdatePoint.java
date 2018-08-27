package shapes.point;

import shapes.Command;
import view.LoggerView;

public class UpdatePoint implements Command {
	
	private Point oldState = new Point();
	private Point original;
	private Point newState;
	private LoggerView log;

	public UpdatePoint(Point original, Point newState, LoggerView log) {
		this.original = original;
		this.newState = newState;
		this.log = log;
	}	
	
	@Override
	public void execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());
		
		original.setX(newState.getX());
		original.setY(newState.getY());
		original.setColor(newState.getColor());
		
		log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

	}

	@Override
	public void unexecute() {

		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setColor(oldState.getColor());
		
		log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());

		
	}

}
