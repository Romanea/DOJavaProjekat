package shapes.point;

import shapes.Command;
import view.LoggerView;

public class UpdatePoint implements Command {
	
	private Point oldState = new Point();
	private Point original;
	private Point newState;

	public UpdatePoint(Point original, Point newState) {
		this.original = original;
		this.newState = newState;
	}	
	
	@Override
	public boolean execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());
		
		original.setX(newState.getX());
		original.setY(newState.getY());
		original.setColor(newState.getColor());
		return true;
	}

	@Override
	public boolean unexecute() {

		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setColor(oldState.getColor());
		return true;
	}
	
	public String toString() {
		return "Update: " + original.toString()+ " to "+ newState.toString();
	}

}
