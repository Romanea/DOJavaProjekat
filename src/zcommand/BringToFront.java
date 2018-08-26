package zcommand;

import model.ShapeModel;
import view.LogView;
import shapes.Command;
import shapes.Shape;

public class BringToFront implements Command {
	
	private ShapeModel model;
	private LogView logView;
	private Shape tmpShape;
	private int indexOfShape;

	public BringToFront(ShapeModel drawingModel) {
		this.model = drawingModel;
		//this.logView = logView;
	}

	@Override
	public void execute() {
		
		for(int i = 0 ; i < model.getShapes().size() ; i++) {
			if(model.getShapes().get(i) == model.getSelectedShapes().get(0) ) {
				tmpShape = model.getSelectedShapes().get(0);
				indexOfShape = i;
				
				model.getShapes().add(tmpShape);
				model.remove(model.getShape(i));
				//logView.getModel().addElement("Bring to front: " + tmpShape.toString());
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
		//logView.getModel().addElement("Undo bring to front: " + tmpShape.toString());
		
		
		

	}

}
