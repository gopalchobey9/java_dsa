package Bit_Masking;

public class Minimum_Xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =11;
		int b =125;
		System.out.println(Min_val(a,b));
	}
	public static int CountSet(int b ) {
		int c =0;
		while(b>0) {
			b=(b&(b-1));
			c++;
		}
		return c;
		
	}
	public static int Min_val(int a , int b ) {
		
		int c = CountSet(b);
		int x =0;
		
		for(int i =31 ;i>=0&& c>0;i--) {
			if((a&(1<<i))!=0) {
				x+=(1<<i);
				c--;
			}
		}
		
		for(int i =0 ;i<=31 && c>0;i++) {
			if((a&(1<<i)) ==0) {
				x+=(1<<i);
				c--;
			}
		}
		
		return x;
		 
	}
	
}
