package strategy.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import app.MainFrame;

public class SaveLog implements SaveStrategy {

	@Override
	public void save(MainFrame drawingFrame, File file) {
		
		try {
			
			FileWriter fileWriter = new FileWriter(file);
			for(int i = 0; i < drawingFrame.getLogView().getLogs().size(); i++)
			{
				fileWriter.write(drawingFrame.getLogView().getLogs().getElementAt(i) + System.getProperty( "line.separator" ));
				
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
