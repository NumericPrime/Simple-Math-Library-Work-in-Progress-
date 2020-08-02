package simpleMath.algebra;

import simpleMath.Exception.ShapeNotWorkingException;

public class Vector {
	public Matrix v;
	float[] n= {};
	public Vector(float[] n) {
		this.n=n;
		float f[][]= {n};
		v=(new Matrix(f)).T();
	}
	public Vector add(Vector v2) {
		float r[]=new float[n.length];
		for(int i=0;i<r.length;i++) r[i]=n[i]+v2.n[i];
		return new Vector(r);
	}
	public float scalarmultiply(Vector v2) {
		return v.T().multiply(v2.v).matrix[0][0];
	}
	public Matrix matrix() {
		return v;
		
	}
	public Vector scalarm(float n) {
		return v.scalarm(n).vector();
	}
	public Vector output() {
		v.output();
		return v.vector();
	}
	  public Vector multiply(Matrix n) {
		    Matrix result = new Matrix(v.rows, n.cols);
		    
		    if (v.cols == n.rows) {
		      for (int i = 0; i < v.rows; i++) {
		        for (int j = 0; j < n.cols; j++) {
		          float sum = 0;
		          for (int k = 0; k < v.cols; k++) {
		            sum += v.matrix[i][k]*n.matrix[k][j];
		          }  
		          result.matrix[i][j] = sum;
		        }
		      }
		    }
		    return result.vector();
		  }
	  public Vector multiplyDebug(Vector n) throws ShapeNotWorkingException{
		    Matrix result = new Matrix(v.rows, n.v.cols);
		    if(v.cols!=n.v.rows) throw new ShapeNotWorkingException("The count of Cols of the first matrix and the count of rows of the second need to be equal they are currently "+v.cols+"  and "+n.v.rows+"."); 
		    if (v.cols == n.v.rows) {
		      for (int i = 0; i < v.rows; i++) {
		        for (int j = 0; j < n.v.cols; j++) {
		          float sum = 0;
		          for (int k = 0; k < v.cols; k++) {
		            sum += v.matrix[i][k]*n.v.matrix[k][j];
		          }  
		          result.matrix[i][j] = sum;
		        }
		      }
		    }
		    return result.vector();
		  }
}
