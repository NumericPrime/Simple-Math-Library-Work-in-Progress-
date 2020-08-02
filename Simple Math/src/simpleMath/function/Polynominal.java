package simpleMath.function;

import simpleMath.algebra.Matrix;

public abstract class Polynominal {
	abstract public float calculate(float x);
	abstract public Matrix calculate(Matrix x);
	abstract public AnalysisFunctionDouble parseToDoubleFunction();
	abstract public AnalysisFunction parseToFunction();
}
