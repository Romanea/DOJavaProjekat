package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class BringToBack implements Command {
	
	private ShapeModel model;
	private LoggerView logView;
	private Shape tmpShape;
	private int indexOfShape;

	public BringToBack(ShapeModel drawingModel, LoggerView logView) {
		this.model = drawingModel;
		this.logView = logView;
	}

	@Override
	public void execute() {
		
		
		for(int i = 0 ; i < model.getShapes().size() ; i++) {
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0) ) {
				tmpShape = model.getSelectedShapes().get(0);
				for(int j=i ; j >=1 ; j--) {
					
					model.getShapes().set(j, model.getShape(j-1));
				}
				model.getShapes().set(0, tmpShape);
				logView.getModel().addElement("Bring to back: " + tmpShape.toString());
				return;
			}
		}
	}

	@Override
	public void unexecute() {
	
		for(int i=0; i < indexOfShape ; i++) {
			model.getShapes().set(i, model.getShape(i+1));
			
		}
		
		model.getShapes().set(indexOfShape, tmpShape);
		logView.getModel().addElement("Undo bring to back: " + tmpShape.toString());

	}

}
