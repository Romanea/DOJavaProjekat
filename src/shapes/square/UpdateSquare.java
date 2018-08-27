package shapes.square;

import shapes.Command;
import shapes.point.Point;
import view.LoggerView;

public class UpdateSquare implements Command {

	private Square oldState = new Square(new Point(0,0), 0);
	private Square original;
	private Square newState;
	private LoggerView log;

	
	public UpdateSquare(Square original, Square newState, LoggerView log) {
		this.original = original;
		this.newState = newState;
		this.log = log;

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
		original.setBorderColor(newState.getBorderColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
		log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setBorderColor(oldState.getBorderColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());

		
	}

}
