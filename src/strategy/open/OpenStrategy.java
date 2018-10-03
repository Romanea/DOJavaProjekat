package strategy.open;

import java.io.File;

import app.MainFrame;
import model.ShapeModel;

public interface OpenStrategy {
	
	public void open(ShapeModel model, MainFrame frame, File file);
	
}
