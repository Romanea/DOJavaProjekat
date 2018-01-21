package shapes.line;

import shapes.Command;

public class UpdateLine implements Command{

	private Line oldState = new Line();
	private Line original;
	private Line newState;
	
	public UpdateLine(Line original, Line newState) {
	
		this.original = original;
		this.newState = newState;
	}
	@Override
	public void execute() {
		oldState.getpStart().setX(original.getpStart().getX());
		oldState.getpStart().setY(original.getpStart().getY());
		oldState.getpEnd().setX(original.getpEnd().getX());
		oldState.getpEnd().setY(original.getpEnd().getY());
		oldState.setColor(original.getColor());
		
		original.getpStart().setX(newState.getpStart().getX());
		original.getpStart().setY(newState.getpStart().getY());
		original.getpEnd().setX(newState.getpEnd().getX());
		original.getpEnd().setY(newState.getpEnd().getY());
		original.setColor(newState.getColor());
		
	}

	@Override
	public void unexecute() {
		original.getpStart().setX(oldState.getpStart().getX());
		original.getpStart().setY(oldState.getpStart().getY());
		original.getpEnd().setX(oldState.getpEnd().getX());
		original.getpEnd().setY(oldState.getpEnd().getY());
		original.setColor(oldState.getColor());
		
	}

}
