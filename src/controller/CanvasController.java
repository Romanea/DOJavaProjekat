package controller;


import java.awt.event.MouseEvent;


import shapes.Command;
import shapes.Shape;
import app.MainFrame;
import model.ShapeModel;

public class CanvasController  {
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(ShapeModel model, MainFrame frame ) {
		this.frame = frame;
		this.model = model;
	}

	
	public void mousePressed(MouseEvent e, Shape shape) {
		Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		if(cmd.execute()) {
			frame.getLogController().logCommand(cmd); // TEST
			model.getUndoStack().offerLast(cmd);
			frame.getView().getModel().notifyAllObservers();
		}
	}
	
	public void draw(Shape shape) {
		Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		if(cmd.execute()) {
			frame.getView().getModel().notifyAllObservers();
			frame.getLogController().logCommand(cmd);
	    	frame.getView().repaint();
		}

	}
	
	public void makeNewDrawing() {
		model.removeAllShapes();
    	frame.getView().repaint();
    	frame.getLogView().getLogs().clear();
	}
	
	
	

}
