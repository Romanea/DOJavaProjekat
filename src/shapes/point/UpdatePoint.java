package shapes.point;

import shapes.Command;

public class UpdatePoint implements Command {
	
	private Point oldState = new Point();
	private Point original;
	private Point newState;

	public UpdatePoint(Point original, Point newState) {
		this.original = original;
		this.newState = newState;
	}	
	
	@Override
	public void execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());
		
		original.setX(newState.getX());
		original.setY(newState.getY());
		original.setColor(newState.getColor());
	}

	@Override
	public void unexecute() {

		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setColor(oldState.getColor());
		
	}

}
