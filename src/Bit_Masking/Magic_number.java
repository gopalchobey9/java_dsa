package Bit_Masking;

public class Magic_number {
	
//	A magic number is defined as a number 
//	which can be expressed as a power of 5 or sum of unique powers of 5. 
//	First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5),

	public static void main(String[] args) {
		int n =12;
		 int  mul =5;
		  int sum =0;
		  while(n>0) {
			  if((n&1)!=0) {
				  sum+=mul;
			  
			  }
			  n>>=1;
			  mul*=5;
			  
		  }
		  System.out.println(sum);
		  
	}
	 
}
