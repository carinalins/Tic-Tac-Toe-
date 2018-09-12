import processing.core.PApplet;

public class Board {
	int[][] elements;
	PApplet parent;
	Grid boardGrid;
	int moves;
	
	public Board(PApplet p){
		boardGrid = new Grid(p);			// takes care of maths of board
		elements = new int[3][3];			// takes care of contents of board
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				elements[i][j] = 0;
			}
		}
		parent = p;
		moves = 0;
	}
	
	public boolean allowedMove(int mX, int mY){
		int [] positions = boardGrid.getGridPositions(mX, mY);
		return elements[positions[0]][positions[1]] == 0;
	}
	
	public void makeMove(int mX, int mY, Player player){
		int[] pos = boardGrid.getGridPositions(mX, mY);
		elements[pos[0]][pos[1]] = player.number;
		moves++;
	}
	
	public void show(){
		// set & draw the grid itself
		parent.stroke(0);
		parent.line(parent.width/3, 0, parent.width/3, parent.height/2);
		parent.line(2*parent.width/3, 0, 2*parent.width/3, parent.height/2);
		parent.line(0, parent.height/6, parent.width, parent.height/6);
		parent.line(0, 2*parent.height/6, parent.width, 2*parent.height/6);
		// border
		parent.noFill();
		parent.strokeWeight(4);
		parent.rectMode(parent.CENTER);
		parent.rect(parent.width/2, parent.height/4, parent.width, parent.height/2);
		parent.strokeWeight(1);
		
		// elements in board
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				switch (elements[i][j]){
				case 1:
					// print X
					showX(i,j);
					break;
				case -1:
					// print y
					showO(i,j);
				}
			}
		}
	}
	
	public void showX(int row, int column){
		GridElement g = boardGrid.getGridBoundaries(row, column);
		double x1 = 0.2*(g.x2 - g.x1) + g.x1;
		double x2 = 0.8*(g.x2 - g.x1)+ g.x1;
		double y1 = 0.2*(g.y2 - g.y1) + g.y1;
		double y2 = 0.8*(g.y2 - g.y1) + g.y1;
		parent.line((float)x1, (float)y1, (float)x2, (float)y2);
		parent.line((float)x2, (float)y1, (float)x1, (float)y2);
		
	}
	
	public void showO(int row, int column){
		GridElement g = boardGrid.getGridBoundaries(row, column);
		int centreX = (g.x2 - g.x1) / 2 + g.x1;
		int centreY = (g.y2 - g.y1) / 2 + g.y1;
		int width = g.x2 - g.x1;
		int height = g.y2 - g.y1;
		parent.ellipse((float)centreX, (float)centreY, (float)0.8*width, (float)0.8*height);
	}
	
	public void clear(){
		for(int i=0; i< 3; i++){
			for(int j=0; j<3; j++){
				elements[i][j] = 0;
			}
		}
	}
	
	public boolean isDraw(){
		return moves == 9;
	}
	
	public boolean isWon(){
		for(int i = 0; i < 3; i++){
			if(elements[i][0] + elements[i][1] + elements[i][2] == 3 || elements[i][0] + elements[i][1] + elements[i][2] == -3){
				return true;
			}
			if(elements[0][i] + elements[1][i] + elements[2][i] == 3 || elements[0][i] + elements[1][i] + elements[2][i] == -3){
				return true;
			}
		}
		if(elements[0][0] + elements[1][1] + elements[2][2] == 3 || elements[0][0] + elements[1][1] + elements[2][2] == -3){
			return true;
		}
		if(elements[0][2] + elements[1][1] + elements[2][0] == 3 || elements[0][2] + elements[1][1] + elements[2][0] == -3){
			return true;
		}
		return false;
	}
}
