package shapes.circle;



import shapes.Command;
import shapes.point.Point;
import view.LoggerView;

public class UpdateCircle implements Command{

	private Circle oldState = new Circle(new Point(0,0), 0);
	private Circle original;
	private Circle newState;

	
	public UpdateCircle(Circle original, Circle newState) {
		this.original = original;
		this.newState = newState;
	}
	
	@Override
	public boolean execute() {
		
		System.out.println(oldState.toString());
		System.out.println(original.toString());
		System.out.println(newState.toString());

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
		return true;
		
	}

	@Override
	public boolean unexecute() {
		original.getCenter().setX(oldState.getCenter().getX());
		original.getCenter().setY(oldState.getCenter().getY());
		original.setR(oldState.getR());
		original.setClrInnerColor(oldState.getClrInnerColor());
		original.setBorderColor(oldState.getBorderColor());
		return true;
		
	}
	
	@Override
	public String toString() {
		return "Update: " + original.toString()+ " to "+ newState.toString();
	}

}
