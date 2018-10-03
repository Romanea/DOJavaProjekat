package strategy.open;

import java.io.File;

import app.MainFrame;
import model.ShapeModel;

public class OpenManager implements OpenStrategy{
	OpenStrategy openStrategy;
	
	public OpenManager(OpenStrategy strategy) {
		this.openStrategy = strategy;
	}
	
	@Override
	public void open(ShapeModel model, MainFrame frame, File file) {
		// TODO Auto-generated method stub
		openStrategy.open(model, frame, file);
	}

}
