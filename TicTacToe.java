import processing.core.PApplet;
import processing.core.PFont;


public class TicTacToe extends PApplet{
	Board gameBoard;
	Player x;
	Player o;
	Player currentPlayer;
	PlayerData playerData;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("TicTacToe");
		
	}
	
	public void settings(){
		size(displayWidth/4, displayHeight/2);
		x = new Player("Player X", 1);
		o = new Player("Player O", -1);
	}
	
	public void setup(){
		background(200,100,5);
		gameBoard = new Board(this);
		currentPlayer = x;
		PFont f = createFont("Arial", 16, true);
		
		playerData = new PlayerData(100, 5*height/8, this, f);
		
	}
	
	public void draw(){
		gameBoard.show();
		
	}
	
	public void mousePressed(){
		background(200,100,5);
		if(gameBoard.allowedMove(mouseX, mouseY)){
			gameBoard.makeMove(mouseX, mouseY, currentPlayer);
			if(gameBoard.isWon()) {
				playerData.setData("Winner: " + currentPlayer.name + "  score: " + currentPlayer.score);
				currentPlayer.score++;
			} else if(gameBoard.isDraw()){
				playerData.setData("No more moves");
			}
			else {
				swapPlayers();
				playerData.setData("Your turn " + currentPlayer.name);
			}
		}
	}
	
	public void swapPlayers(){
		System.out.println("Swapping players " + currentPlayer.name);
		if(currentPlayer == x){
			currentPlayer = o;
		} else {
			currentPlayer = x;
		}
	}

}
