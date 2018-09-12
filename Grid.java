import processing.core.PApplet;

public class Grid {
	GridElement[][] elements;
	PApplet p;
	
	public Grid(PApplet p){
		this.p = p;
		elements = new GridElement[3][3];
		for(int row=0; row<3; row++){
			for(int column = 0; column<3; column++){
				elements[row][column] = new GridElement(column*p.width/3, row*p.height/6, (column + 1)*p.width/3, (row+1)*p.height/6);
			}
		}
	}
	
	public GridElement getGridBoundaries(int row, int column){
		return elements[row][column];
	}
	
	public int[] getGridPositions(int mouseX, int mouseY){
		int[] xy = new int[2];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int x1 = elements[i][j].x1;
				int x2 = elements[i][j].x2;
				int y1 = elements[i][j].y1;
				int y2 = elements[i][j].y2;
				if(mouseX > x1 && mouseX < x2 && mouseY > y1 && mouseY < y2) {
					xy[0] = i;
					xy[1] = j;
					return xy;
				}
			}
		}
		return xy;
	}
}
