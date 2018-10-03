package shapes.observer;

import view.ToolsView;

public class ButtonObserver implements Observer {
	
	private ToolsView toolsView;

	public ButtonObserver(ToolsView toolsView) {
		this.toolsView = toolsView;
	}
	
	@Override
	public void update(int numberOfSelectedShapes) {
		System.out.println("Number of selected in button observer: " + numberOfSelectedShapes);
		if (numberOfSelectedShapes >= 1) {
			toolsView.getBtnDeleteAll().setEnabled(false);
			toolsView.getBtnDelete().setEnabled(true);
			toolsView.getBtnModify().setEnabled(true);
			toolsView.getBtnBringToBack().setEnabled(true);
			toolsView.getBtnBringToFront().setEnabled(true);
			toolsView.getBtnSendToBack().setEnabled(true);
			toolsView.getBtnSendToFront().setEnabled(true);
		}
		if(numberOfSelectedShapes == 0) {
			toolsView.getBtnDelete().setEnabled(false);
			toolsView.getBtnModify().setEnabled(false);
			toolsView.getBtnDeleteAll().setEnabled(true);
			toolsView.getBtnBringToBack().setEnabled(false);
			toolsView.getBtnBringToFront().setEnabled(false);
			toolsView.getBtnSendToBack().setEnabled(false);
			toolsView.getBtnSendToFront().setEnabled(false);
		}
		
	}

}
