package view;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import model.LogModel;

@SuppressWarnings("serial")
public class LoggerView extends JPanel {
	private JScrollPane scrollPane;
	
	LogModel model = new LogModel();


	/**
	 * 
	 */
	public LoggerView() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		model.getLoggerList().setModel(model.getDlm());

		scrollPane.setViewportView(model.getLoggerList());


	}

	public LogModel getModel() {
		return model;
	}

	public void setModel(LogModel model) {
		this.model = model;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultListModel<String> getLogs() {
		return this.model.getDlm();
	}


}
