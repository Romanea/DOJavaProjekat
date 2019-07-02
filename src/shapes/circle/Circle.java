package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import shapes.FilledShape;
import shapes.Moveable;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends FilledShape implements Moveable, Serializable{
	private Point center;
	private int r;
	
	public Circle()
	{

	}
	public Circle(Point center, int r)
	{
		this.center = center;
		this.r = r;
	}
	public Circle(Point center, int r, String color)
	{
		this(center, r);
		setColor(color);
	}
	
	public Circle(Point center, int r, Color borderColor, Color clrInnerColor)
	{
		this(center, r);
		setBorderColor(borderColor);
		setClrInnerColor(clrInnerColor);
	}
	
	public String toString()
	{
		return "Circle: (" + this.center.getX() + "," + this.center.getY() + "); radius:" + this.r + "; outer color:" + getBorderColor().getRGB() + "; inside color:" + Integer.toString(getClrInnerColor().getRGB());
	}
	public void draw(Graphics g)
	{
		g.setColor(getBorderColor());
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r*2);
		this.fill(g);
		if(isSelected())
			selected(g);
	}
	public boolean contains(int x, int y)
	{
		Point clickPoint = new Point(x, y);
		if(clickPoint.distance(center)<=r)
			return true;
		else
			return false;
	}
	public void selected(Graphics g) 
	{
		g.setColor(Color.BLUE);
		new Line(new Point(center.getX(), center.getY()-r), new Point(center.getX(), center.getY() + r)).selected(g);
		new Line(new Point(center.getX()-r, center.getY()), new Point(center.getX()+r, center.getY())).selected(g);
	
	}
	public void fill(Graphics g)
	{
		g.setColor(getClrInnerColor());
		g.fillOval(center.getX()-r+1, center.getY()-r+1, 2*r-2, r*2-2);
		
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Circle)
		{
			Circle helper=(Circle)obj;
			if(this.center.equals(helper.center) && this.r==helper.r)
				return true;
			else
				return false;
		}
		else
			return false;	
	}
	

	public void moveTo(int x, int y){
		center.setX(x);
		center.setY(y);
	}
	public void moveBy(int x, int y){
		center.setX(center.getX()+x);
		center.setY(center.getY()+y);
	}
	public double area(){
		return r * r * Math.PI;
	}
	public double perimeter(){
		return 2 * r * Math.PI;
	}
	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle pomocni  = (Circle) o;
			return this.r - pomocni.r;
		}
		else
			return -1;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}


}
