package simpleMath.function;
import simpleMath.Exception.*;
@SuppressWarnings("unused")
public class AnalysisFunction {
float dfacc=(float) 0.0001;
float integacc=(float) 200;
Function func;
int digits=4;
public AnalysisFunction(Function f){
	func=f;
}
public float f(float x) {
	return func.f(x);
}
public float df(float x) {
	return (float) (Math.round(((f((float) (x+dfacc))-f(x))/dfacc)*Math.pow(10, digits))/Math.pow(10, digits));

}
public float df(float x,float acc) {
	return (float) (Math.round(((f((float) (x+acc))-f(x))/acc)*Math.pow(10, digits))/Math.pow(10, digits));
}
public float d2f(float x) {
	return dfToFunction().df(x);
}
public float d2f(float x,float acc) {
	return dfToFunction(acc).df(x);
}
public float d2f(float x,float acc,float acc2) {
	return dfToFunction(acc).df(x,acc2);
}
public float dnf(float deg,float x,float[] n) {
	AnalysisFunction s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction(n[i]);
	return s.f(x);
}
public AnalysisFunction dnfToFunction(float deg,float[] n) {
	AnalysisFunction s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction(n[i]);
	return s;
}
public float dnf(float deg,float x) {
	AnalysisFunction s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction();
	return s.f(x);
}
public AnalysisFunction dnfToFunction(float deg) {
	AnalysisFunction s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction();
	return s;
}
public float Integrate(float x1,float x2) {
	float step=(x2-x1)/200;
	float f=0;
	for(float i=x1;i<=x2;i+=step) f+=step*f(i);
	return f;
}
public float Integrate(float x1,float x2,float acc) {
	float step=(x2-x1)/integacc;
	float f=0;
	for(float i=x1;i<=x2;i+=step) f+=step*f(i);
	return f;
}

public float Integrate(float x) {
	boolean notw=false;
	float w=0;
	AnalysisFunction ne=this;
	long fak=1;
	for(int i=0;notw==false;i++) {
		float mat=(float) (Math.pow(x,i+1)*Math.pow(-1,i%2)/(fak)*ne.f(x));
		if((mat>=0||mat<0)&&fak>0) {w+=mat;}else {notw=true;}
		ne=ne.dfToFunction();
		fak*=i+2;
		
	}
	return w;
}
public AnalysisFunction dfToFunction() {
	final AnalysisFunction s=this;
	return new AnalysisFunction(new Function() {
		public float f(float x){
			AnalysisFunction fx=s;
			
			return fx.df(x);
		}
	});
}

public AnalysisFunction dfToFunction(final float acc) {
	final AnalysisFunction s=this;
	return new AnalysisFunction(new Function() {
		public float f(float x){
			AnalysisFunction fx=s;
			return fx.df(x,acc);
		}
	});
}
public void setH(float x) {
	dfacc=x;
}
public void setStepCount(float x) {
	integacc=x;
}
public float getH() {
	return dfacc;
}
public float getStepCount() {
	return integacc;
}
public void setDigits(int x) {
	digits=x;
}
}