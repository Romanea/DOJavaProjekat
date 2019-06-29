package zcommand;

import model.ShapeModel;
import view.LoggerView;
import shapes.Command;
import shapes.Shape;

public class ToBack implements Command {
	
	private ShapeModel model;
	private Shape tmpShape;

	public ToBack(ShapeModel drawingModel) {
		this.model = drawingModel;
	}

	@Override
	public void execute() {
		for(int i = model.getShapes().size()-1  ; i > 0  ; i--) {
		
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0) ) {
				
				tmpShape = model.getSelectedShapes().get(0);
				model.getShapes().set(i, model.getShape(i-1));
				model.getShapes().set(i-1, tmpShape);
				return;
				}
				
			}
		}
	

	

	@Override
	public void unexecute() {
		for(int i = 0  ; i < model.getShapes().size()-1 ; i++) {
	
			if(model.getShapes().get(i) == tmpShape ) {
				
				
				model.getShapes().set(i, model.getShape(i+1));
				model.getShapes().set(i+1, tmpShape);			
				return;
			}
		}

	}

}
