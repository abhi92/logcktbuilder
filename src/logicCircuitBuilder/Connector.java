package logicCircuitBuilder;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

/**Abstract Class for input and output connectors
 * @author vega
 *
 */
public abstract class Connector {
	ArrayList<Connection> cons;
	Device device;
	int x,y;
	Color c;
	Polygon poly;
	public static final int w=15,h=10;

	public Connector(int x,int y,Color c, Device device) {
		this.device=device;
		this.c=c;
		this.x=x;
		this.y=y;
		poly= new Polygon();
		poly.addPoint(x,y);
		poly.addPoint(x+w,y+h/2);
		poly.addPoint(x,y+h);
		cons=new ArrayList<Connection>();
	}
	public boolean contains(Point p){
		return (poly.contains(p));
	}
	public void addConnection(Connection c)
	{
		cons.add(c);
	}
	public void paintConnector(Device owner,Graphics2D g2d){
		g2d.setColor(c);
		g2d.fill(poly);
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return device.getX()+ x+5;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return device.getY()+ y+5;
	}



}
