package simpleMath.function;

import simpleMath.algebra.Matrix;

public class PolynominalLinearFactor extends Polynominal{
	float values[];
	float v=1;
	PolynominalLinearFactor(float f,float[] values){
		this.values=values;
		this.v=f;
	}
	@Override
	public float calculate(float x) {
		float ret=v;
		for(int i=0;i<values.length;i++) ret*=x+values[i];
		return ret;
	}
	@Override
	public Matrix calculate(Matrix x) {
		float[][] f=new float[x.rows][x.rows];
	    for(int i=0;i<x.rows;i++) for(int j=0;j<x.rows;j++) f[i][j]=0;
		  for(int i=0;i<x.rows;i++) f[i][i]=1;
		  Matrix id=new Matrix(f);
		  Matrix ret=id.scalarm(v);
		  for(int i=0;i<values.length;i++) ret=ret.multiply(ret.add(id.scalarm(values[i])));
		return null;
	}
	@Override
	public AnalysisFunctionDouble parseToDoubleFunction() {
		return new AnalysisFunctionDouble(new FunctionDouble() {public double f(double x) {
			float va[]=values;
			float v2=v;
			double ret=v2;
			for(int i=0;i<va.length;i++) ret*=x+(double) va[i];
			return ret;
		}});
	}
	@Override
	public AnalysisFunction parseToFunction() {
		
		return new AnalysisFunction(new Function() {public float f(float x) {
			PolynominalLinearFactor f=new PolynominalLinearFactor(v,values);
			
			return f.calculate(x);
		}});
	}
	//public ParseToOtherType() {}
}
