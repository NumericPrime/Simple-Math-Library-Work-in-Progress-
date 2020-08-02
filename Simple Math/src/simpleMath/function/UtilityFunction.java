package simpleMath.function;

import jdk.javadoc.internal.doclets.formats.html.markup.Table;

//
//TODO Not finished
@SuppressWarnings("unused")
public class UtilityFunction {
	Function f;
	public UtilityFunction(Function f){
		this.f=f;
	}
	
	public float[] insertNumbers(float numbers[]) {
		float ret[]=new float[numbers.length];
		
		for(int i=0;i<numbers.length;i++) {
			ret[i]=f.f(numbers[i]);
		}
		return ret;
	}
}
