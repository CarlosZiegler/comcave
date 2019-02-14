package malegut;
/**
 * 
 * Klasse Triangle zeichnet ein Dreick mit hilfe der 
 * Graphics-Methode drawPolygon()
 * 
 * Methode:
 * dreieck entsteht in einem imaginären rechteck.
 * startpunkt nach unten links gesetzt,
 * zielpunkt gleich zielpunkt,
 * die spitze des dreiecks befindet sich von startpunkt auf der x-achse
 * um die hälfte der weite des rechtecks verschoben wieder.
 *
 */

public class Triangle {

	public int[] xPoints;
	public int[] yPoints;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public Triangle(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.xPoints = new int[3];
		this.yPoints = new int[3];
		
	}
	public void setPoints(int x1, int y1, int x2 , int y2){
		this.xPoints[0]=x1;
		this.xPoints[1]=x2;
		this.xPoints[2]=x1+(x2-x1)/2;
		this.yPoints[0]= y2;
		this.yPoints[1]= y2;
		this.yPoints[2]= y1;
	}
}
