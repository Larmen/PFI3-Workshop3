package se.mah.k3.larmen.com.whackamole;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
//import android.view.View.OnTouchListener;

public class GameView extends View{
	
	public boolean showing;
	private Mole mole;
	private int scoreBoard;
	private int scoreGoal = 15;
	private Main parent;
	private Paint textPaint;
	private boolean playing;
	
	
	
	
	public GameView(Context context) {
		super(context);
		mole = new Mole();
		parent = (Main) context;
		textPaint = new Paint();
		textPaint.setColor(Color.CYAN);
		playing = true;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//Game is alive!
		if(scoreBoard < scoreGoal){
			playing = true;
			canvas.drawText(Integer.toString(scoreBoard) + " / " + Integer.toString(scoreGoal), 10, 10, textPaint);
				if(!showing){
				canvas.drawCircle(mole.getPosX(), mole.getPosY(), mole.getRadius()*2, mole.getPaint());
		//Log.i("whack", "OnDRAW!");
		
				} 
		}else{
			
			canvas.drawText(Integer.toString(scoreBoard) + " / " + Integer.toString(scoreGoal), 10, 10, textPaint);
			canvas.drawText("You killed "+ Integer.toString(scoreGoal)+ " innocent child moles. How could you?", 100, 400, textPaint);
			canvas.drawText("(Tap to restart)", 200, 500, textPaint);
			playing = false;
		}
	}

	public void updateView() {
		// TODO Auto-generated method stub
		switchShowing();
		mole.setPosX();
		mole.setPosY();
		this.invalidate();
		
		
	}
	
	private void switchShowing(){
		//Switches the boolean
		showing = !showing;
	}
	
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		if(playing){
		if((event.getX() < (mole.getPosX()+mole.getRadius())) && 
				(event.getX() > (mole.getPosX()- mole.getRadius()) )
				&& event.getY() < (mole.getPosY()+mole.getRadius())
				&& event.getY() > (mole.getPosY()-mole.getRadius())){
			
			scoreBoard += 1;
			Log.i("whack", "you clicked in onTouch()!" + " " + scoreBoard);
			parent.clickOnMole();
			
			
			
		}else{
			scoreBoard -= 1;
			Log.i("whack", "you clicked outside dumbass" + " " + scoreBoard);
			parent.clickOutsideMole();
		}
	
		}else if(!playing){
			
			setScoreBoardZero();
			parent.sleepDurationReset();
			playing = true;
			
		}
		
		return super.onTouchEvent(event);
	}

	public void setScoreBoardZero() {
		// TODO Auto-generated method stub
		scoreBoard = 0;
	}

	public int getScoreBoard() {
		// TODO Auto-generated method stub
		return scoreBoard;
	}
	
}
