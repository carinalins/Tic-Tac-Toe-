//week 1 - semester 2
//setting up game TIC TAC TOE
//@carinalins (:

import processing.core.PApplet;

public class GameTicTacToe extends PApplet{

	GameBoard board;



	public static void main(String[] args) {
		PApplet.main("GameTicTacToe");

		
		

	}

	public void settings(){
		//size(displayWidth/4, displayHeight/2);
		size(1000,500);

	}

	public void setUp(){
		board = new GameBoard(this);
	}

	public void draw(){
		background(0);
		stroke(255,0,0);
		noFill();
		ellipse(width/2,height/2,50,50);
		/*stroke(255,0,0);
		noFill();
		line(width/3, 0, width/3, height/2);
		line(2*width/3, 0, 2*width/3, height/2);
		line(0, height/6, width, height/6);
		line(0, 2*height/6, width, 2*height/6);*/
		board.showThis();
	}
}