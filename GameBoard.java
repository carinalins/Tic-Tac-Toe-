//week 1 - semester 2
//setting up game BOARD
//@carinalins (:


import processing.core.PApplet;

public class GameBoard{

	int[][] elements;
	PApplet parent;
	int moves;

	public GameBoard(PApplet p){
		parent = p;
		this.moves = 0;
		this.elements = new int[3][3];
	}

	public void showThis(){
		// set & draw the grid itself
		parent.stroke(255,255,0);
		parent.noFill();
		parent.line(parent.width/3, 0, parent.width/3, parent.height/2);
		parent.line(2*parent.width/3, 0, 2*parent.width/3, parent.height/2);
		parent.line(0, parent.height/6, parent.width, parent.height/6);
		parent.line(0, 2*parent.height/6, parent.width, 2*parent.height/6);
		
		//parent.fill(200,50,150);
		//parent.rect(100,100,50,50);

	}


}