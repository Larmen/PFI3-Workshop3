package se.mah.k3.larmen.com.whackamole;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;

public class Main extends Activity implements OnClickListener, Callback {
    
	private TimerThread t;
	private GameView gameView;
	private Handler handler;
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        gameView = new GameView(this);
        setContentView(gameView);
        
        handler = new Handler(this);
        /*
        Button startButton = (Button) findViewById(R.id.button1);
        startButton.setOnClickListener(this);
        */
        //gameView.setOnClickListener(this);
        //gameView.setOnTouchListener(this);
        t = new TimerThread(handler);
        t.start();
        gameView.setScoreBoardZero();
        
    }

	@Override
	public boolean handleMessage(Message arg0) {
		// TODO Auto-generated method stub
		gameView.updateView();
		
		return false;
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*
		 * if(){
			
		}
		
		gameView.updateView();
		t.setSleepMinus100();
		Log.i("whack", "you clicked in onClick()");
		
		
		*/
		
	}

	public void clickOnMole() {
		// TODO Auto-generated method stub
		gameView.updateView();
		t.setSleepMinus();
		Log.i("whack", "you clicked in onTouch() and clickOnMole()!" + " " + gameView.getScoreBoard());
	}

	public void clickOutsideMole() {
		// TODO Auto-generated method stub
		t.setSleepPlus();
		Log.i("whack", "Main: clickOutsideMole");
	}

	
}