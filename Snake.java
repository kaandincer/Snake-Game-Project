package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.LinkedList;

public class Snake {

	public int xPos;
	public int yPos;
	public int size;
	public LinkedList<Integer> x = new LinkedList<Integer>();
	public LinkedList<Integer> y = new LinkedList<Integer>();
	public int dx;
	public int dy;

	public Snake() {
		size = 3;

		xPos = (int) (Math.random() * 20 + 5);
		yPos = (int) (Math.random() * 20 + 5);

		x.add(xPos);
		x.add(xPos + 1);
		x.add(xPos + 2);

		y.add(yPos);
		y.add(yPos);
		y.add(yPos);

		dx = -1;
		dy = 0;

		StdDraw.setPenColor(Color.GREEN);
		for (int i = 0; i < size; i++) {
			int xx = x.get(i);
			int yy = y.get(i);
			StdDraw.filledPolygon(new double[]{xx - 0.45, xx + 0.45, xx + 0.45, xx - 0.45}, new double[]{yy + 0.45, yy + 0.45, yy - 0.45, yy - 0.45});
		}
	}

	public void turn(boolean up, boolean dn, boolean lt, boolean rt){
		boolean t=false;
		if (!t && up){
			if (dy == 0){
				dx = 0;
				dy = 1;
				t = true;
			}
		}
		if (!t && dn){
			if (dy == 0){
				dx = 0;
				dy = -1;
				t = true;
			}
		}
		if (!t && lt){
			if (dx == 0){
				dx = -1;
				dy = 0;
				t = true;
			}
		}
		if (!t && rt){
			if (dx == 0){
				dx = 1;
				dy = 0;
				t = true;
			}
		}
	}

	public boolean dead(){
		if (coveredNoHead(xPos,yPos) || edged(xPos,yPos)) return true;
		return false;
	}

	public void move(Food f){
		xPos += dx;
		yPos += dy;

		x.addFirst(xPos);
		y.addFirst(yPos);

		if (!(xPos == f.xPos && yPos ==f.yPos)){
			x.remove(size);
			y.remove(size);
		}else{
			size ++;
		}
	}

	public void update(Food f){
		StdDraw.clear();

		move(f);

		StdDraw.setPenColor(Color.GREEN);
		for(int i = 0; i < size; i ++){
			int xx = x.get(i);
			int yy = y.get(i);
			StdDraw.filledPolygon(new double[] {xx-0.45,xx+0.45,xx+0.45,xx-0.45}, new double[] {yy+0.45,yy+0.45,yy-0.45,yy-0.45});
		}
	}

	public boolean covered(int xx, int yy){
		for (int i = 0; i < size ; i ++){
			if (x.get(i) == xx && y.get(i) == yy) return true;
		}
		return false;
	}

	public boolean coveredNoHead(int xx, int yy){
		for (int i = 1; i < size ; i ++){
			if (x.get(i) == xx && y.get(i) == yy) return true;
		}
		return false;
	}

	public boolean edged(int xx, int yy){
		if (xx < 1 || xx > 30 || yy < 1 || yy > 30) return true;
		return false;
	}
}