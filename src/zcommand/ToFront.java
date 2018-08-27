package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class ToFront implements Command {
	
	private ShapeModel drawingModel;
	private LoggerView logView;
	private Shape tmpShape;

	public ToFront(ShapeModel drawingModel, LoggerView logView) {
		this.drawingModel = drawingModel;
		this.logView = logView;
	}

	@Override
	public void execute() {
		
		for(int i = 0  ; i < drawingModel.getShapes().size()-1 ; i++) {
			
			if(drawingModel.getShapes().get(i) == drawingModel.getSelectedShapes().get(0) ) {
				
				tmpShape = drawingModel.getSelectedShapes().get(0);
				drawingModel.getShapes().set(i, drawingModel.getShape(i+1));
				drawingModel.getShapes().set(i+1, tmpShape);
				logView.getModel().addElement("To front: " + tmpShape.toString());
			
				return;
			}
		}

	}

	@Override
	public void unexecute() {
		for(int i = drawingModel.getShapes().size()-1  ; i > 0  ; i--) {
			
			if(drawingModel.getShapes().get(i) == tmpShape ) {
				
				drawingModel.getShapes().set(i, drawingModel.getShape(i-1));
				drawingModel.getShapes().set(i-1, tmpShape);
				logView.getModel().addElement("Undo to front: " + tmpShape.toString());
				return;
				}
				
			}
	}

}
