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
	
		frame.setMouseClickedObserver(controller);
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}

	

}
