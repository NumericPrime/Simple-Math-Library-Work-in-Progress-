package simpleMath;
//TODO Not working
public enum Calculator {
	C(){};
	private String rep(String input, String in, String out) {
		 // println(input+" in "+in+" out "+out);
		  String ins[]=input.split(in);
		  String ret="";
		  if (ins.length==0) return input;
		  for (int i=0; i<ins.length-1; i++) ret+=ins[i]+out;
		  ret+=ins[ins.length-1];
		  return ret;
		}
		private String calc(String inp) {
		  //println(inp);
		  //if ((inp.split("\\*")[0]==null||inp.split("\\*")[1]==null)&&inp.split("\\*").length!=2&&inp.split("\\/").length!=2&&inp.split("\\+").length!=2&&inp.split("\\-").length!=2) return null;
		  if (inp.split("\\^").length==2) if ((inp.split("\\^")[0]!=null&&inp.split("\\^")[1]!=null)) return Math.pow(Double.parseDouble(inp.split("\\^")[0]),Double.parseDouble(inp.split("\\^")[1]))+"";
		  if (inp.split("\\*").length==2) if ((inp.split("\\*")[0]!=null&&inp.split("\\*")[1]!=null)) return (Double.parseDouble(inp.split("\\*")[0])*Double.parseDouble(inp.split("\\*")[1]))+"";
		  if (inp.split("\\/").length==2) if ((inp.split("\\/")[0]!=null&&inp.split("\\/")[1]!=null)) return (Double.parseDouble(inp.split("\\/")[0])/Double.parseDouble(inp.split("\\/")[1]))+"";
		  if (inp.split("\\-").length==2) if ((inp.split("\\-")[0]!=null&&inp.split("\\-")[1]!=null)) return (Double.parseDouble(inp.split("\\-")[0])-Double.parseDouble(inp.split("\\-")[1]))+"";
		  if (inp.split("\\+").length==2) if ((inp.split("\\+")[0]!=null&&inp.split("\\+")[1]!=null)) return (Double.parseDouble(inp.split("\\+")[0])+Double.parseDouble(inp.split("\\+")[1]))+"";
		    return inp;
		}
		public double calculate(String inp) {
		  String st=" "+rep(inp," ","")+" ";
		  for (int i=0; i>-1; i++) {
		    System.out.println(st);
		    String sr1=st.replace('(', ' ').replace(')', ' ').replace('+', ' ').replace('-', ' ').replace('/', ' ').replace('*', ' ').replace('^', ' ');
		    String sr2=st.replace('+', ' ').replace('-', ' ').replace('/', ' ').replace('*', ' ').replace('^', ' ');
		    String sl[]=sr1.split(" ");
		    String sl2[]=sr2.split(" ");
		    if (sl.length<=2) i=-5;
		    for (int j=0; j<sl2.length; j++) {
		      if (sl2[j].length()>=3)
		        if (sl2[j].charAt(0)=='('&&sl2[j].charAt(sl2[j].length()-1)==')') {
		          //println(sl2[j], sl2[j].substring(1, sl2[j].length()-1), rep(st, sl2[j], sl2[j].substring(1, sl2[j].length()-1)));
		          st=rep(st, "\\("+sl2[j].substring(1, sl2[j].length()-1)+"\\)", sl2[j].substring(1, sl2[j].length()-1));
		        }
		      }
		    
		    for (int j=0; j<sl.length; j++) for (int k=0; k<sl.length; k++) {

		      if (!sl[j].equals("")&&!sl[k].equals("")) {
		    	  String stp=st;
		        st=rep(st, sl[j]+"\\^"+sl[k], calc(sl[j]+"^"+sl[k]));
		        if(!stp.contentEquals(st)) {j=sl.length+1;k=sl.length+1;}else {
		        st=rep(st, sl[j]+"\\*"+sl[k], calc(sl[j]+"*"+sl[k]));
		        if(!stp.contentEquals(st)) {j=sl.length+1;k=sl.length+1;}else {
		        st=rep(st, sl[j]+"\\/"+sl[k], calc(sl[j]+"/"+sl[k]));
		        if(!stp.contentEquals(st)) {j=sl.length+1;k=sl.length+1;}else {
		        st=rep(st, sl[j]+"\\+"+sl[k], calc(sl[j]+"+"+sl[k]));
		        if(!stp.contentEquals(st)) {j=sl.length+1;k=sl.length+1;}else {
		        st=rep(st, sl[j]+"\\-"+sl[k], calc(sl[j]+"-"+sl[k]));
		        if(!stp.contentEquals(st)) {j=sl.length+1;k=sl.length+1;}}}}}
		        System.out.println(stp+"  "+st);
		      }
		    }
		  }
		  return Double.parseDouble(st.substring(1, st.length()-1));
		}
}
