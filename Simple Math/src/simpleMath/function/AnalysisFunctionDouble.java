package simpleMath.function;
import simpleMath.Exception.*;
@SuppressWarnings("unused")
public class AnalysisFunctionDouble {
float dfacc=(float) 0.0001;
float integacc=(float) 200;
FunctionDouble func;
int digits=4;
public AnalysisFunctionDouble(FunctionDouble f){
	func=f;
}
public double f(double x) {
	return func.f(x);
}
public double df(double x) {
	return (float) (Math.round(((f((float) (x+dfacc))-f(x))/dfacc)*Math.pow(10, digits))/Math.pow(10, digits));

}
public double df(double x,double acc) {
	return (Math.round(((f((float) (x+acc))-f(x))/acc)*Math.pow(10, digits))/Math.pow(10, digits));
}
public double d2f(float x) {
	return dfToFunction().df(x);
}
public double d2f(float x,float acc) {
	return dfToFunction(acc).df(x);
}
public double d2f(float x,float acc,float acc2) {
	return dfToFunction(acc).df(x,acc2);
}
public double dnf(float deg,float x,float[] n) {
	AnalysisFunctionDouble s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction(n[i]);
	return s.f(x);
}
public AnalysisFunctionDouble dnfToFunction(float deg,float[] n) {
	AnalysisFunctionDouble s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction(n[i]);
	return s;
}
public double dnf(float deg,float x) {
	AnalysisFunctionDouble s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction();
	return s.f(x);
}
public AnalysisFunctionDouble dnfToFunction(float deg) {
	AnalysisFunctionDouble s=this;
	for(int i=0;i<deg;i++) s=s.dfToFunction();
	return s;
}
public float Integrate(float x1,float x2) {
	float step=(x2-x1)/integacc;
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
	AnalysisFunctionDouble ne=this;
	long fak=1;
	for(int i=0;notw==false;i++) {
		float mat=(float) (Math.pow(x,i+1)*Math.pow(-1,i%2)/(fak)*ne.f(x));
		if((mat>=0||mat<0)&&fak>0) {w+=mat;}else {notw=true;}
		ne=ne.dfToFunction();
		fak*=i+2;
		
	}
	return w;
}
public AnalysisFunctionDouble dfToFunction() {
	final AnalysisFunctionDouble s=this;
	return new AnalysisFunctionDouble(new FunctionDouble() {
		public double f(double x){
			AnalysisFunctionDouble fx=s;
			
			return fx.df(x);
		}
	});
}

public AnalysisFunctionDouble dfToFunction(final float acc) {
	final AnalysisFunctionDouble s=this;
	return new AnalysisFunctionDouble(new FunctionDouble() {
		public double f(double x){
			AnalysisFunctionDouble fx=s;
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
public double getH() {
	return dfacc;
}
public double getStepCount() {
	return integacc;
}
public void setDigits(int x) {
	digits=x;
}
public int getDigits(int x) {
	return digits;
}
}