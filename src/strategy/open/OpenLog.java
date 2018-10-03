package strategy.open;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import app.*;
import model.ShapeModel;

public class OpenLog implements OpenStrategy {

	private LogDecoder decodingLog = new LogDecoder();
	@Override
	public void open(ShapeModel drawingModel, MainFrame drawingFrame, File file)  {
		String line = null;
		 try {
	    
	            FileReader fileReader = new FileReader(file);

	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            drawingFrame.getCanvasController().makeNewDrawing();

	            
	            while((line = bufferedReader.readLine()) != null) {

	            	System.out.println(line);
	            	drawingModel.getLogList().add(line);
	            }   


	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" + file + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println("Error reading file '" + file + "'");                  
	            ex.printStackTrace();
	        }
		
	}

}