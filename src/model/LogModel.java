package model;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class LogModel {

	private static JList<String> lstLogger;
	private DefaultListModel<String> dlm;
	
	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
		if (dlm != null) {
			lstLogger.setModel(dlm);
		}
	}
	
	public JList<String> getLoggerList(){
		return lstLogger;
	}
	
	public void setLoggerList(JList<String> lst) {
		this.lstLogger = lst;
	}
	
}
