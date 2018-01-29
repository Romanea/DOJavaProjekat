package controller;

import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import app.MainFrame;
import shapes.Shape;
import view.ToolsView;

public class ToolsController {

	private ToolsView toolsView;
	private MainFrame frame;
	

	public ToolsController(MainFrame frame) {
		this.toolsView = frame.getToolsView();
		this.frame=frame;
	}


	public void handleSelection(MouseEvent e) {
		if( frame.getView().getModel().getShapes().size() ==0 && toolsView.getTglbtnSelect().isSelected())
		{
			JOptionPane.showMessageDialog(null, "No elements to select!");
			toolsView.getTglbtnSelect().setSelected(false);
		}
		else
		{
			for(int i = frame.getView().getModel().getShapes().size()-1;i>=0;i--)
			{
				if(frame.getView().getModel().getShape(i).contains(e.getX(), e.getY()))
				{
					frame.getView().getModel().getShape(i).setSelected(true);
					frame.getOptionsView().setEnabled(false);
					toolsView.getBtnDelete().setEnabled(true);
					toolsView.getBtnDelete().setEnabled(true);
					toolsView.getBtnModify().setEnabled(true);
					frame.getView().repaint();
					break;
				}
			}
		}
		
	}


	public void handeDeselection() {
		Iterator<Shape> it = frame.getView().getModel().getShapes().iterator();
		while (it.hasNext()) it.next().setSelected(false);
		frame.getOptionsView().setEnabled(true);
		toolsView.getBtnDelete().setEnabled(true);
		toolsView.getBtnModify().setEnabled(true);
		frame.getView().repaint();
		
	}
	
	
	
	
	
	
	
	
}
