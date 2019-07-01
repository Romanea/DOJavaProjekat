package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class BringToFront implements Command {
	
	private ShapeModel model;
	private Shape tmpShape;
	private int indexOfShape;

	public BringToFront(ShapeModel drawingModel ) {
		this.model = drawingModel;
	}

	@Override
	public boolean execute() {
		
		for(int i = 0 ; i < model.getShapes().size() ; i++) {
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0)) {
				tmpShape = model.getSelectedShapes().get(0);
				indexOfShape = i;
				
				model.getShapes().add(tmpShape);
				model.remove(model.getShape(i));
				return true;
			}
		}
		
		return false;
		

	}

	@Override
	public boolean unexecute() {
	
		
		
		for(int i= model.getShapes().size() - 1; i > indexOfShape ; i--) {
			model.getShapes().set(i, model.getShape(i-1));
			
		}
		
		model.getShapes().set(indexOfShape, tmpShape);
		return true;
	}
	
	@Override
	public String toString() {
		return "Bring to front: " + tmpShape.toString();
	}


}
