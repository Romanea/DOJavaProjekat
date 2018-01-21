package shapes.circle;

import shapes.Command;

public class UpdateCircle implements Command{

	private Circle oldState = new Circle();
	private Circle original;
	private Circle newState;
	
	public UpdateCircle(Circle original, Circle newState) {
		this.original = original;
		this.newState = newState;
		
	}
	
	@Override
	public void execute() {
		
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setR(original.getR());
		oldState.setClrInnerColor(original.getClrInnerColor());
		oldState.setBorderColor(original.getBorderColor());
		
		original.getCenter().setX(newState.getCenter().getX());
		original.getCenter().setY(newState.getCenter().getY());
		original.setR(newState.getR());
		original.setClrInnerColor(newState.getClrInnerColor());
		original.setBorderColor(newState.getBorderColor());
		
		
	}

	@Override
	public void unexecute() {
		original.getCenter().setX(oldState.getCenter().getX());
		original.getCenter().setY(oldState.getCenter().getY());
		original.setR(oldState.getR());
		original.setClrInnerColor(oldState.getClrInnerColor());
		original.setBorderColor(oldState.getBorderColor());
		
	}

}
