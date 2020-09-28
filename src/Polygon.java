import java.util.ArrayList;
import java.util.Collections;

public class Polygon implements Comparable<Polygon>  {
	
	int X;
	int Y;
	int area =X*Y;
	
	
	@Override
	public int compareTo(Polygon o) {
		
		return this.getArea()-o.getArea();
								
	}
	
	
	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
		this.area = area;
	}


	
	
	public static void main (String[]args) {
		
		Polygon p=new Polygon();
		p.setArea(4);
		
		Polygon p2=new Polygon();
		p2.setArea(2);
		
		Polygon p3=new Polygon();
		p3.setArea(1);
		
		ArrayList<Polygon> pall=new ArrayList<Polygon>();
		
		pall.add(p);
		pall.add(p2);
		pall.add(p3);
		
		Collections.sort(pall);
		
		for(Polygon rr:pall) {
			System.out.println(rr.getArea());
		}
		
	}
}
