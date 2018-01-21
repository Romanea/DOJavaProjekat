package shapes.square;

import shapes.Command;

public class UpdateSquare implements Command {

	private Square oldState = new Square();
	private Square original;
	private Square newState;
	
	public UpdateSquare(Square original, Square newState) {
		this.original = original;
		this.newState = newState;
	}
	
	@Override
	public void execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setColor(original.getColor());
		oldState.setClrInnerColor(original.getClrInnerColor());
		
		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setColor(newState.getColor());
		original.setClrInnerColor(newState.getClrInnerColor());
	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setColor(oldState.getColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
	}

}
