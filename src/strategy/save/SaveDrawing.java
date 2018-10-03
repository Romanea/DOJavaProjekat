package strategy.save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import app.MainFrame;

public class SaveDrawing implements SaveStrategy {
	
	@Override
	public void save(MainFrame drawingFrame, File file) {

		try {
		
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
			save.writeObject(drawingFrame.getView().getModel().getShapes());
			
			save.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
