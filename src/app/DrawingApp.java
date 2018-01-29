package app;

import javax.swing.JFrame;

import controller.CanvasController;
import model.ShapeModel;

public class DrawingApp {

	public static void main(String[] args) {
		ShapeModel model = new ShapeModel();
		MainFrame frame = new MainFrame();
		frame.getView().setModel(model);
		CanvasController controller = new CanvasController(model, frame);
	
		frame.setCanvasController(controller);
	
		}

	

}
