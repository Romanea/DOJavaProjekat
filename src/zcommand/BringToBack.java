package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class BringToBack implements Command {
	
	private ShapeModel model;
	private Shape tmpShape;
	private int indexOfShape;

	public BringToBack(ShapeModel drawingModel) {
		this.model = drawingModel;
	}

	@Override
	public boolean execute() {
		
		
		for(int i = 0 ; i < model.getShapes().size() ; i++) {
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0)) {
				tmpShape = model.getSelectedShapes().get(0);
				for(int j=i ; j >=1 ; j--) {
					
					model.getShapes().set(j, model.getShape(j-1));
				}
				model.getShapes().set(0, tmpShape);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean unexecute() {
	
		for(int i=0; i < indexOfShape ; i++) {
			model.getShapes().set(i, model.getShape(i+1));
			
		}
		
		model.getShapes().set(indexOfShape, tmpShape);
		return true;

	}
	
	@Override
	public String toString() {
		return "Bring to back: " + tmpShape.toString();
	}

}
