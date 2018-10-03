package strategy.save;

import java.io.File;

import app.MainFrame;

public class SaveManager implements SaveStrategy{
	private SaveStrategy saveStrategy;
	
	public SaveManager(SaveStrategy saveStrategy) {
		this.saveStrategy = saveStrategy;
	}
	
	@Override
	public void save(MainFrame frame, File file) {
		// TODO Auto-generated method stub
		saveStrategy.save(frame, file);
	}
	
}