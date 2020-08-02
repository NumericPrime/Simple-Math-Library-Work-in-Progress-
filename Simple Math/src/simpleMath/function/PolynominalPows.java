package simpleMath.function;

import simpleMath.algebra.Matrix;

public class PolynominalPows extends Polynominal{
	float[] data;
	PolynominalPows(float[] data){
		this.data=data;
	}
	@Override
	public float calculate(float x) {
		float ret=0;
		for(int i=0;i<data.length;i++) ret+=data[i]*Math.pow(x, i);
		return ret;
	}

	@Override
	public Matrix calculate(Matrix x) {
		Matrix ret;
			float[][] f=new float[x.rows][x.rows];
		    for(int i=0;i<x.rows;i++) for(int j=0;j<x.rows;j++) f[i][j]=0;
			  for(int i=0;i<x.rows;i++) f[i][i]=1;
			  Matrix id=new Matrix(f);
			  for(int i=0;i<x.rows;i++) f[i][i]=0;
			  ret=new Matrix(f);
			  ret.add(id.scalarm(data[0]));
			  for(int i=1;i<data.length;i++) ret.add(ret.powNormal(i).scalarm(data[i]));
		
		return null;
	}
	@Override
	public AnalysisFunctionDouble parseToDoubleFunction() {
		return new AnalysisFunctionDouble(new FunctionDouble() {public double f(double x) {
			float[] data2=data;
			float ret=0;
			for(int i=0;i<data2.length;i++) ret+=data2[i]*Math.pow(x, i);
			return ret;
			
		}});
	}
	@Override
	public AnalysisFunction parseToFunction() {
		return new AnalysisFunction(new Function() {public float f(float x) {
			PolynominalPows f=new PolynominalPows(data);
			
			return f.calculate(x);
		}});
	}
}
