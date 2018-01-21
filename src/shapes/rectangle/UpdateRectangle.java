package shapes.rectangle;

import shapes.Command;

public class UpdateRectangle implements Command {
	
	private Rectangle oldState = new Rectangle();
	private Rectangle original;
	private Rectangle newState;
	
	public UpdateRectangle(Rectangle original, Rectangle newState) {
		this.original = original;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setWidth(original.getWidth());
		oldState.setColor(original.getColor());
		oldState.setClrInnerColor(original.getClrInnerColor());
		
		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setWidth(newState.getWidth());
		original.setColor(newState.getColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setWidth(oldState.getWidth());
		original.setColor(oldState.getColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		
	}

}
