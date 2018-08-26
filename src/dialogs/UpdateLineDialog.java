package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.line.Line;
import shapes.point.Point;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateLineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Line line;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	private JComboBox cmbLine;
	private JButton btnOutlineColor;
	private Color changedOutlineColor;
	
	public UpdateLineDialog(Line ln) {
		setTitle("Update line");
		line=new Line(ln.getpStart(), ln.getpEnd(), ln.getBorderColor());
		changedOutlineColor=line.getBorderColor();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMove = new JLabel("Move:");
			GridBagConstraints gbc_lblMove = new GridBagConstraints();
			gbc_lblMove.insets = new Insets(0, 0, 5, 5);
			gbc_lblMove.gridx = 1;
			gbc_lblMove.gridy = 1;
			contentPanel.add(lblMove, gbc_lblMove);
		}
		{
			cmbLine = new JComboBox();
			cmbLine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cmbLine.getSelectedItem().toString().equals("For")) {
						txtStartX.setEditable(false);
						txtStartY.setEditable(false);
						txtEndX.setEditable(false);
						txtEndY.setEditable(false);
						txtX.setEditable(true);
						txtY.setEditable(true);
					} else {
						txtX.setEditable(false);
						txtY.setEditable(false);
						txtStartX.setEditable(true);
						txtStartY.setEditable(true);
						txtEndX.setEditable(true);
						txtEndY.setEditable(true);
					}
					
					
				}
			});
			
			GridBagConstraints gbc_cmbLine = new GridBagConstraints();
			gbc_cmbLine.insets = new Insets(0, 0, 5, 5);
			gbc_cmbLine.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbLine.gridx = 3;
			gbc_cmbLine.gridy = 1;
			contentPanel.add(cmbLine, gbc_cmbLine);
		}
		{
			JLabel lblCoordinateX = new JLabel("Coordinate X:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 3;
			gbc_lblCoordinateX.gridy = 2;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Y:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 0);
			gbc_lblCoordinateY.gridx = 4;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			JLabel lblMoveFor = new JLabel("Move for: ");
			GridBagConstraints gbc_lblMoveFor = new GridBagConstraints();
			gbc_lblMoveFor.insets = new Insets(0, 0, 5, 5);
			gbc_lblMoveFor.gridx = 1;
			gbc_lblMoveFor.gridy = 3;
			contentPanel.add(lblMoveFor, gbc_lblMoveFor);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.anchor = GridBagConstraints.NORTH;
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 3;
			gbc_txtX.gridy = 3;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 4;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblStartPoint = new JLabel("Start point:");
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 1;
			gbc_lblStartPoint.gridy = 4;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			txtStartX = new JTextField();
			GridBagConstraints gbc_txtStartX = new GridBagConstraints();
			gbc_txtStartX.insets = new Insets(0, 0, 5, 5);
			gbc_txtStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartX.gridx = 3;
			gbc_txtStartX.gridy = 4;
			contentPanel.add(txtStartX, gbc_txtStartX);
			txtStartX.setColumns(10);
		}
		{
			txtStartY = new JTextField();
			GridBagConstraints gbc_txtStartY = new GridBagConstraints();
			gbc_txtStartY.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartY.gridx = 4;
			gbc_txtStartY.gridy = 4;
			contentPanel.add(txtStartY, gbc_txtStartY);
			txtStartY.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End point:");
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 1;
			gbc_lblEndPoint.gridy = 5;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			txtEndX = new JTextField();
			GridBagConstraints gbc_txtEndX = new GridBagConstraints();
			gbc_txtEndX.insets = new Insets(0, 0, 5, 5);
			gbc_txtEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndX.gridx = 3;
			gbc_txtEndX.gridy = 5;
			contentPanel.add(txtEndX, gbc_txtEndX);
			txtEndX.setColumns(10);
		}
		{
			txtEndY = new JTextField();
			GridBagConstraints gbc_txtEndY = new GridBagConstraints();
			gbc_txtEndY.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndY.gridx = 4;
			gbc_txtEndY.gridy = 5;
			contentPanel.add(txtEndY, gbc_txtEndY);
			txtEndY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 6;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnOutlineColor = new JButton("Outline color");
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnOutlineColor.gridx = 3;
			gbc_btnOutlineColor.gridy = 6;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						if(cmbLine.getSelectedItem().toString().equals("For") && (txtX.getText().isEmpty() || txtY.getText().isEmpty()) ) {
						
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
							
						} else if(cmbLine.getSelectedItem().toString().equals("Basic update") && (txtStartX.getText().isEmpty() || txtStartY.getText().isEmpty() || txtEndX.getText().isEmpty() || txtEndY.getText().isEmpty())) {
							
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
						} 
						else {
							try {
							
							Object[] option = { "Yes", "No" };
							int answer = JOptionPane.showOptionDialog(null,
									"Are you sure that you want to update this object?",
									"Choose one option:", JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
							if (answer == 0) {

								if (cmbLine.getSelectedItem().toString().equals("Basic update")) {
									line.getpStart().setX(Integer.parseInt(txtStartX.getText()));
									line.getpStart().setY(Integer.parseInt(txtStartY.getText()));
									line.getpEnd().setX(Integer.parseInt(txtEndX.getText()));
									line.getpEnd().setY(Integer.parseInt(txtEndY.getText()));
									System.out.println(line);
									
								}

								if (cmbLine.getSelectedItem().toString().equals("For")) {
									line.moveBy(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
		
								}
								line.setBorderColor(changedOutlineColor);
								setVisible(false);
							}
							
							}
							catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Only numbers are allowed!", "Error",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int answer = JOptionPane.showConfirmDialog(null, "Are you sure that you want to cancel?",
								"Choose one option:",
								JOptionPane.INFORMATION_MESSAGE);
						if (answer == JOptionPane.OK_OPTION) {
							setVisible(false);
							cancel();
							dispose();
						}

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cmbLine.setModel(new DefaultComboBoxModel(new String[] { "For", "Basic update" }));
		txtStartX.setEditable(false);
		txtStartY.setEditable(false);
		txtEndX.setEditable(false);
		txtEndY.setEditable(false);
		
		txtStartX.setText(String.valueOf(this.line.getpStart().getX()));
		txtStartY.setText(String.valueOf(this.line.getpStart().getY()));
		txtEndX.setText(String.valueOf(this.line.getpEnd().getX()));
		txtEndY.setText(String.valueOf(this.line.getpEnd().getY()));
		btnOutlineColor.setBackground(line.getBorderColor());
	
		btnOutlineColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Choose color: ",changedOutlineColor);
				if(newColor!=null) {
					if(newColor==Color.BLACK) {
						btnOutlineColor.setForeground(Color.WHITE);	
		         	} else {
		         		btnOutlineColor.setForeground(Color.BLACK);	
		         	}
		     	   btnOutlineColor.setBackground(newColor);
		     	  changedOutlineColor=newColor;
				}
			}
		});
	
		//pack();
		setVisible(true);
		
	}

	public Line getLine() {
		return line;
	}
	
	public void cancel() {
		line = null;
	}

}
