package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class ToFront implements Command {
	
	private ShapeModel model;
	private Shape tmpShape;

	public ToFront(ShapeModel drawingModel) {
		this.model = drawingModel;
	}

	@Override
	public boolean execute() {
		
		for(int i = 0  ; i < model.getShapes().size()-1 ; i++) {
			
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0)) {
				
				tmpShape = model.getSelectedShapes().get(0);
				model.getShapes().set(i, model.getShape(i+1));
				model.getShapes().set(i+1, tmpShape);			
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean unexecute() {
		for(int i = model.getShapes().size()-1  ; i > 0  ; i--) {
			
			if(model.getShapes().get(i) == tmpShape ) {
				
				model.getShapes().set(i, model.getShape(i-1));
				model.getShapes().set(i-1, tmpShape);
				return true;
				}
				
			}
		return false;
	}
	
	@Override
	public String toString() {
		return "To front: " + tmpShape.toString();
	}


}
