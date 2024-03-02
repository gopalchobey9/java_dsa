package Pattern_Matching;

public class KMP {
	public   void main(String[] args) {
		String s = "acccbaaacccbaac";
		System.out.println(longestPrefix(s));
	}
	
	 public String longestPrefix(String s) {
		 int [] dp = new int [s.length()];
		 int len =0;
		  for (int i = 1; i < dp.length; ) {
			  if(s.charAt(i)==s.charAt(len)) {
				  len++;
				  dp[i]= len;
				  i++;
				  
			  }
			  else {
				  if(len>0) {
				  len = dp[len-1];
			  }
				  else {
					  i++;
					 
				  }
			  }
			
		}
		  int ln = dp[dp.length-1];
		  return s.substring(0,ln);
	    
		 
	    }

}
