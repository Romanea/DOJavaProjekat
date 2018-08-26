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

import shapes.hexagon.*;
import utilities.ColorChooserButton;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateHexagonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private HexagonAdapter hexagon;
	private JTextField txtForX;
	private JTextField txtForY;
	private JTextField txtForR;
	private JTextField txtToX;
	private JTextField txtToY;
	private JTextField txtToR;
	private JTextField txtBX;
	private JTextField txtBY;
	private JTextField txtBR;
	private JComboBox cmbHexagon;
	private ColorChooserButton btnInteriorColor;
	private ColorChooserButton btnOutlineColor;
	private Color changedOutlineColor;
	private Color changedInteriorColor;

	public UpdateHexagonDialog(HexagonAdapter hexa) {
		hexagon=new HexagonAdapter(hexa.getHexagon(), hexa.getBorderColor(), hexa.getClrInnerColor());
		changedInteriorColor=hexagon.getClrInnerColor();
		changedOutlineColor=hexagon.getBorderColor();
		setTitle("Update Hexagon");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpdate = new JLabel("Update:");
			GridBagConstraints gbc_lblUpdate = new GridBagConstraints();
			gbc_lblUpdate.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpdate.gridx = 1;
			gbc_lblUpdate.gridy = 1;
			contentPanel.add(lblUpdate, gbc_lblUpdate);
		}
		{
			cmbHexagon = new JComboBox();
			GridBagConstraints gbc_cmbHexagon = new GridBagConstraints();
			gbc_cmbHexagon.insets = new Insets(0, 0, 5, 5);
			gbc_cmbHexagon.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbHexagon.gridx = 3;
			gbc_cmbHexagon.gridy = 1;
			contentPanel.add(cmbHexagon, gbc_cmbHexagon);
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
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 5;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 0);
			gbc_lblRadius.gridx = 7;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			JLabel lblMoveFor = new JLabel("Move for:");
			GridBagConstraints gbc_lblMoveFor = new GridBagConstraints();
			gbc_lblMoveFor.insets = new Insets(0, 0, 5, 5);
			gbc_lblMoveFor.gridx = 1;
			gbc_lblMoveFor.gridy = 3;
			contentPanel.add(lblMoveFor, gbc_lblMoveFor);
		}
		{
			txtForX = new JTextField();
			GridBagConstraints gbc_txtForX = new GridBagConstraints();
			gbc_txtForX.anchor = GridBagConstraints.NORTH;
			gbc_txtForX.insets = new Insets(0, 0, 5, 5);
			gbc_txtForX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForX.gridx = 3;
			gbc_txtForX.gridy = 3;
			contentPanel.add(txtForX, gbc_txtForX);
			txtForX.setColumns(10);
		}
		{
			txtForY = new JTextField();
			GridBagConstraints gbc_txtForY = new GridBagConstraints();
			gbc_txtForY.insets = new Insets(0, 0, 5, 5);
			gbc_txtForY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForY.gridx = 5;
			gbc_txtForY.gridy = 3;
			contentPanel.add(txtForY, gbc_txtForY);
			txtForY.setColumns(10);
		}
		{
			txtForR = new JTextField();
			GridBagConstraints gbc_txtForR = new GridBagConstraints();
			gbc_txtForR.insets = new Insets(0, 0, 5, 0);
			gbc_txtForR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForR.gridx = 7;
			gbc_txtForR.gridy = 3;
			contentPanel.add(txtForR, gbc_txtForR);
			txtForR.setColumns(10);
		}
		{
			JLabel lblMoveTo = new JLabel("Move to:");
			GridBagConstraints gbc_lblMoveTo = new GridBagConstraints();
			gbc_lblMoveTo.insets = new Insets(0, 0, 5, 5);
			gbc_lblMoveTo.gridx = 1;
			gbc_lblMoveTo.gridy = 4;
			contentPanel.add(lblMoveTo, gbc_lblMoveTo);
		}
		{
			txtToX = new JTextField();
			GridBagConstraints gbc_txtToX = new GridBagConstraints();
			gbc_txtToX.insets = new Insets(0, 0, 5, 5);
			gbc_txtToX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToX.gridx = 3;
			gbc_txtToX.gridy = 4;
			contentPanel.add(txtToX, gbc_txtToX);
			txtToX.setColumns(10);
		}
		{
			txtToY = new JTextField();
			GridBagConstraints gbc_txtToY = new GridBagConstraints();
			gbc_txtToY.insets = new Insets(0, 0, 5, 5);
			gbc_txtToY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToY.gridx = 5;
			gbc_txtToY.gridy = 4;
			contentPanel.add(txtToY, gbc_txtToY);
			txtToY.setColumns(10);
		}
		{
			txtToR = new JTextField();
			GridBagConstraints gbc_txtToR = new GridBagConstraints();
			gbc_txtToR.insets = new Insets(0, 0, 5, 0);
			gbc_txtToR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToR.gridx = 7;
			gbc_txtToR.gridy = 4;
			contentPanel.add(txtToR, gbc_txtToR);
			txtToR.setColumns(10);
		}
		{
			JLabel lblBasicUpdate = new JLabel("Basic update:");
			GridBagConstraints gbc_lblBasicUpdate = new GridBagConstraints();
			gbc_lblBasicUpdate.insets = new Insets(0, 0, 5, 5);
			gbc_lblBasicUpdate.gridx = 1;
			gbc_lblBasicUpdate.gridy = 5;
			contentPanel.add(lblBasicUpdate, gbc_lblBasicUpdate);
		}
		{
			txtBX = new JTextField();
			GridBagConstraints gbc_txtBX = new GridBagConstraints();
			gbc_txtBX.insets = new Insets(0, 0, 5, 5);
			gbc_txtBX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBX.gridx = 3;
			gbc_txtBX.gridy = 5;
			contentPanel.add(txtBX, gbc_txtBX);
			txtBX.setColumns(10);
		}
		{
			txtBY = new JTextField();
			GridBagConstraints gbc_txtBY = new GridBagConstraints();
			gbc_txtBY.insets = new Insets(0, 0, 5, 5);
			gbc_txtBY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBY.gridx = 5;
			gbc_txtBY.gridy = 5;
			contentPanel.add(txtBY, gbc_txtBY);
			txtBY.setColumns(10);
		}
		{
			txtBR = new JTextField();
			GridBagConstraints gbc_txtBR = new GridBagConstraints();
			gbc_txtBR.insets = new Insets(0, 0, 5, 0);
			gbc_txtBR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBR.gridx = 7;
			gbc_txtBR.gridy = 5;
			contentPanel.add(txtBR, gbc_txtBR);
			txtBR.setColumns(10);
		}
		{
			JLabel lblColors = new JLabel("Colors:");
			GridBagConstraints gbc_lblColors = new GridBagConstraints();
			gbc_lblColors.insets = new Insets(0, 0, 0, 5);
			gbc_lblColors.gridx = 1;
			gbc_lblColors.gridy = 6;
			contentPanel.add(lblColors, gbc_lblColors);
		}
		{
			 btnOutlineColor = new ColorChooserButton(changedOutlineColor);
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnOutlineColor.gridx = 3;
			gbc_btnOutlineColor.gridy = 6;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			btnInteriorColor = new ColorChooserButton(changedInteriorColor);
			GridBagConstraints gbc_btnInteriorColor = new GridBagConstraints();
			gbc_btnInteriorColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnInteriorColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInteriorColor.gridx = 5;
			gbc_btnInteriorColor.gridy = 6;
			contentPanel.add(btnInteriorColor, gbc_btnInteriorColor);
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
						
						if(cmbHexagon.getSelectedItem().toString().equals("Move for") && (txtForX.getText().isEmpty() || txtForY.getText().isEmpty()) ) {
						
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
							
						} else if(cmbHexagon.getSelectedItem().toString().equals("Move to") && (txtToX.getText().isEmpty() || txtToY.getText().isEmpty())){
							JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
									JOptionPane.WARNING_MESSAGE);
						} else if(cmbHexagon.getSelectedItem().toString().equals("Basic update") && (txtBX.getText().isEmpty() || txtBY.getText().isEmpty() || txtBR.getText().isEmpty())) {
							
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
								
								if (cmbHexagon.getSelectedItem().toString().equals("Basic update")) {
									hexagon.getHexagon().setX(Integer.parseInt(txtBX.getText()));
									hexagon.getHexagon().setY(Integer.parseInt(txtBY.getText()));
									hexagon.getHexagon().setR(Integer.parseInt(txtBR.getText()));
									
								}

								if (cmbHexagon.getSelectedItem().toString().equals("Move for")) {
									hexagon.moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
		
								} 
								
								if (cmbHexagon.getSelectedItem().toString().equals("Move to")) {
									hexagon.moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
		
								}
								
								hexagon.getHexagon().setBorderColor(btnOutlineColor.getSelectedColor());
								hexagon.getHexagon().setAreaColor(btnInteriorColor.getSelectedColor());
								

								
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
		
		cmbHexagon.setModel(new DefaultComboBoxModel(new String[] {"Basic update", "Move to", "Move for"}));
		txtForX.setEditable(false);
		txtForY.setEditable(false);
		txtBX.setEditable(true);
		txtBY.setEditable(true);
		txtBR.setEditable(true);
		txtForR.setEditable(false);
		txtToR.setEditable(false);
		txtToX.setEditable(false);
		txtToY.setEditable(false);
		
		txtToX.setText(String.valueOf(hexagon.getHexagon().getX()));
		txtToY.setText(String.valueOf(hexagon.getHexagon().getY()));
		txtToR.setText(String.valueOf(hexagon.getHexagon().getR()));
		txtForX.setText(String.valueOf(hexagon.getHexagon().getX()));
		txtForY.setText(String.valueOf(hexagon.getHexagon().getY()));
		txtForR.setText(String.valueOf(hexagon.getHexagon().getR()));
		txtBX.setText(String.valueOf(hexagon.getHexagon().getX()));
		txtBY.setText(String.valueOf(hexagon.getHexagon().getY()));
		txtBR.setText(String.valueOf(hexagon.getHexagon().getR()));
		
	
		
		cmbHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbHexagon.getSelectedItem().toString().equals("Move for")) {
					txtToX.setEditable(false);
					txtToY.setEditable(false);
					txtBX.setEditable(false);
					txtBY.setEditable(false);
					txtForX.setEditable(true);
					txtForY.setEditable(true);
					txtBR.setEditable(false);
					txtForR.setEditable(false);
					txtToR.setEditable(false);
				} else if(cmbHexagon.getSelectedItem().toString().equals("Move to")){
					txtToX.setEditable(true);
					txtToY.setEditable(true);
					txtBX.setEditable(false);
					txtBY.setEditable(false);
					txtForX.setEditable(false);
					txtForY.setEditable(false);
					txtBR.setEditable(false);
					txtForR.setEditable(false);
					txtToR.setEditable(false);
				} else {
				
					txtToX.setEditable(false);
					txtToY.setEditable(false);
					txtBX.setEditable(true);
					txtBY.setEditable(true);
					txtForX.setEditable(false);
					txtForY.setEditable(false);
					txtBR.setEditable(true);
					txtForR.setEditable(false);
					txtToR.setEditable(false);
				}
				
				
			}
		});
		
	
		
		pack();
		setVisible(true);
	}



	public HexagonAdapter getHexagon() {
		return hexagon;
	}
	public void cancel() {
		hexagon = null;
	}

}
