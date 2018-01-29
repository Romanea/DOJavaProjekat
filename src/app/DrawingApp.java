package app;



import controller.CanvasController;
import controller.CommandController;
import controller.ToolsController;
import model.CommandModel;
import model.ShapeModel;

public class DrawingApp {

	public static void main(String[] args) {
		ShapeModel model = new ShapeModel();
		MainFrame frame = new MainFrame();
		CommandModel commandModel = new CommandModel();
		CommandController commandController = new CommandController(commandModel, frame);
		frame.setCommandController(commandController);
		frame.getView().setModel(model);
		CanvasController controller = new CanvasController(model, frame);;
		frame.setCanvasController(controller);
		ToolsController toolsController = new ToolsController(frame);
		frame.setToolsController(toolsController);
		}

	

}
