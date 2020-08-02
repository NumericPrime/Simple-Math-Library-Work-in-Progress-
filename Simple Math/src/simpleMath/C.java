package simpleMath;
public enum C {

	ARRAY{
		public int[] add( int[] a, int[] b ) {
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			int[] ret=new int[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]+b[i];
			return ret; } 
		public float[] add( float[] a, float[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]+b[i];
			return ret;  } 
		public double[] add( double[] a, double[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			double[] ret=new double[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]+b[i];
			return ret;  }
		
		public int[] subtract( int[] a, int[] b ) {
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			int[] ret=new int[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]-b[i];
			return ret; } 
		public float[] subtract( float[] a, float[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]-b[i];
			return ret;  } 
		public double[] subtract( double[] a, double[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			double[] ret=new double[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]-b[i];
			return ret;  } 
		
		public int[] multiply( int[] a, int[] b ) {
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			int[] ret=new int[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]*b[i];
			return ret; } 
		public float[] multiply( float[] a, float[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]*b[i];
			return ret;  } 
		public double[] multiply( double[] a, double[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			double[] ret=new double[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]*b[i];
			return ret;  }
		
		public int[] divide( int[] a, int[] b ) {
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			int[] ret=new int[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]/b[i];
			return ret; } 
		public float[] divide( float[] a, float[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]/b[i];
			return ret;  } 
		public double[] divide( double[] a, double[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			double[] ret=new double[a.length];
			for(int i=0;i<a.length;i++) ret[i]=a[i]/b[i];
			return ret;  } 
		
		public int[] multiply( int a, int[] b ) {int[] ret=new int[b.length];
			for(int i=0;i<b.length;i++) ret[i]=a*b[i];
			return ret; } 
		public float[] multiply( float a, float[] b ) { float[] ret=new float[b.length];
			for(int i=0;i<b.length;i++) ret[i]=a*b[i];
			return ret;  } 
		public double[] multiply( double a, double[] b ) {
			double[] ret=new double[b.length];
			for(int i=0;i<b.length;i++) ret[i]=a*b[i];
			return ret;  } 
		
		public int[] pow( int[] a, int[] b ) {
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			int[] ret=new int[b.length];
			for(int i=0;i<b.length;i++) ret[i]=(int) Math.pow(a[i],b[i]);
			return ret; } 
		public float[] pow( float[] a, float[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[b.length];
			for(int i=0;i<b.length;i++) ret[i]=(float) Math.pow(a[i],b[i]);
			return ret;  } 
		public double[] pow( double[] a, double[] b ) { 
			if(a.length!=b.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			double[] ret=new double[b.length];
			for(int i=0;i<b.length;i++) ret[i]=Math.pow(a[i],b[i]);
			return ret;  } 
		
		public int[] pow( int a, int[] b ) {
			
			int[] ret=new int[b.length];
			for(int i=0;i<b.length;i++) ret[i]=(int) Math.pow(a,b[i]);
			return ret; } 
		public float[] pow( float a, float[] b ) { 
			
			float[] ret=new float[b.length];
			for(int i=0;i<b.length;i++) ret[i]=(float) Math.pow(a,b[i]);
			return ret;  } 
		public double[] pow( double a, double[] b ) { 
			
			double[] ret=new double[b.length];
			for(int i=0;i<b.length;i++) ret[i]=Math.pow(a,b[i]);
			return ret;  }
		
		public int[] pow( int[] a, int b ) {
			
			int[] ret=new int[a.length];
			for(int i=0;i<a.length;i++) ret[i]=(int) Math.pow(a[i],b);
			return ret; } 
		public float[] pow( float[] a, float b ) { 
			//if(a.length!=a.length) System.out.println("The size of the 2 arrays must be equal they are:"+a.length+" and "+b.length);
			float[] ret=new float[a.length];
			for(int i=0;i<a.length;i++) ret[i]=(float) Math.pow(a[i],b);
			return ret;  } 
		public double[] pow( double[] a, double b ) { 
			
			double[] ret=new double[a.length];
			for(int i=0;i<a.length;i++) ret[i]=Math.pow(a[i],b);
			return ret;  }
		
		public int[] swap( int[] array,int a, int b ) {
			
			int zw=array[b];
			array[b]=array[a];
			array[a]=zw;
			return array; 
			} 
		public float[] swap( float[] array,int a, int b ) {
			
			float zw=array[b];
			array[b]=array[a];
			array[a]=zw;
			return array; 
			} 
		public double[] swap( double[] array,int a, int b ) {
			
			double zw=array[b];
			array[b]=array[a];
			array[a]=zw;
			return array; 
			} 
		
		public int[] permute( int[] array,int[] p) {
			if(array.length!=p.length) System.out.println("The size of the 2 arrays must be equal they are:"+array.length+" and "+p.length);
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[p[i]]=array[i];
			return reta; 
			}
		public float[] permute( float[] array,int[] p) {
			if(array.length!=p.length) System.out.println("The size of the 2 arrays must be equal they are:"+array.length+" and "+p.length);
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[p[i]]=array[i];
			return reta; 
			} 
		public double[] permute( double[] array,int[] p) {
			if(array.length!=p.length) System.out.println("The size of the 2 arrays must be equal they are:"+array.length+" and "+p.length);
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[p[i]]=array[i];
			return reta; 
			} 
		
		
		
		
		public int[] sin( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.sin(array[i]);
			return reta; 
			}
		public float[] sin( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.sin(array[i]);
			return reta; 
			}
		public double[] sin( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.sin(array[i]);
			return reta; 
			}
		
		public int[] cos( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.cos(array[i]);
			return reta; 
			}
		public float[] cos( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.cos(array[i]);
			return reta; 
			}
		public double[] cos( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.cos(array[i]);
			return reta; 
			}
		
		public int[] tan( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.tan(array[i]);
			return reta; 
			}
		public float[] tan( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.tan(array[i]);
			return reta; 
			}
		public double[] tan( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.tan(array[i]);
			return reta; 
			}
		
		public int[] abs( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.abs(array[i]);
			return reta; 
			}
		public float[] abs( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.abs(array[i]);
			return reta; 
			}
		public double[] abs( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.abs(array[i]);
			return reta; 
			}
		
		public int[] asin( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.asin(array[i]);
			return reta; 
			}
		public float[] asin( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.asin(array[i]);
			return reta; 
			}
		public double[] asin( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.asin(array[i]);
			return reta; 
			}
		
		public int[] acos( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.acos(array[i]);
			return reta; 
			}
		public float[] acos( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.acos(array[i]);
			return reta; 
			}
		public double[] acos( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.acos(array[i]);
			return reta; 
			}
		
		public int[] atan( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.atan(array[i]);
			return reta; 
			}
		public float[] atan( float[] array) {
			float[] reta = new float[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(float) Math.atan(array[i]);
			return reta; 
			}
		public double[] atan( double[] array) {
			double[] reta = new double[array.length];
			for(int i=0;i<array.length;i++) reta[i]=Math.atan(array[i]);
			return reta; 
			}
		
		public int[] floor( int[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.floor(array[i]);
			return reta; 
			}
		public int[] floor( float[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]= (int) Math.floor(array[i]);
			return reta; 
			}
		public int[] floor( double[] array) {
			int[] reta = new int[array.length];
			for(int i=0;i<array.length;i++) reta[i]=(int) Math.floor(array[i]);
			return reta; 
			}
		
	};
	abstract public int[] add( int[] a, int[] b );
	abstract public float[] add( float[] a, float[] b );
	abstract public double[] add( double[] a, double[] b );
	
	abstract public int[] subtract( int[] a, int[] b );
	abstract public float[] subtract( float[] a, float[] b );
	abstract public double[] subtract( double[] a, double[] b );
	
	abstract public int[] multiply( int[] a, int[] b );
	abstract public float[] multiply( float[] a, float[] b );
	abstract public double[] multiply( double[] a, double[] b );
	
	abstract public int[] divide( int[] a, int[] b );
	abstract public float[] divide( float[] a, float[] b );
	abstract public double[] divide( double[] a, double[] b );
	
	abstract public int[] multiply( int a, int[] b );
	abstract public float[] multiply( float a, float[] b );
	abstract public double[] multiply( double a, double[] b );
	
	abstract public int[] pow( int[] a, int[] b );
	abstract public float[] pow( float[] a, float[] b );
	abstract public double[] pow( double[] a, double[] b );
	
	abstract public int[] pow( int a, int[] b );
	abstract public float[] pow( float a, float[] b );
	abstract public double[] pow( double a, double[] b );
	
	abstract public int[] pow( int[] a, int b );
	abstract public float[] pow( float[] a, float b );
	abstract public double[] pow( double[] a, double b );
	
	abstract public int[] swap( int[] array,int a, int b );
	abstract public float[] swap( float[] array,int a, int b );
	abstract public double[] swap( double[] array,int a, int b );
	
	abstract public int[] permute( int[] array,int[] p);
	abstract public float[] permute( float[] array,int[] p);
	abstract public double[] permute( double[] array,int[] p);
	
	abstract public int[] sin( int[] array);
	abstract public float[] sin( float[] array);
	abstract public double[] sin( double[] array);
	
	abstract public int[] cos( int[] array);
	abstract public float[] cos( float[] array);
	abstract public double[] cos( double[] array);
	
	abstract public int[] tan( int[] array);
	abstract public float[] tan( float[] array);
	abstract public double[] tan( double[] array);

	abstract public int[] abs( int[] array);
	abstract public float[] abs( float[] array);
	abstract public double[] abs( double[] array);

	abstract public int[] asin( int[] array);
	abstract public float[] asin( float[] array);
	abstract public double[] asin( double[] array);
	
	abstract public int[] acos( int[] array);
	abstract public float[] acos( float[] array);
	abstract public double[] acos( double[] array);
	
	abstract public int[] atan( int[] array);
	abstract public float[] atan( float[] array);
	abstract public double[] atan( double[] array);
	
	abstract public int[] floor( int[] array);
	abstract public int[] floor( float[] array);
	abstract public int[] floor( double[] array);
}
