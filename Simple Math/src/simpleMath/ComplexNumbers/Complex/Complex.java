package simpleMath.ComplexNumbers.Complex;
public class Complex {
	float num[]= {0,0};
	public Complex(float fs) {
		num[0]=fs;
	}
	public Complex(float r,float im) {
		num[0]=r;
		num[1]=im;
	}
	public void set(Complex n) {
		num[0]=n.num[0];
		num[1]=n.num[1];
	}
	public void set(float[] n) {
		num[0]=n[0];
		num[1]=n[1];
	}
	public void set(float n) {
		num[0]=n;
		num[1]=0;
	}
	public float real() {
		return num[0];
	}
	public float imaginary() {
		return num[1];
	}
	public Complex add(Complex n) {
		return new Complex(n.real()+real(),n.imaginary()+imaginary());
	}
	public Complex multiplicate(Complex n) {
		return new Complex(n.real()*real()-n.imaginary()*n.imaginary(),real()*n.imaginary()+n.real()*imaginary());
	}
	public Complex pow(int x) {
		Complex r=this;
		Complex rer=r;
		for(int i=0;i<x;i++) rer=rer.multiplicate(r);
		return rer;		
	}
	public Complex CompConj() {
		Complex r=this;
		r.num[1]*=-1;
		return r;
	}
	public float[] toArray() {
		return num;
	}
}
