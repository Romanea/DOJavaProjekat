package strategy.save;

import java.io.File;

import app.MainFrame;

public interface SaveStrategy {
	
	public void save(MainFrame frame, File file);

}