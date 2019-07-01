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
	public void execute() {
		
		for(int i = 0 ; i < model.getShapes().size() ; i++) {
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0)
					&& model.isInFront(model.getShapes().get(i))) {
				tmpShape = model.getSelectedShapes().get(0);
				indexOfShape = i;
				
				model.getShapes().add(tmpShape);
				model.remove(model.getShape(i));
				return;
			}
		}
		

	}

	@Override
	public void unexecute() {
	
		
		
		for(int i= model.getShapes().size() - 1; i > indexOfShape ; i--) {
			model.getShapes().set(i, model.getShape(i-1));
			
		}
		
		model.getShapes().set(indexOfShape, tmpShape);

	}
	
	@Override
	public String toString() {
		return "Bring to front: " + tmpShape.toString();
	}


}
