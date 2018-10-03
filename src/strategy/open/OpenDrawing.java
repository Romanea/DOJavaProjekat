package strategy.open;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import app.MainFrame;
import model.ShapeModel;
import shapes.Shape;

public class OpenDrawing implements OpenStrategy{
	@SuppressWarnings("unchecked")
	@Override
	public void open(ShapeModel drawingModel, MainFrame drawingFrame, File file) {
		
		
		try {
			FileInputStream in=new FileInputStream(file);
			ObjectInputStream o=new ObjectInputStream(in);
			
		    drawingFrame.getCanvasController().makeNewDrawing();
			drawingModel.getShapes().addAll((ArrayList<Shape>)o.readObject());
		
			
			
			o.close();
		        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
