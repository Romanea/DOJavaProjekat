package shapes.hexagon;

import java.awt.Color;

import hexagon.Hexagon;
import shapes.Command;
import view.LoggerView;

public class UpdateHexagonAdapter implements Command{
	
	private HexagonAdapter oldState = new HexagonAdapter(new Hexagon(0, 0, 0), Color.BLACK, Color.BLACK);
	private HexagonAdapter original;
	private HexagonAdapter newState;
	private LoggerView log;



	public UpdateHexagonAdapter(HexagonAdapter original, HexagonAdapter newState, LoggerView log) {
		this.original = original;
		this.newState = newState;
		this.log = log;

		
	}

	@Override
	public void execute() {
		oldState.getHexagon().setX(original.getHexagon().getX());
		oldState.getHexagon().setY(original.getHexagon().getY());
		oldState.getHexagon().setR(original.getHexagon().getR());
		oldState.setColor(original.getColor());
		oldState.setClrInnerColor(original.getClrInnerColor());

		original.getHexagon().setX(newState.getHexagon().getX());
		original.getHexagon().setY(newState.getHexagon().getY());
		original.getHexagon().setR(newState.getHexagon().getR());
		original.setColor(newState.getColor());
		original.setClrInnerColor(newState.getClrInnerColor());
		
		log.getModel().addElement("Update: " + original.toString()+ " to "+ newState.toString());

	}

	@Override
	public void unexecute() {
		original.getHexagon().setX(oldState.getHexagon().getX());
		original.getHexagon().setY(oldState.getHexagon().getY());
		original.getHexagon().setR(oldState.getHexagon().getR());
		original.setColor(oldState.getColor());
		original.setClrInnerColor(oldState.getClrInnerColor());
		
		log.getModel().addElement("Undo Update: " + original.toString()+ " to "+ newState.toString());


	}

}


