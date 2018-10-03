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
		cmd.execute();
		model.getUndoStack().offerLast(cmd);
	}
	
	public void draw(Shape shape) {
		Command cmd = frame.getCommandController().generateAddCommand(shape, model);
		cmd.execute();
    	frame.getView().repaint();

	}
	
	public void makeNewDrawing() {
		model.removeAllShapes();
    	frame.getView().repaint();
    	frame.getLogView().getModel().clear();
	}
	
	
	

}
