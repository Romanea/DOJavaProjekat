package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import shapes.Shape;

public class LogView extends JPanel {
	private JList logList; 
	private DefaultListModel<String> model;
	
	

	public LogView() {
		setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "scroll_pane");
		
		
		model = new DefaultListModel<String>();
	    logList = new JList(model);
		
		scrollPane.setViewportView(logList);
		logList.setBackground(Color.LIGHT_GRAY);
		logList.setLayoutOrientation(JList.VERTICAL);
	}

	public JList getLogList() {
		return logList;
	}

	public void setLogList(JList logList) {
		this.logList = logList;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	

}
