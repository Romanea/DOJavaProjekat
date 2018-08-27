package shapes.rectangle;

import shapes.Command;
import shapes.point.Point;
import view.LoggerView;

public class UpdateRectangle implements Command {
	
	private Rectangle oldState = new Rectangle(new Point(0,0), 0, 0);
	private Rectangle original;
	private Rectangle newState;
	private LoggerView log;

	
	public UpdateRectangle(Rectangle original, Rectangle newState, LoggerView log) {
		this.original = original;
		this.newState = newState;
		this.log = log;

	}

	@Override
	public void execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setWidth(original.getWidth());
		oldState.setBorderColor(original.getBorderColor());
		oldState.setClrInnerColor(original.getClrInnerColor());
		
		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setWidth(newState.getWidth());
		original.setBorderColor(newState.getBorderColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
		log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

		
	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setWidth(oldState.getWidth());
		original.setBorderColor(oldState.getBorderColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());

		
		
	}

}
