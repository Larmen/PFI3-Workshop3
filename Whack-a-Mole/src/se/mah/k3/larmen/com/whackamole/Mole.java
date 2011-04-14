package se.mah.k3.larmen.com.whackamole;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Mole {

	int posX;
	int posY;
	boolean isShowing;
	int timer;
	private Paint paint;
	private int radius = 30;
	
	public Mole() {
		
		
		// TODO Auto-generated constructor stub
		//this.setText("");
		Log.i("whack", "Mole constructor logged");
		
		paint = new Paint();		
		paint.setColor(Color.CYAN);
		
		
		
	}
	
	public Paint getPaint(){		
		return paint;
		}
	
	public int getPosX(){		
		return posX;
	}
	
	public int getPosY(){		
		return posY;		
	}
	
	public void setPosX(){		
		posX = radius + (int) (Math.random()*(480 - radius*2));
	}
	public void setPosY(){		
		posY = radius + (int) (Math.random()*(800 - radius*2));
		
	}

	public int getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	

}
