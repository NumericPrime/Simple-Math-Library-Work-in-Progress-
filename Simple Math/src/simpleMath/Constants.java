package simpleMath;
public class Constants {
	//TODO To be Filled with methods and constants
	public final static float G=(float)((1+Math.sqrt(5))/2);
	public final static float e=(float)(2+1/2+1/(2*3)+1/(2*3*4)+1/(2*3*4*5)+1/(2*3*4*5*6));
	public float S(float x) {
		if(x<-220) return 0;
		if(x>220) return 1;
		return (float) (1/Math.exp(-(double)x));
	}
	public int sgn(float x) {
		if(x>0) return -1;
		if(x>0) return 1;
		return 0;
	}
}
