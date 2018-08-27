package shapes.line;

import shapes.Command;
import shapes.point.Point;
import view.LoggerView;

public class UpdateLine implements Command{

	private Line oldState = new Line(new Point(0,0), new Point(0,0));
	private Line original;
	private Line newState;
	private LoggerView log;

	
	public UpdateLine(Line original, Line newState, LoggerView log) {
	
		this.original = original;
		this.newState = newState;
		this.log = log;

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
		
		log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

	}

	@Override
	public void unexecute() {
		original.getpStart().setX(oldState.getpStart().getX());
		original.getpStart().setY(oldState.getpStart().getY());
		original.getpEnd().setX(oldState.getpEnd().getX());
		original.getpEnd().setY(oldState.getpEnd().getY());
		original.setColor(oldState.getColor());
		
		log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());

	}

}
