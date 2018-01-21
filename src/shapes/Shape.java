package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable<Object>{
	private String strColor = "crna";
	private Color borderColor = Color.BLACK; 
	private boolean selected;
	
	public Shape() {
		
	}
	public Shape(String boja){
		this.strColor = boja;
	}
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	
	
	
	public String getColor() {
		return strColor;
	}

	public void setColor(String color) {
		this.strColor = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	
}
