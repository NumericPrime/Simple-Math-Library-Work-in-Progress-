package simpleMath.algebra;

import simpleMath.Constants;
import simpleMath.Exception.ShapeNotWorkingException;
public class Matrix {
	public float eigenvalues[];
	public Matrix inverse;

	  public int rows, cols;
	  public float[][] matrix;
	  float[][] f=new float[rows][rows];
	  Matrix id;
	  
	  public Matrix(int r, int c) {
	    rows = r;
	    cols = c;
	    matrix = new float[rows][cols];
	    randomize();
	    
	  }
	  
	  public Matrix(float[][] m) {
	    matrix = m;
	    rows = matrix.length;
	    cols = matrix[0].length;
	    
	  }
		
	  public Matrix scalarm(float num) {
		  float[][] matrix2=new float[rows][cols];
		  for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) matrix2[i][j]=matrix[i][j]*num; 
		  return new Matrix(matrix2);
		  
	  }
	  //TODO Add a cast from float[][] to Matrix like 
	  //float a[][];
	  //Matrix m=(Matrix) a;
		@SuppressWarnings("unused")
		final public float det() {
			 
			float det=0;
			if(cols==1) det=matrix[0][0];

			if(cols==2) det=matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
			if(cols>=3) for(int i=0;i<cols;i++) det+=matrix[0][i]*Math.pow(-1, i)*createSubMatrix(0,i).det();
			return det;
		}
		
		final public float detDebug() throws ShapeNotWorkingException {
			if(matrix.length!=matrix[0].length) throw new ShapeNotWorkingException("The shapes need to be equal the matrix has "+matrix.length+" Rows and "+matrix[0].length+" Cols."); 
			
			  return det();
		}
	  public int getRows() {
		  return rows;
	  }
	  public int getCols() {
		  return cols;
	  }
	  public Matrix output() {
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        System.out.print(matrix[i][j] + " ");
	      }
	      System.out.println();
	    }
	    System.out.println();
	    return clone();
	  }
	  public Matrix T() {
		  float[][] m=new float[cols][rows];
		  for(int i=0;i<cols;i++) for(int j=0;j<rows;j++) {
			  m[i][j]=matrix[j][i];
		  }
		  return new Matrix(m);
	  }
	  public Vector vector() {
		  if(cols==1) {
			  return new Vector(T().matrix[0]);
		  }else {return null;}
		  
	  }
	  public Matrix orthagonalize() {
		  Matrix vm=this.T();
		  Vector[] x=new Vector[vm.matrix.length];
		  for(int i=0;i<x.length;i++) x[i]=new Vector(vm.matrix[i]);
		  for(int i=0;i<x.length;i++){ for(int j=0;j<i;j++) {
		  }
		  x[i]=x[i].scalarm(Math.round(1000/(float) Math.sqrt(x[i].scalarmultiply(x[i])))/1000); 
		  }
		  float retm[][]=new float[x.length][x[0].n.length];
		  for(int i=0;i<x.length;i++) retm[i]=x[i].n;
		 // System.out.println(4);
		  return (new Matrix(retm)).T();
	  }
	  public Matrix qr2() {
		  float mat[][]=new float[matrix.length][matrix[0].length];
		  Matrix vm1=T();
		  Vector[] x=new Vector[vm1.matrix.length];
		  for(int i=0;i<x.length;i++) x[i]=new Vector(vm1.matrix[i]);
		  Matrix vm2=orthagonalize().T();
		  Vector[] x2=new Vector[vm2.matrix.length];
		  for(int i=0;i<x.length;i++) x2[i]=new Vector(vm2.matrix[i]);
		  for(int i=0;i<mat.length;i++) for(int j=0;j<mat[0].length;j++) if(j>=i) {
			  mat[i][j]=x[j].scalarmultiply(x2[i]);
		  }else {
			  mat[i][j]=0;
		  }
		  return new Matrix(mat);
	   }
	  public Matrix multiply(Matrix n) {
		    Matrix result = new Matrix(rows, n.cols);
		    
		    if (cols == n.rows) {
		      for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < n.cols; j++) {
		          float sum = 0;
		          for (int k = 0; k < cols; k++) {
		            sum += matrix[i][k]*n.matrix[k][j];
		          }  
		          result.matrix[i][j] = sum;
		        }
		      }
		    }
		    return result;
		  }
	  public Matrix multiplyDebug(Vector n) throws ShapeNotWorkingException{
		    Matrix result = new Matrix(rows, n.v.cols);
		    if(cols!=n.v.rows) throw new ShapeNotWorkingException("The count of Cols of the first matrix and the count of rows of the second need to be equal they are currently "+cols+"  and "+n.v.rows+"."); 
		    if (cols == n.v.rows) {
		      for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < n.v.cols; j++) {
		          float sum = 0;
		          for (int k = 0; k < cols; k++) {
		            sum += matrix[i][k]*n.v.matrix[k][j];
		          }  
		          result.matrix[i][j] = sum;
		        }
		      }
		    }
		    return result;
		  }
	  public Matrix add(Matrix n) {
		    Matrix result = new Matrix(rows, cols);
		    //if (cols == n.cols) {
		      for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		        	result.matrix[i][j]=matrix[i][j]+n.matrix[i][j];
		        }
		      }
		    
		    return result;
		  }
		  public Matrix multiply(Vector n) {
			    Matrix result = new Matrix(rows, n.v.cols);
			    
			    if (cols == n.v.rows) {
			      for (int i = 0; i < rows; i++) {
			        for (int j = 0; j < n.v.cols; j++) {
			          float sum = 0;
			          for (int k = 0; k < cols; k++) {
			            sum += matrix[i][k]*n.v.matrix[k][j];
			          }  
			          result.matrix[i][j] = sum;
			        }
			      }
			    }
			    return result;
			  }
		  //TODO
		  public Matrix[] qr() {
			  Constants c=new Constants();
			  Matrix vm=this.T();
			  Matrix cl=clone();
			  Vector[] x=new Vector[vm.matrix.length];
			  
			  float[][] f=new float[rows][rows];
			  for(int i=0;i<rows;i++) for(int j=0;j<rows;j++) f[i][j]=0;
			  for(int i=0;i<rows;i++) f[i][i]=1;
			  Matrix id=new Matrix(f);
			  for(int i=0;i<rows;i++) x[i]=new Vector(vm.matrix[i]);
			  Matrix red=id;
			  float v[]=new float[rows];
			  for(int k=0;k<cols;k++) {
				  for(int i=0;i<cols;i++) v[i]=0;
				  float sg=(cl.matrix[k][k])< 0 ? -1 : 1;
				  float s=0;
				  
				  for(int i=k;i<cols;i++) s+=cl.matrix[i][k]*cl.matrix[i][k];
				  //s=(new Vector(v)).scalarmultiply(new Vector(v));
				  float tmp=(float) (sg*Math.sqrt(s));
				  v[k]=tmp+ cl.matrix[k][k];
				  tmp=(float)Math.sqrt(2*(s+cl.matrix[k][k]*tmp));
				  v[k]/=tmp;
				  
				  for(int i=k+1;i<rows;i++) v[i]=(float) (cl.matrix[i][k]/tmp);
				  //cl.inscribe(k, 1/tmp);
				  //red.multiply(red.add(x[k].v.multiply(new Vector(v).v.T()).scalarm(-1)));
				  
				  for(int j = 0; j < cols; j++) {
					  //s=(new Vector(v)).scalarmultiply(cl.parse()[j]);
					  s = 0;
			            for(int i = k; i < rows; i++) {
			                s += v[i]*cl.matrix[i][j];
			            }
			            for(int i = k; i < rows; i++) {
			            	cl.matrix[i][j] -= 2*v[i]*s;
			            }
			        }
				  for(int j = 0; j < rows; j++) {
			            s = 0;
			            for(int i = k; i < rows; i++) {
			                s += v[i]*red.matrix[i][j];
			            }
			            //s=(new Vector(v)).scalarmultiply(red.parse()[j]);
			            for(int i = k; i < rows; i++) {
			            	red.matrix[i][j] -= 2*v[i]*s;
			            }
			        } 
			  }
			  return new Matrix[] {red.T(),cl};
		  }
		  public float[] eigenvalue() {
			  f=new float[rows][rows];
			    for(int i=0;i<rows;i++) for(int j=0;j<rows;j++) f[i][j]=0;
				  for(int i=0;i<rows;i++) f[i][i]=1;
				  id=new Matrix(f);
			  Matrix it=clone();
			  for(int i=0;i>-1;i++) {
				  Matrix erg[]=it.qr();
				  it=erg[1].multiply(erg[0]).add(id.scalarm(0));
			  boolean ret=true;
			  for(int j=0;j<rows;j++) for(int k=0;k<rows;k++) if(Math.abs(erg[0].matrix[j][k])-(k==j? 1:0)>0.00001) ret=false;
			  i=(ret==true)?-5:i;
			  }
			  float p[]= new float[cols];
			  for(int i=0;i<cols;i++) p[i]=it.matrix[i][i];
			  eigenvalues=p;
			  return p;
		  }
		 public Matrix inverse() {
			  return cofactor().T().scalarm(1/det());
		  }
		 
		 public Vector eigenvector(float eigenvalue) {
			 f=new float[rows][rows];
			    for(int i=0;i<rows;i++) for(int j=0;j<rows;j++) f[i][j]=0;
				  for(int i=0;i<rows;i++) f[i][i]=1;
				  id=new Matrix(f);
				  float[] d=new float[cols];
		 for(int i=0;i<d.length;i++) d[i]=(float) Math.sqrt(1/d.length);
		 if(clone().add(id.scalarm(-eigenvalue)).det()==0) return eigenvector((float) (eigenvalue-0.00001));
		 Matrix exp=clone().add(id.scalarm(-eigenvalue)).inverse();
		 
		 //Matrix rv=exp.powNormal(100);
		 for(int i=0;i<d.length;i++) d[i]=(float) Math.sin(i);
		 Vector d2=new Vector(d);
		 for(int i=0;i<20;i++) {d2=exp.multiply(d2).vector();d2=d2.scalarm(1/(float) Math.sqrt(d2.scalarmultiply(d2)));}
		 
		 return d2;
			 
			// return null;
		 }
		 public Vector eigenvector_optionalin(float eigenvalue,Vector b) {
			 f=new float[rows][rows];
			    for(int i=0;i<rows;i++) for(int j=0;j<rows;j++) f[i][j]=0;
				  for(int i=0;i<rows;i++) f[i][i]=1;
				  id=new Matrix(f);
		 if(clone().add(id.scalarm(-eigenvalue)).det()==0) return eigenvector((float) (eigenvalue-0.00001));
		 Matrix exp=clone().add(id.scalarm(-eigenvalue)).inverse();
		 
		 //Matrix rv=exp.powNormal(100);
		 Vector d2=b;
		 for(int i=0;i<50;i++) {d2=exp.multiply(d2).vector();d2=d2.scalarm(1/(float) Math.sqrt(d2.scalarmultiply(d2)));}
		 
		 return d2;
			 
			// return null;
		 }
		 public Vector[] eigenvectors() {
			 float[] eigen=eigenvalue();
			 Vector c[]=parse();
			 for(int i=0;i<c.length;i++) c[i]=eigenvector_optionalin(eigen[i],c[i]);
			 return c;
		 }
		 //TODO Warning: Not working
		 public Matrix diagonalize() {
			 return assambly(eigenvectors()).orthagonalize();
		 }
		 public Matrix powNormal(int j) {
			 Matrix ret=clone();
			 if(j>0) {
			 for(int i=0;i<j;i++) ret.multiply(clone());}
			 if(j==0) {
				 f=new float[rows][rows];
				    for(int i=0;i<rows;i++) for(int j2=0;j2<rows;j2++) f[i][j2]=0;
					  for(int i=0;i<rows;i++) f[i][i]=1;
					  ret=new Matrix(f);
			 }
			if(j<0) return inverse().powNormal(-j);
			return ret;
		 }
		  public Vector[] parse() {
			  Vector[] x=new Vector[matrix[0].length];
			  for(int i=0;i<x.length;i++) x[i]=new Vector(T().matrix[i]);
			  return x;
		  }
		  public void inscribe(int i,float w) {
			  for(int j=0;j<cols;j++) matrix[j][i]*=w;
		  }
		  public Matrix assambly(Vector[] v) {
			  float matrix2[][]=new float[v.length][v[0].n.length];
			  for(int i=0;i<matrix.length;i++) matrix2[i]=v[i].n;
			  (new Matrix(matrix)).T();
			  //matrix=matrix2;
			  //T();
			  return new Matrix(matrix2).T();
		  }
		  
		  public Matrix multiplyDebug(Matrix n) throws ShapeNotWorkingException{
			    Matrix result = new Matrix(rows, n.cols);
			    if(cols!=n.rows) throw new ShapeNotWorkingException("The count of Cols of the first matrix and the count of rows of the second need to be equal they are currently "+cols+"  and "+n.rows+"."); 
			    if (cols == n.rows) {
			      for (int i = 0; i < rows; i++) {
			        for (int j = 0; j < n.cols; j++) {
			          float sum = 0;
			          for (int k = 0; k < cols; k++) {
			            sum += matrix[i][k]*n.matrix[k][j];
			          }  
			          result.matrix[i][j] = sum;
			        }
			      }
			    }
			    return result;
			  }
		  
		  
	  public void randomize() {
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        matrix[i][j] = (float) Math.random();
	      }
	    }
	  }
	  public  Matrix cofactor() {
		    Matrix mat = new Matrix((int) getRows(), (int)getCols());
		    for (int i=0;i<getRows();i++) {
		        for (int j=0; j<getCols();j++) {
		            mat.matrix[i][j]= (float) (Math.pow(-1,i) * Math.pow(-1,j) * 
		            		createSubMatrix(i, j).det());
		        }
		    }
		    
		    return mat;
		}
	  public Matrix createSubMatrix(int i2,int j2) {
		  Matrix m=new Matrix(rows-1,cols-1);
		  for(int i=0;i<i2;i++) for(int j=0;j<j2;j++) m.matrix[i][j]=matrix[i][j];
		  if(j2!=cols-1) for(int i=0;i<i2;i++) for(int j=j2+1;j<rows;j++) m.matrix[i][j-1]=matrix[i][j];
		  if(i2!=rows-1) {for(int i=i2+1;i<rows;i++) for(int j=0;j<j2;j++) m.matrix[i-1][j]=matrix[i][j];
		  if(j2!=cols-1) for(int i=i2+1;i<rows;i++) for(int j=j2+1;j<rows;j++) m.matrix[i-1][j-1]=matrix[i][j];}

		  
		  return m;
		  
	  }
	  public float[] toArray() {
	    float[] arr = new float[rows*cols];
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        arr[j+i*cols] = matrix[i][j];
	      }
	    }
	    return arr;
	  }

	  public Matrix clone() {
	    Matrix clone = new Matrix(rows, cols);
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        clone.matrix[i][j] = matrix[i][j];
	      }
	    }
	    return clone;
	  }
	  public int[] getShape() {
		  return new int[] {rows,cols};
	  }
	}