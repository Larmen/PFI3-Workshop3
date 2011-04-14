package se.mah.k3.larmen.com.whackamole;

import android.os.Handler;
import android.util.Log;

public class TimerThread extends Thread {

	private Handler _mainHandler;
	private boolean _running = true;
	private int sleepDuration = 1000;
	
	public void stopCount(){		
		_running = false;		
	}
	
	public TimerThread(Handler mainHandler){
		_mainHandler = mainHandler;
	}
	
	@Override
	public void run(){
		super.run();
		while(_running){
			try{
				//Log.i("whack", "Thread running");
				_mainHandler.sendEmptyMessage(NORM_PRIORITY);
				Thread.sleep(sleepDuration);
			}	catch (InterruptedException e) {
				Log.i("whack", e.getMessage());
			}	
		}
		
	}
	
	public void setSleepMinus(){
		
		sleepDuration = sleepDuration - 40;
		
	}

	public void setSleepPlus() {
		// TODO Auto-generated method stub
		sleepDuration = sleepDuration + 40;
	}
}
